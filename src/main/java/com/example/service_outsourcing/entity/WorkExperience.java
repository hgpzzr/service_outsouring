package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class WorkExperience implements Serializable {
    private String workId;

    private String resumeId;

    private String companyName;

    private String beginTime;

    private String endTime;

    private String workDescribe;

    private String workProvePicUrl;

    private static final long serialVersionUID = 1L;

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId == null ? null : resumeId.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
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

    public String getWorkDescribe() {
        return workDescribe;
    }

    public void setWorkDescribe(String workDescribe) {
        this.workDescribe = workDescribe == null ? null : workDescribe.trim();
    }

    public String getWorkProvePicUrl() {
        return workProvePicUrl;
    }

    public void setWorkProvePicUrl(String workProvePicUrl) {
        this.workProvePicUrl = workProvePicUrl == null ? null : workProvePicUrl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", workId=").append(workId);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", companyName=").append(companyName);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", workDescribe=").append(workDescribe);
        sb.append(", workProvePicUrl=").append(workProvePicUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}