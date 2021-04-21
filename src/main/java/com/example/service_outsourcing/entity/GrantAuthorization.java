package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class GrantAuthorization implements Serializable {
    private String grantAuthorizationId;

    private String userId;

    private String employeeId;

    private String expirationTime;

    private static final long serialVersionUID = 1L;

    public String getGrantAuthorizationId() {
        return grantAuthorizationId;
    }

    public void setGrantAuthorizationId(String grantAuthorizationId) {
        this.grantAuthorizationId = grantAuthorizationId == null ? null : grantAuthorizationId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime == null ? null : expirationTime.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", grantAuthorizationId=").append(grantAuthorizationId);
        sb.append(", userId=").append(userId);
        sb.append(", employeeId=").append(employeeId);
        sb.append(", expirationTime=").append(expirationTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}