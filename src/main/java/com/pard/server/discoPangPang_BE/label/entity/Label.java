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

}

