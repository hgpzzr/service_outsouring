package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class QuitProve implements Serializable {
    private String quitId;

    private String materialId;

    private String quitFilePicUrl;

    private Integer quitStatus;

    private static final long serialVersionUID = 1L;

    public String getQuitId() {
        return quitId;
    }

    public void setQuitId(String quitId) {
        this.quitId = quitId == null ? null : quitId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public String getQuitFilePicUrl() {
        return quitFilePicUrl;
    }

    public void setQuitFilePicUrl(String quitFilePicUrl) {
        this.quitFilePicUrl = quitFilePicUrl == null ? null : quitFilePicUrl.trim();
    }

    public Integer getQuitStatus() {
        return quitStatus;
    }

    public void setQuitStatus(Integer quitStatus) {
        this.quitStatus = quitStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", quitId=").append(quitId);
        sb.append(", materialId=").append(materialId);
        sb.append(", quitFilePicUrl=").append(quitFilePicUrl);
        sb.append(", quitStatus=").append(quitStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}