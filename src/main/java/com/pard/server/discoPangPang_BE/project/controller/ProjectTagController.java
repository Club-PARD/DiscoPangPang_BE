package com.pard.server.discoPangPang_BE.project.controller;

import com.pard.server.discoPangPang_BE.project.service.ProjectTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project-tag")
public class ProjectTagController {

    private final ProjectTagService projectTagService;

    @GetMapping("/label-count/by-category")
    public ResponseEntity<Map<String, Long>> getLabelCountsByCategory(
            @RequestParam Long userId,
            @RequestParam String category) {
        return ResponseEntity.ok(projectTagService.getLabelCountsByCategory(userId, category));
    }

}

