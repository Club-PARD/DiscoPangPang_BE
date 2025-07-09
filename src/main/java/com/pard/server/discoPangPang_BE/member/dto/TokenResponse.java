package com.pard.server.discoPangPang_BE.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenResponse {
    private String accessToken;
    private Long userId;
    private String email;
}
