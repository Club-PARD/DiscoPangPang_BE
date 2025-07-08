package com.pard.server.discoPangPang_BE.project.service;




import com.pard.server.discoPangPang_BE.label.dto.LabelProjectGroupDto;
import com.pard.server.discoPangPang_BE.project.dto.FlatLabelProjectInfo;
import com.pard.server.discoPangPang_BE.project.dto.LabelCountDto;
import com.pard.server.discoPangPang_BE.project.dto.ProjectRequest;
import com.pard.server.discoPangPang_BE.project.dto.ProjectSummaryDto;
import com.pard.server.discoPangPang_BE.project.repo.ProjectTagRepo;
import com.pard.server.discoPangPang_BE.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectTagService {
    private final ProjectTagRepo projectTagRepo;

    public void createProject(ProjectRequest.ProjectCreateRequest req) {


    }

    public Map<String, Long> getLabelCountsByCategory(Long userId, String category) {
        List<LabelCountDto> result = projectTagRepo.countLabelsByCategoryName(userId, category);
        return result.stream()
                .collect(Collectors.toMap(LabelCountDto::getLabelName, LabelCountDto::getCount));
    }

    public List<LabelProjectGroupDto> getGroupedProjectsByLabelCategory(String category) {
        List<FlatLabelProjectInfo> flatList = projectTagRepo.findFlatProjectInfosByCategory(category);

        Map<String, List<ProjectSummaryDto>> grouped = flatList.stream()
                .collect(Collectors.groupingBy(
                        FlatLabelProjectInfo::getLabelName,
                        Collectors.mapping(info -> new ProjectSummaryDto(
                                info.getProjectId(),
                                info.getProjectName(),
                                info.getStartDateTime(),
                                info.getEndDateTime()
                        ), Collectors.toList())
                ));

        return grouped.entrySet().stream()
                .map(entry -> new LabelProjectGroupDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

}
