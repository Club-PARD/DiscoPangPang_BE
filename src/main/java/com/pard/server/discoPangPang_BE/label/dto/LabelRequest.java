package com.pard.server.discoPangPang_BE.label.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabelRequest {

    private String projectId;
    private List<LabelDto> labels;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LabelDto {
        private String labelName;
        private String labelCategory;
    }
}

