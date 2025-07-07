package com.pard.server.discoPangPang_BE.label.service;





import com.pard.server.discoPangPang_BE.label.dto.LabelRequest;
import com.pard.server.discoPangPang_BE.label.dto.LabelResponse;
import com.pard.server.discoPangPang_BE.label.entity.Label;
import com.pard.server.discoPangPang_BE.label.repo.LabelRepo;
import com.pard.server.discoPangPang_BE.project.dto.ProjectResponse;
import com.pard.server.discoPangPang_BE.project.entity.Project;
import com.pard.server.discoPangPang_BE.project.entity.ProjectTag;
import com.pard.server.discoPangPang_BE.project.repo.ProjectRepo;
import com.pard.server.discoPangPang_BE.project.repo.ProjectTagRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LabelService {
    private final LabelRepo labelRepo;
    private final ProjectRepo projectRepo;
    private final ProjectTagRepo projectTagRepo;

    @Transactional
    public void updateProjectLabels(LabelRequest req) {
        // 1. 유효한 태그만 필터링 (labelName이나 labelCategory가 "null"이면 제외)
        List<LabelRequest.LabelDto> validLabels = req.getLabels().stream()
                .filter(dto -> dto.getLabelName() != null && dto.getLabelCategory() != null)
                .filter(dto -> !dto.getLabelName().equalsIgnoreCase("null"))
                .filter(dto -> !dto.getLabelCategory().equalsIgnoreCase("null"))
                .toList();

        // 2. 최대 4개 체크
        if (validLabels.size() > 4) {
            throw new IllegalArgumentException("최대 4개의 태그만 선택할 수 있습니다.");
        }

        // 3. 프로젝트 확인
        String projectId = req.getProjectId();
        Project project = projectRepo.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("프로젝트가 존재하지 않습니다."));

        // 4. 기존 태그 제거
        projectTagRepo.deleteByProject(project);

        // 5. 새 태그 연결
        for (LabelRequest.LabelDto dto : validLabels) {
            Label label = labelRepo.findByLabelNameAndLabelCategory(dto.getLabelName(), dto.getLabelCategory())
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 태그입니다: " + dto.getLabelName()));
            projectTagRepo.save(new ProjectTag(project, label));
        }
    }



    public List<LabelResponse.LabelNameResponse> findByProject(Long projectId) {
        return labelRepo.findAllByProjectId(projectId).stream()
                .map(label -> LabelResponse.LabelNameResponse.builder()
                        .labelName(label.getLabelName())
                        .build())
                .collect(Collectors.toList());
    }


}



