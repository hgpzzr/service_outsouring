package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class ProveFile implements Serializable {
    private String proveId;

    private String materialId;

    private String projectId;

    private String proveFilePicUrl;

    private Integer proveStatus;

    private static final long serialVersionUID = 1L;

    public String getProveId() {
        return proveId;
    }

    public void setProveId(String proveId) {
        this.proveId = proveId == null ? null : proveId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getProveFilePicUrl() {
        return proveFilePicUrl;
    }

    public void setProveFilePicUrl(String proveFilePicUrl) {
        this.proveFilePicUrl = proveFilePicUrl == null ? null : proveFilePicUrl.trim();
    }

    public Integer getProveStatus() {
        return proveStatus;
    }

    public void setProveStatus(Integer proveStatus) {
        this.proveStatus = proveStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", proveId=").append(proveId);
        sb.append(", materialId=").append(materialId);
        sb.append(", projectId=").append(projectId);
        sb.append(", proveFilePicUrl=").append(proveFilePicUrl);
        sb.append(", proveStatus=").append(proveStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}