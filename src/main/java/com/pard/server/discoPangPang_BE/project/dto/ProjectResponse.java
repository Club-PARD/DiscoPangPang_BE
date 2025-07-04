package com.pard.server.discoPangPang_BE.project.dto;


import com.pard.server.discoPangPang_BE.project.entity.Project;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ProjectResponse {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectReadResponse {
        private Long id;//primary key
        private String projectName;//프로젝트의 이름
        private String insight;//인사이트를 기록할 수 있는 변수
//        private String status;// 프로그램의 상태를 나타내주는 변수 예) not_started, in_progress, answering, completed
//        /*하드 코딩하지 않기 -> 추후에 수정 예정*/
        private LocalDateTime endDateTime;
        private LocalDateTime startDateTime;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectHomeResponse {
        private Long id;//primary key
        private String projectName;//프로젝트의 이름
//        private String insight;//인사이트를 기록할 수 있는 변수
//        private String status;// 프로그램의 상태를 나타내주는 변수 예) not_started, in_progress, answering, completed
////        /*하드 코딩하지 않기 -> 추후에 수정 예정*/
        private LocalDateTime endDateTime;
//        private LocalDateTime startDateTime;
        private List<String> labels; // 태그 이름 리스트
    }




}
