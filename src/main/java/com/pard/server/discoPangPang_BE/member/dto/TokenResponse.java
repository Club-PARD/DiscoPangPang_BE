package com.pard.server.discoPangPang_BE.member.dto;

import lombok.Getter;

@Getter
public class TokenResponse {
    private String accessToken;

    public TokenResponse(String token) {
        this.accessToken = token;
    }

}
