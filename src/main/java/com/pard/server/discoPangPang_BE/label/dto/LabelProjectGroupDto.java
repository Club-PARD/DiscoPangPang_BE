package com.pard.server.discoPangPang_BE.label.dto;

import com.pard.server.discoPangPang_BE.project.dto.ProjectSummaryDto;

import java.util.List;

public class LabelProjectGroupDto {
    private String labelName;
    private List<ProjectSummaryDto> projects;

    public LabelProjectGroupDto(String labelName, List<ProjectSummaryDto> projects) {
        this.labelName = labelName;
        this.projects = projects;
    }

    public String getLabelName() { return labelName; }
    public List<ProjectSummaryDto> getProjects() { return projects; }
}

