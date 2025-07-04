package com.pard.server.discoPangPang_BE.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration

public class CorsConfig {//요청의 종류, 정책을 정하는 파트
    @Bean    // 설정 파일 먼저 돌리도록 ??? single tone?? 한번만 만들어서 주입 받아서
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();// 쿠키 허용

        config.setAllowCredentials(true);//모든 출처를 허용

        config.addAllowedOrigin("*");

        config.addAllowedHeader("*");

        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/*", config);

        return new CorsFilter(source); //필터링, 우리 서버에 들어오기 위해서는 우리의 정책을 따라야해!
        //그 따라하는 정책을 반환
    }
}
