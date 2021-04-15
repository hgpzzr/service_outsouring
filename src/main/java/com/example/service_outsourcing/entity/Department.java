package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class Department implements Serializable {

    private String departmentId;

    private String departmentName;

    private Integer departmentEffectiveness;

    private String establishTime;

    private Integer maxNum;

    private Integer nowNum;

    private String leader;

    private String peopleInCharge;

    private String organizationId;

    private static final long serialVersionUID = 1L;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Integer getDepartmentEffectiveness() {
        return departmentEffectiveness;
    }

    public void setDepartmentEffectiveness(Integer departmentEffectiveness) {
        this.departmentEffectiveness = departmentEffectiveness;
    }

    public String getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(String establishTime) {
        this.establishTime = establishTime == null ? null : establishTime.trim();
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public Integer getNowNum() {
        return nowNum;
    }

    public void setNowNum(Integer nowNum) {
        this.nowNum = nowNum;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    public String getPeopleInCharge() {
        return peopleInCharge;
    }

    public void setPeopleInCharge(String peopleInCharge) {
        this.peopleInCharge = peopleInCharge == null ? null : peopleInCharge.trim();
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId == null ? null : organizationId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentName=").append(departmentName);
        sb.append(", departmentEffectiveness=").append(departmentEffectiveness);
        sb.append(", establishTime=").append(establishTime);
        sb.append(", maxNum=").append(maxNum);
        sb.append(", nowNum=").append(nowNum);
        sb.append(", leader=").append(leader);
        sb.append(", peopleInCharge=").append(peopleInCharge);
        sb.append(", organizationId=").append(organizationId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}