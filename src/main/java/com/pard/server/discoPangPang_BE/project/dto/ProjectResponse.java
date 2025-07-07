package com.pard.server.discoPangPang_BE.project.dto;

import lombok.*;

import java.time.LocalDateTime;



public class ProjectResponse {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectReadResponse {
        private String id;//primary key
        private String projectName;//프로젝트의 이름
//        private String insight;//인사이트를 기록할 수 있는 변수
//        private String status;// 프로그램의 상태를 나타내주는 변수 예) not_started, in_progress, answering, completed
//        /*하드 코딩하지 않기 -> 추후에 수정 예정*/
        private LocalDateTime endDateTime;
//        private LocalDateTime startDateTime;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectHomeResponse {
        private String id;//primary key
        private String projectName;//프로젝트의 이름
//        private String insight;//인사이트를 기록할 수 있는 변수
//        private String status;// 프로그램의 상태를 나타내주는 변수 예) not_started, in_progress, answering, completed
//       /*하드 코딩하지 않기 -> 추후에 수정 예정*/
        private LocalDateTime endDateTime;
//        private LocalDateTime startDateTime;
//        private List<String> labels; // 태그 이름 리스트
    }




}
