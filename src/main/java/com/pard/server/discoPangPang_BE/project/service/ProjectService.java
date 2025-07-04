package com.pard.server.discoPangPang_BE.project.service;



import com.pard.server.discoPangPang_BE.project.dto.ProjectResponse;
import com.pard.server.discoPangPang_BE.project.repo.ProjectRepo;
import com.pard.server.discoPangPang_BE.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final UserRepo userRepo;
    private final ProjectRepo projectRepo;

//    public void createProject(ProjectRequest.ProjectCreateRequest req) {
//        User user = userRepo.findById(req.getUserId())
//                .orElseThrow(() -> new RuntimeException("유저 없음"));
//        Project project = Project.from(req.getFilename(), user);
//        projectRepo.save(project);
//    }
//
    public List<ProjectResponse.ProjectHomeResponse> findByWriter(Long userId) {
        return projectRepo.findAllByUserId(userId).stream()
                .map(project -> ProjectResponse.ProjectHomeResponse.builder()
                        .id(project.getId())
                        .projectName(project.getProjectName())
//                        .status(project.getStatus())
                        .endDateTime(project.getEndDateTime())
//                        .startDateTime(project.getStartDateTime())
                        .build())
                .collect(Collectors.toList());
    }
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
//public List<ProjectResponse.ProjectHomeResponse> getProjectsByUserAndStatus(Long userId) {
//    List<String> statusList = List.of("in_progress", "answering");
//
//    List<Project> projects = projectRepo.findByUserIdAndStatusIn(userId, statusList);
//
//    return projects.stream()
//            .map(p -> new ProjectResponse.ProjectHomeResponse(
//                    p.getId(),
//                    p.getProjectName(),
//                    p.getStatus(),
//                    p.getEndDateTime(),
//                    p.getStartDateTime(),
//                    p.getProjectTags().stream()
//                            .map(pt -> pt.getLabel().getLabelName())
//                            .toList()
//            ))
//            .toList();
//}
}
