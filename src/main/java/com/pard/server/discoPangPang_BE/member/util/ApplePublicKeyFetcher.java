package com.pard.server.discoPangPang_BE.member.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

@Component
public class ApplePublicKeyFetcher {

    private static final String APPLE_KEYS_URL = "https://appleid.apple.com/auth/keys";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Apple 공개키를 가져오고, kid에 맞는 공개키를 RSA로 반환
    public RSAPublicKey getPublicKeyByKid(String kid) {
        try {
            JsonNode root = objectMapper.readTree(restTemplate.getForObject(APPLE_KEYS_URL, String.class));
            JsonNode keys = root.get("keys");

            for (JsonNode key : keys) {
                if (kid.equals(key.get("kid").asText())) {
                    return constructRSAPublicKey(key);
                }
            }

            throw new RuntimeException("일치하는 kid를 가진 공개키를 찾을 수 없습니다.");
        } catch (Exception e) {
            throw new RuntimeException("Apple 공개키 가져오기 실패", e);
        }
    }

    private RSAPublicKey constructRSAPublicKey(JsonNode key) throws Exception {
        String n = key.get("n").asText();
        String e = key.get("e").asText();

        BigInteger modulus = new BigInteger(1, Base64.getUrlDecoder().decode(n));
        BigInteger exponent = new BigInteger(1, Base64.getUrlDecoder().decode(e));
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, exponent);

        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(keySpec);
    }
}

