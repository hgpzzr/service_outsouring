package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class Evaluate implements Serializable {
    private String evaluateId;

    private String recordId;

    private String evaluateTime;

    private String evaluateType;

    private String evaluateContent;

    private String evaluatePerson;

    private String evaluatePersonRelationship;

    private String evaluateName;

    private static final long serialVersionUID = 1L;

    public String getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId == null ? null : evaluateId.trim();
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public String getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(String evaluateTime) {
        this.evaluateTime = evaluateTime == null ? null : evaluateTime.trim();
    }

    public String getEvaluateType() {
        return evaluateType;
    }

    public void setEvaluateType(String evaluateType) {
        this.evaluateType = evaluateType == null ? null : evaluateType.trim();
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent == null ? null : evaluateContent.trim();
    }

    public String getEvaluatePerson() {
        return evaluatePerson;
    }

    public void setEvaluatePerson(String evaluatePerson) {
        this.evaluatePerson = evaluatePerson == null ? null : evaluatePerson.trim();
    }

    public String getEvaluatePersonRelationship() {
        return evaluatePersonRelationship;
    }

    public void setEvaluatePersonRelationship(String evaluatePersonRelationship) {
        this.evaluatePersonRelationship = evaluatePersonRelationship == null ? null : evaluatePersonRelationship.trim();
    }

    public String getEvaluateName() {
        return evaluateName;
    }

    public void setEvaluateName(String evaluateName) {
        this.evaluateName = evaluateName == null ? null : evaluateName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", evaluateId=").append(evaluateId);
        sb.append(", recordId=").append(recordId);
        sb.append(", evaluateTime=").append(evaluateTime);
        sb.append(", evaluateType=").append(evaluateType);
        sb.append(", evaluateContent=").append(evaluateContent);
        sb.append(", evaluatePerson=").append(evaluatePerson);
        sb.append(", evaluatePersonRelationship=").append(evaluatePersonRelationship);
        sb.append(", evaluateName=").append(evaluateName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}