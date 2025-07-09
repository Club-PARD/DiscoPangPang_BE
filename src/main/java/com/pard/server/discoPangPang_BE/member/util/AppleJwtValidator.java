package com.pard.server.discoPangPang_BE.member.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pard.server.discoPangPang_BE.config.AppleProperties;
import com.pard.server.discoPangPang_BE.member.dto.AppleUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AppleJwtValidator {

    private final ApplePublicKeyFetcher applePublicKeyFetcher;
    private final AppleProperties appleProperties;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public AppleUserInfo validate(String identityToken) {
        try {
            DecodedJWT jwt = JWT.decode(identityToken);
            String kid = jwt.getKeyId();

            RSAPublicKey publicKey = applePublicKeyFetcher.getPublicKeyByKid(kid);

            Algorithm algorithm = Algorithm.RSA256(publicKey, null);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("https://appleid.apple.com")
                    .build();

            DecodedJWT verifiedJWT = verifier.verify(identityToken);

            String payload = new String(Base64.getUrlDecoder().decode(verifiedJWT.getPayload()));
            Map<String, Object> payloadMap = objectMapper.readValue(payload, Map.class);

            if (identityToken == null || identityToken.trim().isEmpty()) {
                throw new RuntimeException("⚠️ identityToken is null or empty");
            }



            // aud 확인
            String aud = (String) payloadMap.get("aud");
            if (!appleProperties.getClientId().equals(aud)) {
                throw new RuntimeException("clientId 불일치");
            }

            String sub = (String) payloadMap.get("sub");
            String email = (String) payloadMap.get("email");
            String name = (String) payloadMap.get("name");

            return new AppleUserInfo(sub, email, name);

        } catch (Exception e) {
            throw new RuntimeException("Apple 토큰 검증 실패", e);
        }
    }
}



