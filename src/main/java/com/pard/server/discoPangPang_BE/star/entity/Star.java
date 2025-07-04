package com.pard.server.discoPangPang_BE.star.entity;


import com.pard.server.discoPangPang_BE.project.entity.Project;
import com.pard.server.discoPangPang_BE.star.dto.StarRequest;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Star {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = true)
    private String s;//상황

    @Setter
    @Column(nullable = true)
    private String t;//과제

    @Setter
    @Column(nullable = true)
    private String a;//행동

    @Setter
    @Column(nullable = true)
    private String r;//결과

    @Setter
    @Column(nullable = true)
    private String l;//배울점

    /*setter를 쓰는것은 현재로서는 바람직하지 않은 다만 쉬운 코딩*/


    @OneToOne(fetch = FetchType.LAZY) //earger 방식이 아닌 lazy 방식
    @JoinColumn(name = "project_id")
    private Project project;


}
