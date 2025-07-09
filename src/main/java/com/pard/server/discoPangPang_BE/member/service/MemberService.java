package com.pard.server.discoPangPang_BE.member.service;


import com.pard.server.discoPangPang_BE.member.dto.AppleLoginRequest;

import com.pard.server.discoPangPang_BE.member.util.AppleJwtValidator;
import com.pard.server.discoPangPang_BE.user.entity.User;
import com.pard.server.discoPangPang_BE.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


package com.pard.server.discoPangPang_BE.member.service;

import com.pard.server.discoPangPang_BE.member.dto.AppleLoginRequest;
import com.pard.server.discoPangPang_BE.member.dto.AppleUserInfo;
import com.pard.server.discoPangPang_BE.member.util.AppleJwtValidator;
import com.pard.server.discoPangPang_BE.user.entity.User;
import com.pard.server.discoPangPang_BE.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final AppleJwtValidator appleJwtValidator;
    private final UserRepo userRepo;
    private final JwtTokenService jwtTokenService; // 네가 쓰는 JWT 발급 클래스

    public String loginWithApple(AppleLoginRequest request) {
        AppleUserInfo userInfo = appleJwtValidator.validate(request.getIdentityToken());
        String sub = userInfo.getSub();       // Apple 고유 ID
        String email = userInfo.getEmail();   // optional

        User user = userRepo.findByAppleSub(sub)
                .orElseGet(() -> {
                    User newUser = User.builder()
                            .appleSub(sub)
                            .email(email)
                            .name(request.getFullName())
                            .build();
                    return userRepo.save(newUser);
                });

        return jwtTokenService.generateToken(user.getId(), user.getAppleSub());
    }
}



