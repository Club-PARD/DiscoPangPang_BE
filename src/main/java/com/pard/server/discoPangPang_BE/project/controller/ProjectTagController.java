package com.pard.server.discoPangPang_BE.project.controller;

import com.pard.server.discoPangPang_BE.label.dto.LabelProjectGroupDto;
import com.pard.server.discoPangPang_BE.project.service.ProjectTagService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project-tag")
public class ProjectTagController {

    private final ProjectTagService projectTagService;

    @Operation(
            summary = "카테고리별 LabelName, LabelName의 개수 출력"
    )
    @GetMapping("/label-count/by-category")
    public ResponseEntity<Map<String, Long>> getLabelCountsByCategory(
            @RequestParam Long userId,
            @RequestParam String category) {
        return ResponseEntity.ok(projectTagService.getLabelCountsByCategory(userId, category));
    }

    @Operation(
            summary = "카테고리별 LabelName에 연결된 프로젝트 목록 조회",
            description = "labelCategory에 해당하는 모든 labelName에 대해 연결된 프로젝트들의 ID, 이름, 시작/종료 시간을 그룹으로 반환합니다."
    )
    @GetMapping("/grouped-projects")
    public ResponseEntity<List<LabelProjectGroupDto>> getGroupedProjectsByCategory(
            @RequestParam String category) {
        List<LabelProjectGroupDto> result = projectTagService.getGroupedProjectsByLabelCategory(category);
        return ResponseEntity.ok(result);
    }

}

