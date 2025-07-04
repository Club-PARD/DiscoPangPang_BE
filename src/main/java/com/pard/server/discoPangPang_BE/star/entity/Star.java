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


    @Column(nullable = true)
    private String s;//상황


    @Column(nullable = true)
    private String t;//과제


    @Column(nullable = true)
    private String a;//행동


    @Column(nullable = true)
    private String r;//결과


    @Column(nullable = true)
    private String l;//배울점


    @OneToOne(fetch = FetchType.LAZY) //earger 방식이 아닌 lazy 방식
    @JoinColumn(name = "project_id")
    private Project project;

    public void update(String s, String t, String a, String r, String l) {
        this.s = s;
        this.t = t;
        this.a = a;
        this.r = r;
        this.l = l;
    }


}
