package com.pard.server.discoPangPang_BE.project.controller;


import com.pard.server.discoPangPang_BE.project.dto.ProjectRequest;
import com.pard.server.discoPangPang_BE.project.dto.ProjectResponse;
import com.pard.server.discoPangPang_BE.project.repo.ProjectRepo;
import com.pard.server.discoPangPang_BE.project.service.ProjectService;
import com.pard.server.discoPangPang_BE.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @Operation(summary = "프로젝트 생성", description = "새로운 프로젝트를 생성합니다.")
    /*새로운 프로젝트 생성*/
    @PostMapping("/{userId}")
    public ResponseEntity<Void> createProject(@PathVariable Long userId,
            @RequestBody ProjectRequest.ProjectCreateRequest req) {
        projectService.createProject(userId,req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "프로젝트 조회", description = "해당 유저의 프로젝트를 모두 불러옵니다.")
    /*해당 유저의 모든 프로젝트의 제목, 태그 전달해주기*/
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProjectResponse.ProjectHomeResponse>> findByWriter(@PathVariable Long userId) {
        return ResponseEntity.ok(projectService.findByWriter(userId));
    }

    @Operation(summary = "프로젝트 수정", description = "해당 프로젝트를 수정할 수 있도록합니다.")
    @PatchMapping("/{projectId}")
    public ResponseEntity<Void> patchProject(@PathVariable UUID projectId,
                         @RequestBody ProjectRequest.ProjectUpdateRequest req,
                                             @RequestParam Long userId) {
        projectService.updateProject(projectId, req, userId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable UUID projectId,
                         @RequestParam Long userId) {

        projectService.deleteProject(projectId, userId);
        return ResponseEntity.noContent().build();
    }
}
