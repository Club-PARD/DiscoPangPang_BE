package com.pard.server.discoPangPang_BE.label.entity;



import com.pard.server.discoPangPang_BE.project.entity.ProjectTag;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String labelName;
    private String labelCategory;

    @OneToMany(mappedBy = "label", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectTag> projectTags; // 복수형 권장

    public Label(String labelName, String labelCategory) {
        this.labelName = labelName;
        this.labelCategory = labelCategory;
    }

    @Override //부모 클래스나 인터페이스로부터 상속받은 메서드를 재정의할 때 사용하는 어노테이션
    public boolean equals(Object o) {
        if (this == o) return true; //자기 자신과 비교해서 항상 true를 반환하여 끝내기 위함 / 빠른 속도
        if (!(o instanceof Label)) return false; // 옳은 형식으로 받아왔는가를 확인
        Label label = (Label) o;
        return Objects.equals(labelName, label.labelName) &&
                Objects.equals(labelCategory, label.labelCategory);
    }

    /*객체를 빠르게 찾기 위한 코드 번호를 만들어주는 함수*/
    @Override
    public int hashCode() {
        return Objects.hash(labelName, labelCategory);
    }
}

