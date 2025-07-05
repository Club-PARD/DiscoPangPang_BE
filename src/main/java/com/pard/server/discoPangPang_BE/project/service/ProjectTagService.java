package com.pard.server.discoPangPang_BE.project.service;




import com.pard.server.discoPangPang_BE.project.dto.LabelCountDto;
import com.pard.server.discoPangPang_BE.project.dto.ProjectRequest;
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

}
