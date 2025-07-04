package com.pard.server.discoPangPang_BE.star.controller;


import com.pard.server.discoPangPang_BE.project.service.ProjectService;
import com.pard.server.discoPangPang_BE.star.dto.StarRequest;
import com.pard.server.discoPangPang_BE.star.dto.StarResponse;
import com.pard.server.discoPangPang_BE.star.entity.Star;
import com.pard.server.discoPangPang_BE.star.service.StarService;
import com.pard.server.discoPangPang_BE.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/star")
public class StarController {
    private final StarService starService;
    private final UserService userService;

    /*새로운 star 생성*/
    @PostMapping("/create")
    public ResponseEntity<StarResponse.StarCreateResponse> createStar(@RequestBody StarRequest.StarCreateRequest req) {
        Long starId = starService.createStar(req); // DB 저장은 서비스에서
        return ResponseEntity.status(HttpStatus.CREATED).body(new StarResponse.StarCreateResponse(starId));
    }

//
//    /*해당 유저의 모든 프로젝트의 제목, 마감기한, 태그 전달해주기*/
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<ProjectResponse.ProjectReadResponse>> findByWriter(@PathVariable Long userId) {
//        return ResponseEntity.ok(projectService.findByWriter(userId));
//    }
//
//    /*해당하는 프로젝트를 출력하기*/
//    @GetMapping("")
//
//
    @PatchMapping("/{starId}")
    public ResponseEntity<Void> patchStar(@PathVariable Long starId,
                         @RequestBody StarRequest.StarUpdateRequest req) {
        starService.updateStar(starId, req);
        return ResponseEntity.noContent().build();
    }
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
