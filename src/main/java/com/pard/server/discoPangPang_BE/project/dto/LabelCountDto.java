package com.pard.server.discoPangPang_BE.project.dto;

public interface LabelCountDto {
    String getLabelName();  // labelCategory 값이 들어옴
    Long getCount();       // 해당 카테고리에 속한 label 개수
}
