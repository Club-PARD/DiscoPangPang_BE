package com.pard.server.discoPangPang_BE.label.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LabelResponse {
    private String labelName;
    private String labelCategory; // 태그 이름 리스트
}





