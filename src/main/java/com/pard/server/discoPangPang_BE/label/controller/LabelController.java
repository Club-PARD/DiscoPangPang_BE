package com.pard.server.discoPangPang_BE.label.controller;


import com.pard.server.discoPangPang_BE.label.dto.LabelRequest;
import com.pard.server.discoPangPang_BE.label.dto.LabelResponse;
import com.pard.server.discoPangPang_BE.label.service.LabelService;
import com.pard.server.discoPangPang_BE.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/label")
public class LabelController {
    private final LabelService labelService;
//    private final ProjectService projectService;


    @PostMapping("/project/tag")
    public ResponseEntity<Void> addLabels(@RequestBody LabelRequest request) {
        labelService.updateProjectLabels(request);
        return ResponseEntity.ok().build();
    }


    /*해당 프로젝트의 모든 프로젝트의 제목, 마감기한, 태그 전달해주기*/
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<LabelResponse>> findByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(labelService.findByProject(projectId));
    }

}
