package com.pard.server.discoPangPang_BE.member.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppleUserInfo {
    private final String sub;
    private final String email; // optional
    private final String name;


}
