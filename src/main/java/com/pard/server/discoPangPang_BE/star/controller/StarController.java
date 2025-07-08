package com.pard.server.discoPangPang_BE.star.controller;



import com.pard.server.discoPangPang_BE.project.dto.ProjectResponse;
import com.pard.server.discoPangPang_BE.star.dto.StarRequest;
import com.pard.server.discoPangPang_BE.star.dto.StarResponse;
import com.pard.server.discoPangPang_BE.star.service.StarService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/star")
public class StarController {
    private final StarService starService;


    @Operation(summary = "Star 정보 생성 또는 수정",
            description = "해당 projectId에 연결된 Star가 존재하면 수정하고, 없으면 새로 생성합니다.")
    /*수정하되 만약에 없으면 생성*/
    @PatchMapping("/{projectId}")
    public ResponseEntity<Void> patchStar(@PathVariable String projectId,
                                          @RequestBody StarRequest.StarUpdateRequest req) {
        starService.updateStar(projectId, req);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<StarResponse>> findByProject(@PathVariable UUID projectId) {
        return ResponseEntity.ok(starService.findByProjectId(projectId));
    }


}