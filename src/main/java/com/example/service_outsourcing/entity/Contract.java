package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class Contract implements Serializable {
    private String contractId;

    private String materialId;

    private String contractFilePicUrl;

    private Integer contractStatus;

    private String expirationTime;

    private static final long serialVersionUID = 1L;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getExpirationTimed() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime == null ? null : expirationTime.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public String getContractFilePicUrl() {
        return contractFilePicUrl;
    }

    public void setContractFilePicUrl(String contractFilePicUrl) {
        this.contractFilePicUrl = contractFilePicUrl == null ? null : contractFilePicUrl.trim();
    }

    public Integer getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(Integer contractStatus) {
        this.contractStatus = contractStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", contractId=").append(contractId);
        sb.append(", materialId=").append(materialId);
        sb.append(", contractFilePicUrl=").append(contractFilePicUrl);
        sb.append(", contractStatus=").append(contractStatus);
        sb.append(", expirationTime=").append(expirationTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}