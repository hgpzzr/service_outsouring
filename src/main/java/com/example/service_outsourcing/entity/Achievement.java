package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class Achievement implements Serializable {
    private String achievementId;

    private String recordId;

    private String achievementGrade;

    private String achievementEvaluate;

    private static final long serialVersionUID = 1L;

    public String getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(String achievementId) {
        this.achievementId = achievementId == null ? null : achievementId.trim();
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public String getAchievementGrade() {
        return achievementGrade;
    }

    public void setAchievementGrade(String achievementGrade) {
        this.achievementGrade = achievementGrade == null ? null : achievementGrade.trim();
    }

    public String getAchievementEvaluate() {
        return achievementEvaluate;
    }

    public void setAchievementEvaluate(String achievementEvaluate) {
        this.achievementEvaluate = achievementEvaluate == null ? null : achievementEvaluate.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", achievementId=").append(achievementId);
        sb.append(", recordId=").append(recordId);
        sb.append(", achievementGrade=").append(achievementGrade);
        sb.append(", achievementEvaluate=").append(achievementEvaluate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}