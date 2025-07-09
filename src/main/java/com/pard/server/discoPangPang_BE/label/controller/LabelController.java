package com.pard.server.discoPangPang_BE.label.controller;


import com.pard.server.discoPangPang_BE.label.dto.LabelRequest;
import com.pard.server.discoPangPang_BE.label.dto.LabelResponse;
import com.pard.server.discoPangPang_BE.label.service.LabelService;
import com.pard.server.discoPangPang_BE.project.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/label")
public class LabelController {
    private final LabelService labelService;


    @Operation(summary = "태그 생성", description = "DB에 있는 태그와 프로젝트를 연결 시켜줍니다.")
    @PostMapping("/project/tag")
    public ResponseEntity<Void> addLabels(@RequestBody LabelRequest request) {
        labelService.updateProjectLabels(request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "프로젝트의 태그 조회", description = "프로젝트를 UUID를 기준으로 태그들을 조회합니다.")
    /*해당 프로젝트의 모든 프로젝트의 제목, 마감기한, 태그 전달해주기*/
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<LabelResponse.LabelNameResponse>> findByProject(@Parameter(description = "UUID of the project", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
                                                                                   @PathVariable UUID projectId) {
        return ResponseEntity.ok(labelService.findByProject(projectId));
    }

}
