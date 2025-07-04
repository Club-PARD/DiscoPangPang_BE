package com.pard.server.discoPangPang_BE.star.dto;


import lombok.*;


@Getter
public class StarResponse {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StarCreateResponse {
        private Long id;
    }

//        /**
//         * Blog 엔티티를 BlogReadResponse DTO로 변환하는 정적 팩토리 메서드
//         * @param blog 변환할 Blog 엔티티
//         * @return BlogReadResponse DTO 객체
//         */
//        public static BlogReadResponse from(Blog blog) {
//            return BlogReadResponse.builder()
//                    .blog_id(blog.getId())
//                    .filename(blog.getProjectName())
//                    .writerName(blog.getUser().getName())
//                    .writerId(blog.getUser().getId())
////                    .likeCount((long) blog.getLikes().size())
//                    .build();
//        }
//    }
}
