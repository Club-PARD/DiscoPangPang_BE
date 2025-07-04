package com.pard.server.discoPangPang_BE.label.service;





import com.pard.server.discoPangPang_BE.label.dto.LabelRequest;
import com.pard.server.discoPangPang_BE.label.entity.Label;
import com.pard.server.discoPangPang_BE.label.repo.LabelRepo;
import com.pard.server.discoPangPang_BE.project.dto.ProjectRequest;
import com.pard.server.discoPangPang_BE.project.entity.Project;
import com.pard.server.discoPangPang_BE.project.entity.ProjectTag;
import com.pard.server.discoPangPang_BE.project.repo.ProjectRepo;
import com.pard.server.discoPangPang_BE.project.repo.ProjectTagRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LabelService {
    private final LabelRepo labelRepo;
    private final ProjectRepo projectRepo;
    private final ProjectTagRepo projectTagRepo;

    @Transactional
    public void addLabelsToProject(LabelRequest req) {
        Project project = projectRepo.findById(req.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("프로젝트가 존재하지 않습니다."));

        for (LabelRequest.LabelDto labelDto : req.getLabels()) {
            String labelName = labelDto.getLabelName();
            String labelCategory = labelDto.getLabelCategory();

            Label label = labelRepo.findByLabelNameAndLabelCategory(labelName, labelCategory)
                    .orElseGet(() -> labelRepo.save(new Label(labelName, labelCategory)));

            if (!projectTagRepo.existsByProjectAndLabel(project, label)) {
                projectTagRepo.save(new ProjectTag(project, label));
            }
        }
    }


//    public void createProject(ProjectRequest.ProjectCreateRequest req) {
//        User user = userRepo.findById(req.getUserId())
//                .orElseThrow(() -> new RuntimeException("유저 없음"));
//        Project project = Project.from(req.getFilename(), user);
//        projectRepo.save(project);
//    }
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
