package com.pard.server.discoPangPang_BE;

import com.pard.server.discoPangPang_BE.config.AppleProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppleProperties.class)
public class DiscoPangPangBeApplication {
	public static void main(String[] args) {
		SpringApplication.run(DiscoPangPangBeApplication.class, args);
	}
}
