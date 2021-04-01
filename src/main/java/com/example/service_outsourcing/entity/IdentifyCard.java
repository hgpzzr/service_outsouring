package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class IdentifyCard implements Serializable {
    private String identityCardId;

    private String materialId;

    private String identityCardPicUrl;

    private Integer verificationStatus;

    private String overdueTime;

    private static final long serialVersionUID = 1L;

    public String getIdentityCardId() {
        return identityCardId;
    }

    public void setIdentityCardId(String identityCardId) {
        this.identityCardId = identityCardId == null ? null : identityCardId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public String getIdentityCardPicUrl() {
        return identityCardPicUrl;
    }

    public void setIdentityCardPicUrl(String identityCardPicUrl) {
        this.identityCardPicUrl = identityCardPicUrl == null ? null : identityCardPicUrl.trim();
    }

    public Integer getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(Integer verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(String overdueTime) {
        this.overdueTime = overdueTime == null ? null : overdueTime.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", identityCardId=").append(identityCardId);
        sb.append(", materialId=").append(materialId);
        sb.append(", identityCardPicUrl=").append(identityCardPicUrl);
        sb.append(", verificationStatus=").append(verificationStatus);
        sb.append(", overdueTime=").append(overdueTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}