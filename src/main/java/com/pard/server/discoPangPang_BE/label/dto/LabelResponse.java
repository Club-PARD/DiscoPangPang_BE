package com.pard.server.discoPangPang_BE.label.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LabelResponse {

    private String labelName;
    private String labelCategory;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LabelNameResponse {
        private String labelName;
        private UUID projectId;
    }


}





