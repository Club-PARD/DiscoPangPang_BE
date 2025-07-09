package com.pard.server.discoPangPang_BE.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration  // 이거 하나면 충분함
@ConfigurationProperties(prefix = "apple")
public class AppleProperties {

    private String clientId;

    @jakarta.annotation.PostConstruct
    public void init() {
        System.out.println("🔍 AppleProperties.clientId = " + clientId);
    }
}
