package com.pard.server.discoPangPang_BE.label.service;





import com.pard.server.discoPangPang_BE.label.dto.LabelRequest;
import com.pard.server.discoPangPang_BE.label.entity.Label;
import com.pard.server.discoPangPang_BE.label.repo.LabelRepo;
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
    public void updateProjectLabels(LabelRequest req) {
        Project project = projectRepo.findById(req.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("프로젝트가 존재하지 않습니다."));

        // 1. 기존 태그 연결 삭제
        projectTagRepo.deleteByProject(project); // 모든 연결 제거

        // 2. 새로운 태그 연결
        // ':'의 의미 : "req.getLabels() 안에 있는 값을 하나씩 labelDto에 넣으면서 반복해라."
        for (LabelRequest.LabelDto labelDto : req.getLabels()) {
            String labelName = labelDto.getLabelName();
            String labelCategory = labelDto.getLabelCategory();

            // 라벨이 존재하지 않으면 생성
            Label label = labelRepo.findByLabelNameAndLabelCategory(labelName, labelCategory)
                    .orElseGet(() -> labelRepo.save(new Label(labelName, labelCategory)));

            // ProjectTag 새로 저장
            projectTagRepo.save(new ProjectTag(project, label));
        }
    }


}



