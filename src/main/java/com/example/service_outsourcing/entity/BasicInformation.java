package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class BasicInformation implements Serializable {
    private String resumeId;

    private String name;

    private String birth;

    private Integer gender;

    private String phone;

    private String email;

    private Integer workYear;

    private String picUrl;

    private Integer marryStatus;

    private String politicalOutlook;

    private String nativePlace;

    private String nation;

    private Double height;

    private Double weight;

    private String educationLevel;

    private static final long serialVersionUID = 1L;

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId == null ? null : resumeId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getWorkYear() {
        return workYear;
    }

    public void setWorkYear(Integer workYear) {
        this.workYear = workYear;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Integer getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(Integer marryStatus) {
        this.marryStatus = marryStatus;
    }

    public String getPoliticalOutlook() {
        return politicalOutlook;
    }

    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook == null ? null : politicalOutlook.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel == null ? null : educationLevel.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resumeId=").append(resumeId);
        sb.append(", name=").append(name);
        sb.append(", birth=").append(birth);
        sb.append(", gender=").append(gender);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", workYear=").append(workYear);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", marryStatus=").append(marryStatus);
        sb.append(", politicalOutlook=").append(politicalOutlook);
        sb.append(", nativePlace=").append(nativePlace);
        sb.append(", nation=").append(nation);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", educationLevel=").append(educationLevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}