package com.pard.server.discoPangPang_BE.label.repo;


import com.pard.server.discoPangPang_BE.label.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface LabelRepo extends JpaRepository<Label, Long> {
    Optional<Label> findByLabelNameAndLabelCategory(String tagName, String tagCategory);

    @Query("SELECT pt.label FROM ProjectTag pt WHERE pt.project.id = :projectId")
    List<Label> findAllByProjectId(@Param("projectId") String projectId);

}
