package com.pard.server.discoPangPang_BE.project.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

public class ProjectRequest {


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
        public class TagGroupRequest {
            private Long projectId;
            private List<LabelDto> tags;

        }

    public static class LabelDto {
        private String labelName;
        private String labelCategory;
    }

//    @Getter
//    @Builder
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class BlogUpdateRequest {
//        private String filename;
//    }
//
}
