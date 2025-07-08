package com.pard.server.discoPangPang_BE.project.dto;

import java.time.LocalDateTime;

public class ProjectSummaryDto {
    private String projectId;
    private String projectName;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public ProjectSummaryDto(String projectId, String projectName, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public String getProjectId() { return projectId; }
    public String getProjectName() { return projectName; }
    public LocalDateTime getStartDateTime() { return startDateTime; }
    public LocalDateTime getEndDateTime() { return endDateTime; }
}

