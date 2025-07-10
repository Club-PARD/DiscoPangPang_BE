package com.pard.server.discoPangPang_BE.project.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pard.server.discoPangPang_BE.project.dto.ProjectRequest;
import com.pard.server.discoPangPang_BE.star.entity.Star;
import com.pard.server.discoPangPang_BE.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @Column(length = 36)
    private String id;

    private String projectName;

    @Column(name = "start_date_time", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time", nullable = false)
    private LocalDateTime endDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectTag> projectTags = new ArrayList<>();

    @OneToOne(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Star star;

    // update 메서드
    public void update(ProjectRequest.ProjectUpdateRequest req) {
        if (req.getProjectName() != null) {
            this.projectName = req.getProjectName();
        }
        if (req.getStartDateTime() != null) {
            this.startDateTime = req.getStartDateTime();
        }
        if (req.getEndDateTime() != null) {
            this.endDateTime = req.getEndDateTime();
        }
    }

    @Builder
    public Project(String id, String projectName, LocalDateTime startDateTime, LocalDateTime endDateTime, User user) {
        this.id = id;
        this.projectName = projectName;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.user = user;
    }
}





