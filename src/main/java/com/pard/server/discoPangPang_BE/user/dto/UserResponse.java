package com.pard.server.discoPangPang_BE.user.dto;




import lombok.*;

public class UserResponse {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReadUser {
        private String name;
//        private String email;
    }

}
