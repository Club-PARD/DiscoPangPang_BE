package com.pard.server.discoPangPang_BE.project.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

public class ProjectRequest {



    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectCreateRequest {
        private UUID projectId;//uuid
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
