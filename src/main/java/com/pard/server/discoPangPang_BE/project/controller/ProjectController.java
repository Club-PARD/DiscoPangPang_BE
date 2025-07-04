package com.pard.server.discoPangPang_BE.project.controller;


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

//    /*새로운 프로젝트 생성*/
//    @PostMapping("/create")
//    public ResponseEntity<Void> createProject(@RequestBody ProjectRequest.ProjectCreateRequest req) {
//        projectService.createProject(req);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }

    /*해당 유저의 모든 프로젝트의 제목, 태그 전달해주기*/
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProjectResponse.ProjectHomeResponse>> findByWriter(@PathVariable Long userId) {
        return ResponseEntity.ok(projectService.findByWriter(userId));
    }




//    /*진행 중 혹은 질문을 하고 있으면 해당하는 프로젝트를 출력하기*/
//    @GetMapping("")
//    public ResponseEntity<List<ProjectResponse.ProjectHomeResponse>> getProjectsByUserAndStatus(
//            @RequestParam Long userId) {
//        /*우선 유저의 아이디를 매칭해서 아이디의 프로젝트를 찾음*/
//
//        /*진행중이거나 질문을 하고 있으면 불러오기*/
//        List<ProjectResponse.ProjectHomeResponse> responses = projectService.getProjectsByUserAndStatus(userId);
//        return ResponseEntity.ok(responses);
//    }


//    @PatchMapping("/{projectId}")
//    public ResponseEntity<Void> patchProject(@PathVariable Long projectId,
//                         @RequestBody ProjectRequest.ProjectUpdateRequest req,
//                         @AuthenticationPrincipal OAuth2User oauth2User) {
//        String email = oauth2User.getAttribute("email");
//        Long userId = userService.findByEmail(email).getId();
//        projectService.updateProject(projectId, req, userId);
//        return ResponseEntity.noContent().build();
//    }
//A
//    @DeleteMapping("/{projectId}")
//    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId,
//                          @AuthenticationPrincipal OAuth2User oauth2User) {
//        String email = oauth2User.getAttribute("email");
//        Long userId = userService.findByEmail(email).getId();
//        projectService.deleteProject(projectId, userId);
//        return ResponseEntity.noContent().build();
//    }
}
