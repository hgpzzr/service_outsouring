package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class Skill implements Serializable {
    private String skillId;

    private String resumeId;

    private String skillName;

    private String skillDescribe;

    private static final long serialVersionUID = 1L;

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId == null ? null : skillId.trim();
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId == null ? null : resumeId.trim();
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName == null ? null : skillName.trim();
    }

    public String getSkillDescribe() {
        return skillDescribe;
    }

    public void setSkillDescribe(String skillDescribe) {
        this.skillDescribe = skillDescribe == null ? null : skillDescribe.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", skillId=").append(skillId);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", skillName=").append(skillName);
        sb.append(", skillDescribe=").append(skillDescribe);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}