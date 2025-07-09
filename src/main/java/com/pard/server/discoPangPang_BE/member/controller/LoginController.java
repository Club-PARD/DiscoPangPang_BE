package com.pard.server.discoPangPang_BE.member.controller;

import com.pard.server.discoPangPang_BE.member.dto.AppleLoginRequest;
import com.pard.server.discoPangPang_BE.member.dto.TokenResponse;
import com.pard.server.discoPangPang_BE.member.service.MemberService;
import com.pard.server.discoPangPang_BE.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @PostMapping("/apple")
    public ResponseEntity<TokenResponse> appleLogin(@RequestBody AppleLoginRequest request) {
        TokenResponse response = memberService.loginWithApple(request);
        return ResponseEntity.ok(response);
    }

}

