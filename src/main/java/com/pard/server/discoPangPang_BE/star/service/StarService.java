package com.pard.server.discoPangPang_BE.star.service;



import com.pard.server.discoPangPang_BE.project.entity.Project;
import com.pard.server.discoPangPang_BE.project.repo.ProjectRepo;
import com.pard.server.discoPangPang_BE.star.dto.StarRequest;
import com.pard.server.discoPangPang_BE.star.entity.Star;
import com.pard.server.discoPangPang_BE.star.repo.StarRepo;
import com.pard.server.discoPangPang_BE.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StarService {
    private final UserRepo userRepo;
    private final ProjectRepo projectRepo;
    private final StarRepo starRepo;

    public Long createStar(StarRequest.StarCreateRequest req) {
        Project project = projectRepo.findById(req.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));

        Star star = Star.builder()
                .s(req.getS())
                .t(req.getT())
                .a(req.getA())
                .r(req.getR())
                .l(req.getL())
                .project(project)
                .build();

        starRepo.save(star);
        return star.getId();
    }

    @Transactional
    public void updateStar(Long starId, StarRequest.StarUpdateRequest req) {
        Star star = starRepo.findById(starId)
                .orElseThrow(() -> new RuntimeException("생성된 star 구조 없음"));


        // 값 수정
        star.setS(req.getS());
        star.setT(req.getT());
        star.setA(req.getA());
        star.setR(req.getR());
        star.setL(req.getL());
    }

//
//    public List<ProjectResponse.ProjectReadResponse> findByWriter(Long userId) {
//        return ProjectMapper.toDtoList(projectRepo.findAllByUserId(userId));
//    }
//
//    @Transactional
//    public void updateProject(Long projectId, ProejctRequest.ProjectUpdateRequest req, Long userId) {
//        Project project = projectRepo.findById(projectId)
//                .orElseThrow(() -> new RuntimeException("블로그 없음"));
//        if (!project.getUser().getId().equals(userId)) {
//            throw new RuntimeException("작성자만 수정 가능");
//        }
//        project.updateFilename(req.getFilename());
//
//        if (req.getFilename() != null) {
//            project.updateFilename(req.getFilename());
//        }
//    }
//
//    public void deleteProject(Long projectId, Long userId) {
//        Project project = projectRepo.findById(projectId)
//                .orElseThrow(() -> new RuntimeException("블로그 없음"));
//        if (!project.getUser().getId().equals(userId)) {
//            throw new RuntimeException("작성자만 삭제 가능");
//        }
//        projectRepo.delete(project);
//    }
//
//    public List<ProjectResponse.ProjectReadResponse> readAllProjects() {
//        List<Project> projects = projectRepo.findAll();
//        return projects.stream()
//                .map(ProjectResponse.ProjectReadResponse::from)
//                .toList();
//    }
}
