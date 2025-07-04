package com.pard.server.discoPangPang_BE.label.controller;


import com.pard.server.discoPangPang_BE.label.dto.LabelRequest;
import com.pard.server.discoPangPang_BE.label.service.LabelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/label")
public class LabelController {
    private final LabelService labelService;


//    /*새로운 프로젝트 생성*/
//    @PostMapping("/create")
//    public ResponseEntity<Void> createProject(@RequestBody ProjectRequest.ProjectCreateRequest req) {
//        projectService.createProject(req);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }

    @PostMapping("/project/tag")
    public ResponseEntity<Void> addLabels(@RequestBody LabelRequest request) {
        labelService.addLabelsToProject(request);
        return ResponseEntity.ok().build();
    }

//    /*해당 유저의 모든 프로젝트의 제목, 마감기한, 태그 전달해주기*/
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<ProjectResponse.ProjectHomeResponse>> findByWriter(@PathVariable Long userId) {
//        return ResponseEntity.ok(projectService.findByWriter(userId));
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
//
//    @DeleteMapping("/{projectId}")
//    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId,
//                          @AuthenticationPrincipal OAuth2User oauth2User) {
//        String email = oauth2User.getAttribute("email");
//        Long userId = userService.findByEmail(email).getId();
//        projectService.deleteProject(projectId, userId);
//        return ResponseEntity.noContent().build();
//    }
}
