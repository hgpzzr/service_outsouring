package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class EntryRegister implements Serializable {
    private String registerId;

    private String materialId;

    private String registerPicUrl;

    private Integer registerPassStatus;

    private static final long serialVersionUID = 1L;

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId == null ? null : registerId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public String getRegisterPicUrl() {
        return registerPicUrl;
    }

    public void setRegisterPicUrl(String registerPicUrl) {
        this.registerPicUrl = registerPicUrl == null ? null : registerPicUrl.trim();
    }

    public Integer getRegisterPassStatus() {
        return registerPassStatus;
    }

    public void setRegisterPassStatus(Integer registerPassStatus) {
        this.registerPassStatus = registerPassStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", registerId=").append(registerId);
        sb.append(", materialId=").append(materialId);
        sb.append(", registerPicUrl=").append(registerPicUrl);
        sb.append(", registerPassStatus=").append(registerPassStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}