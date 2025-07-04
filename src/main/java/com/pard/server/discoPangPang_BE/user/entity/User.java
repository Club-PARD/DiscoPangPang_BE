package com.pard.server.discoPangPang_BE.user.entity;

//import com.pard.server.discoPangPang_BE.member.domain.Role;
import com.pard.server.discoPangPang_BE.project.entity.Project;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String email;

//    @Enumerated(EnumType.STRING)
//    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> project;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Likes> likes;
//
    public void update(String name) {
        this.name = name;
    } //소셜 로그인 시 이름이 바뀌었을 경우 최신화
}
