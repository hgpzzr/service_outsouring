package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;

    private String passwd;

    private Integer role;

    private String userName;

    private Integer membershipLevel;

    private String organizationId;

    private Integer isHr;

    private String departmentId;

    private String leaderId;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(Integer membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId == null ? null : organizationId.trim();
    }

    public Integer getIsHr() {
        return isHr;
    }

    public void setIsHr(Integer isHr) {
        this.isHr = isHr;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId == null ? null : leaderId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", passwd=").append(passwd);
        sb.append(", role=").append(role);
        sb.append(", userName=").append(userName);
        sb.append(", membershipLevel=").append(membershipLevel);
        sb.append(", organizationId=").append(organizationId);
        sb.append(", isHr=").append(isHr);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", leaderId=").append(leaderId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}