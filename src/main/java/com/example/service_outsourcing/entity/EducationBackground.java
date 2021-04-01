package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class EducationBackground implements Serializable {
    private String backgroundId;

    private String resumeId;

    private String schoolName;

    private String major;

    private String beginTime;

    private String endTime;

    private String educationDescribe;

    private static final long serialVersionUID = 1L;

    public String getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(String backgroundId) {
        this.backgroundId = backgroundId == null ? null : backgroundId.trim();
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId == null ? null : resumeId.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
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

    public String getEducationDescribe() {
        return educationDescribe;
    }

    public void setEducationDescribe(String educationDescribe) {
        this.educationDescribe = educationDescribe == null ? null : educationDescribe.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", backgroundId=").append(backgroundId);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", schoolName=").append(schoolName);
        sb.append(", major=").append(major);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", educationDescribe=").append(educationDescribe);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}