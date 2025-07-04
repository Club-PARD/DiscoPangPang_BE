package com.pard.server.discoPangPang_BE.project.entity;


import com.pard.server.discoPangPang_BE.star.entity.Star;
import com.pard.server.discoPangPang_BE.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//primary key

    private String projectName;//프로젝트의 이름
    private String insight;//인사이트를 기록할 수 있는 변수

    @Column(nullable = false)
    private String status;// 프로그램의 상태를 나타내주는 변수 예) not_started, in_progress, answering, completed
    /*하드 코딩하지 않기 -> 추후에 수정 예정*/


    @Column(name = "start_date_time", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time", nullable = false)
    private LocalDateTime endDateTime;


    @ManyToOne(fetch = FetchType.LAZY) //earger 방식이 아닌 lazy 방식
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectTag> projectTags = new ArrayList<>();

    @OneToOne(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private Star star;

    public static Project from(String projectName, String insight, LocalDateTime endDateTime, User user) {
        return Project.builder()
                .projectName(projectName)
                .insight(insight)
                .endDateTime(endDateTime)
                .user(user)
                .projectTags(new ArrayList<>())
                .status("not_started")
                .build();
    }




}




