package com.pard.server.discoPangPang_BE.project.repo;


import com.pard.server.discoPangPang_BE.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ProjectRepo extends JpaRepository<Project, String> {
//    List<Project> findByUserIdAndStatusIn(Long userId, List<String> statusList);


    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.star WHERE p.id = :projectId")
    List<Project> findAllByUserIdWithStar(@Param("userId") Long userId);


}
