package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class EntryPhysicalExamination implements Serializable {
    private String physicalExaminationId;

    private String materialId;

    private String physicalExaminationPicUrl;

    private Integer physicalExaminationStatus;

    private static final long serialVersionUID = 1L;

    public String getPhysicalExaminationId() {
        return physicalExaminationId;
    }

    public void setPhysicalExaminationId(String physicalExaminationId) {
        this.physicalExaminationId = physicalExaminationId == null ? null : physicalExaminationId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public String getPhysicalExaminationPicUrl() {
        return physicalExaminationPicUrl;
    }

    public void setPhysicalExaminationPicUrl(String physicalExaminationPicUrl) {
        this.physicalExaminationPicUrl = physicalExaminationPicUrl == null ? null : physicalExaminationPicUrl.trim();
    }

    public Integer getPhysicalExaminationStatus() {
        return physicalExaminationStatus;
    }

    public void setPhysicalExaminationStatus(Integer physicalExaminationStatus) {
        this.physicalExaminationStatus = physicalExaminationStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", physicalExaminationId=").append(physicalExaminationId);
        sb.append(", materialId=").append(materialId);
        sb.append(", physicalExaminationPicUrl=").append(physicalExaminationPicUrl);
        sb.append(", physicalExaminationStatus=").append(physicalExaminationStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}