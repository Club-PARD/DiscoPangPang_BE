package com.pard.server.discoPangPang_BE.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppleLoginRequest {
    private String identityToken;
    private String email;      // 최초 로그인만 전달됨
    private String name;   // 최초 로그인만 전달됨

}

