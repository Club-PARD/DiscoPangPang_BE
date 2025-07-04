package com.pard.server.discoPangPang_BE.label.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabelRequest {

    private Long projectId;
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

