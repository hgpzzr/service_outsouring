package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class ProjectExperience implements Serializable {
    private String projectId;

    private String resumeId;

    private String projectName;

    private String beginTime;

    private String endTime;

    private String projectDescribe;

    private String projectProvePicUrl;

    private static final long serialVersionUID = 1L;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId == null ? null : resumeId.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime == null ? null : beginTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getProjectDescribe() {
        return projectDescribe;
    }

    public void setProjectDescribe(String projectDescribe) {
        this.projectDescribe = projectDescribe == null ? null : projectDescribe.trim();
    }

    public String getProjectProvePicUrl() {
        return projectProvePicUrl;
    }

    public void setProjectProvePicUrl(String projectProvePicUrl) {
        this.projectProvePicUrl = projectProvePicUrl == null ? null : projectProvePicUrl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectId=").append(projectId);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", projectName=").append(projectName);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", projectDescribe=").append(projectDescribe);
        sb.append(", projectProvePicUrl=").append(projectProvePicUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}