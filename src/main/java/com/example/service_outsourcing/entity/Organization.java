package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class Organization implements Serializable {
    private String organizationId;

    private String organizationName;

    private Integer authenticationStatus;

    private String authenticationPicUrl;

    private static final long serialVersionUID = 1L;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId == null ? null : organizationId.trim();
    }


    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName == null ? null : organizationName.trim();
    }

    public Integer getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(Integer authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public String getAuthenticationPicUrl() {
        return authenticationPicUrl;
    }

    public void setAuthenticationPicUrl(String authenticationPicUrl) {
        this.authenticationPicUrl = authenticationPicUrl == null ? null : authenticationPicUrl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", organizationId=").append(organizationId);
        sb.append(", organizationName=").append(organizationName);
        sb.append(", authenticationStatus=").append(authenticationStatus);
        sb.append(", authenticationPicUrl=").append(authenticationPicUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}