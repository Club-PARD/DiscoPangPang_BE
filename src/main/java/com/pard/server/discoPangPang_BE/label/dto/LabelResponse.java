//package com.pard.server.discoPangPang_BE.label.dto;
//
//
//import lombok.*;
//
///**
// * 블로그 관련 응답 DTO를 정의하는 클래스
// * 클라이언트에게 전달할 블로그 데이터의 구조를 정의
// */
//@Getter
//public class LabelResponse {
//    /**
//     * 블로그 게시글 조회 응답을 위한 내부 클래스
//     * 블로그 게시글의 상세 정보를 포함
//     */
//    @Getter
//    @Builder
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class BlogReadResponse {
//        private Long blog_id;        // 블로그 게시글의 고유 식별자
//        private String filename;     // 블로그 게시글의 제목
//        private String writerName;   // 블로그 작성자의 이름
//        private Long writerId;       // 블로그 작성자의 고유 식별자 (User 엔티티의 id와 매핑)
//        private Long likeCount;      // 해당 블로그 게시글에 달린 좋아요의 총 개수
//
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
//}
