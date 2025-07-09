package com.pard.server.discoPangPang_BE.member.service;


import com.pard.server.discoPangPang_BE.member.dto.AppleLoginRequest;

import com.pard.server.discoPangPang_BE.member.dto.TokenResponse;
import com.pard.server.discoPangPang_BE.member.util.AppleJwtValidator;
import com.pard.server.discoPangPang_BE.user.entity.User;
import com.pard.server.discoPangPang_BE.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import com.pard.server.discoPangPang_BE.member.dto.AppleUserInfo;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final AppleJwtValidator appleJwtValidator;
    private final UserRepo userRepo;
    private final JwtTokenService jwtTokenService; // 네가 쓰는 JWT 발급 클래스

    public TokenResponse loginWithApple(AppleLoginRequest request) {
        AppleUserInfo userInfo = appleJwtValidator.validate(request.getIdentityToken());
        String sub = userInfo.getSub();
        String email = userInfo.getEmail();
        String name = userInfo.getName();

        User user = userRepo.findByAppleSub(sub)
                .orElseGet(() -> {
                    User newUser = User.builder()
                            .appleSub(sub)
                            .email(email)
                            .name(request.getName()) // request로부터 이름 받아오기
                            .build();
                    return userRepo.save(newUser);
                });

        String jwt = jwtTokenService.generateToken(user.getId(), user.getAppleSub());

        return new TokenResponse(jwt, user.getId());
    }


}



