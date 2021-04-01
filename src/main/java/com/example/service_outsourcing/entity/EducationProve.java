package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class EducationProve implements Serializable {
    private String educationId;

    private String materialId;

    private String educationPicUrl;

    private Integer educationProveStatus;

    private static final long serialVersionUID = 1L;

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId == null ? null : educationId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public String getEducationPicUrl() {
        return educationPicUrl;
    }

    public void setEducationPicUrl(String educationPicUrl) {
        this.educationPicUrl = educationPicUrl == null ? null : educationPicUrl.trim();
    }

    public Integer getEducationProveStatus() {
        return educationProveStatus;
    }

    public void setEducationProveStatus(Integer educationProveStatus) {
        this.educationProveStatus = educationProveStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", educationId=").append(educationId);
        sb.append(", materialId=").append(materialId);
        sb.append(", educationPicUrl=").append(educationPicUrl);
        sb.append(", educationProveStatus=").append(educationProveStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}