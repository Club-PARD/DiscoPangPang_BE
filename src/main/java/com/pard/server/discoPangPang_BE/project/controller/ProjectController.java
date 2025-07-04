package com.pard.server.discoPangPang_BE.project.controller;


import com.pard.server.discoPangPang_BE.project.dto.ProjectRequest;
import com.pard.server.discoPangPang_BE.project.dto.ProjectResponse;
import com.pard.server.discoPangPang_BE.project.entity.Project;
import com.pard.server.discoPangPang_BE.project.repo.ProjectRepo;
import com.pard.server.discoPangPang_BE.project.service.ProjectService;
import com.pard.server.discoPangPang_BE.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    private final UserService userService;
    private final ProjectRepo projectRepo;

    /*새로운 프로젝트 생성*/
    @PostMapping("/create")
    public ResponseEntity<Void> createProject(@RequestBody ProjectRequest.ProjectCreateRequest req) {
        projectService.createProject(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /*해당 유저의 모든 프로젝트의 제목, 태그 전달해주기*/
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProjectResponse.ProjectHomeResponse>> findByWriter(@PathVariable Long userId) {
        return ResponseEntity.ok(projectService.findByWriter(userId));
    }

    @PatchMapping("/{projectId}")
    public ResponseEntity<Void> patchProject(@PathVariable Long projectId,
                         @RequestBody ProjectRequest.ProjectUpdateRequest req,
                                             @RequestParam Long userId)
    {
        projectService.updateProject(projectId, req, userId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId,
                         @RequestParam Long userId) {

        projectService.deleteProject(projectId, userId);
        return ResponseEntity.noContent().build();
    }
}
