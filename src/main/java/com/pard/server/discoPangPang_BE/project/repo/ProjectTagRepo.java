package com.pard.server.discoPangPang_BE.project.repo;


import com.pard.server.discoPangPang_BE.project.dto.FlatLabelProjectInfo;
import com.pard.server.discoPangPang_BE.project.dto.LabelCountDto;
import com.pard.server.discoPangPang_BE.project.entity.Project;
import com.pard.server.discoPangPang_BE.project.entity.ProjectTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProjectTagRepo extends JpaRepository<ProjectTag, Long> {
    //특정 프로젝트의 모든 태그 연결 삭제
    void deleteByProject(Project project);

//    Optional<ProjectTag> findByProjectAndLabel(Project project, Label label);

    @Query("SELECT l.labelName AS labelName, COUNT(l) AS count " +
            "FROM ProjectTag pt " +
            "JOIN pt.project p " +
            "JOIN pt.label l " +
            "WHERE p.user.id = :userId AND l.labelCategory = :category " +
            "GROUP BY l.labelName")
    List<LabelCountDto> countLabelsByCategoryName(
            @Param("userId") Long userId,
            @Param("category") String category);

    @Query("SELECT l.labelName AS labelName, " +
            "       p.id AS projectId, " +
            "       p.projectName AS projectName, " +
            "       p.startDateTime AS startDateTime, " +
            "       p.endDateTime AS endDateTime " +
            "FROM ProjectTag pt " +
            "JOIN pt.project p " +
            "JOIN pt.label l " +
            "WHERE l.labelCategory = :category")
    List<FlatLabelProjectInfo> findFlatProjectInfosByCategory(@Param("category") String category);


}
