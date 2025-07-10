package com.pard.server.discoPangPang_BE.project.service;



import com.pard.server.discoPangPang_BE.project.dto.ProjectRequest;
import com.pard.server.discoPangPang_BE.project.dto.ProjectResponse;
import com.pard.server.discoPangPang_BE.project.entity.Project;
import com.pard.server.discoPangPang_BE.project.repo.ProjectRepo;
import com.pard.server.discoPangPang_BE.user.entity.User;
import com.pard.server.discoPangPang_BE.user.repo.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final UserRepo userRepo;
    private final ProjectRepo projectRepo;

    public void createProject(Long userId , ProjectRequest.ProjectCreateRequest req) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        Project project = Project.builder()
                .id(req.getProjectId().toString())
                .projectName(req.getProjectName())               // 필드 이름에 맞게 수정
                .startDateTime(req.getStartDateTime())           // @Column(nullable = false) 대응
                .endDateTime(req.getEndDateTime())               // @Column(nullable = false)
                .user(user)
                .build();

        projectRepo.save(project);

    }


    public List<ProjectResponse.ProjectHomeResponse> findByWriter(Long userId) {
        return projectRepo.findAllByUserIdWithStar(userId)
                .stream()
                .map(project -> ProjectResponse.ProjectHomeResponse.builder()
                        .projectId(UUID.fromString(project.getId()))  // 여기에서 변환
                        .projectName(project.getProjectName())
                        .startDateTime(project.getStartDateTime())
                        .endDateTime(project.getEndDateTime())
                        .build())
                .collect(Collectors.toList());
    }


    @Transactional
    public void updateProject(UUID projectId, ProjectRequest.ProjectUpdateRequest req, Long userId) {
        Project project = projectRepo.findById(projectId.toString())
                .orElseThrow(() -> new RuntimeException("블로그 없음"));

        if (!project.getUser().getId().equals(userId)) {
            throw new RuntimeException("작성자만 수정 가능");
        }

        project.update(req);
    }

    public void deleteProject(UUID projectId, Long userId) {
        Project project = projectRepo.findById(projectId.toString())
                .orElseThrow(() -> new RuntimeException("블로그 없음"));
        if (!project.getUser().getId().equals(userId)) {
            throw new RuntimeException("작성자만 삭제 가능");
        }
        projectRepo.delete(project);
    }



}
