package com.pard.server.discoPangPang_BE.member.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiration-ms}")
    private long expirationMs;

    public String generateToken(Long userId, String appleSub) {
        Date now = new Date();
        Date expiresAt = new Date(now.getTime() + expirationMs);

        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withClaim("appleSub", appleSub)
                .withIssuer(issuer)
                .withIssuedAt(now)
                .withExpiresAt(expiresAt)
                .sign(Algorithm.HMAC256(secret));
    }
}