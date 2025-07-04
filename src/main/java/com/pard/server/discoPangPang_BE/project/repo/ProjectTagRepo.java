package com.pard.server.discoPangPang_BE.project.repo;

import com.pard.server.discoPangPang_BE.label.entity.Label;
import com.pard.server.discoPangPang_BE.project.entity.Project;
import com.pard.server.discoPangPang_BE.project.entity.ProjectTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectTagRepo extends JpaRepository<ProjectTag, Long> {
    //특정 프로젝트의 모든 태그 연결 삭제
    void deleteByProject(Project project);
}
