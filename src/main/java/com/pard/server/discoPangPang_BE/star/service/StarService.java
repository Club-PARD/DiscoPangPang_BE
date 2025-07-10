package com.pard.server.discoPangPang_BE.star.service;



import com.pard.server.discoPangPang_BE.project.dto.ProjectResponse;
import com.pard.server.discoPangPang_BE.project.entity.Project;
import com.pard.server.discoPangPang_BE.project.repo.ProjectRepo;
import com.pard.server.discoPangPang_BE.star.dto.StarRequest;
import com.pard.server.discoPangPang_BE.star.dto.StarResponse;
import com.pard.server.discoPangPang_BE.star.entity.Star;
import com.pard.server.discoPangPang_BE.star.repo.StarRepo;
import com.pard.server.discoPangPang_BE.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StarService {
    private final UserRepo userRepo;
    private final ProjectRepo projectRepo;
    private final StarRepo starRepo;

    /*create 안 쓰고 update에서 create 까지 다 할거임*/
//    public Long createStar(StarRequest.StarCreateRequest req) {
//        Project project = projectRepo.findById(req.getProjectId())
//                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));
//
//        Star star = Star.builder()
//                .s(req.getS())
//                .t(req.getT())
//                .a(req.getA())
//                .r(req.getR())
//                .l(req.getL())
//                .project(project)
//                .build();
//
//        starRepo.save(star);
//        return star.getId();
//    }


    @Transactional
    public void updateStar(String projectId, StarRequest.StarUpdateRequest req) {
        Project project = projectRepo.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));

        Optional<Star> optionalStar = starRepo.findByProjectId(projectId);

        if (optionalStar.isPresent()) {
            Star star = optionalStar.get();
            star.update(req.getS(), req.getT(), req.getA(), req.getR(), req.getL());
        } else {
            Star newStar = Star.builder()
                    .s(req.getS())
                    .t(req.getT())
                    .a(req.getA())
                    .r(req.getR())
                    .l(req.getL())
                    .project(project)
                    .build();
            starRepo.save(newStar);
        }


    }
    public List<StarResponse> findByProjectId(UUID projectId) {
        return starRepo.findByProjectId(projectId.toString()).stream()
                .map(star -> StarResponse.builder()
                        .s(star.getS())
                        .s(star.getT())
                        .s(star.getA())
                        .s(star.getR())
                        .s(star.getL())
                        .projectId(projectId)
                        .build())
                .collect(Collectors.toList());
    }
}



