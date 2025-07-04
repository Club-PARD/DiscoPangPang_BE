package com.pard.server.discoPangPang_BE.project.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class ProjectRequest {



    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectCreateRequest {
        private Long userId;
        private String projectName;//프로젝트의 이름
        private LocalDateTime startDateTime;
        private LocalDateTime endDateTime;


    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectUpdateRequest {
        private String projectName;//프로젝트의 이름
        private LocalDateTime startDateTime;
        private LocalDateTime endDateTime;


    }



}
