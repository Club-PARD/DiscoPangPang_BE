package com.pard.server.discoPangPang_BE.project.repo;


import com.pard.server.discoPangPang_BE.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProjectRepo extends JpaRepository<Project, Long> {
//    List<Project> findByUserIdAndStatusIn(Long userId, List<String> statusList);
List<Project> findAllByUserId(Long userId);


}
