package com.pard.server.discoPangPang_BE.star.dto;

import lombok.*;

public class StarRequest {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StarUpdateRequest {
        private String s;
        private String t;
        private String a;
        private String r;
        private String l;
    }

}
