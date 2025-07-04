package com.pard.server.discoPangPang_BE.project.entity;



import com.pard.server.discoPangPang_BE.label.entity.Label;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "label_id")
    private Label label;

    public ProjectTag(Project project, Label label) {
        this.project = project;
        this.label = label;
    }
}





