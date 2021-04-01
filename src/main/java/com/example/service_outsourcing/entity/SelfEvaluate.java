package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class SelfEvaluate implements Serializable {
    private String selfEvaluateId;

    private String resumeId;

    private String evaluateDescribe;

    private static final long serialVersionUID = 1L;

    public String getSelfEvaluateId() {
        return selfEvaluateId;
    }

    public void setSelfEvaluateId(String selfEvaluateId) {
        this.selfEvaluateId = selfEvaluateId == null ? null : selfEvaluateId.trim();
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId == null ? null : resumeId.trim();
    }

    public String getEvaluateDescribe() {
        return evaluateDescribe;
    }

    public void setEvaluateDescribe(String evaluateDescribe) {
        this.evaluateDescribe = evaluateDescribe == null ? null : evaluateDescribe.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", selfEvaluateId=").append(selfEvaluateId);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", evaluateDescribe=").append(evaluateDescribe);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}