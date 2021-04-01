package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class Post implements Serializable {
    private String postId;

    private String departmentId;

    private String psotName;

    private String postCategoryId;

    private Integer postMaxNum;

    private Integer postNowNum;

    private String postDescribe;

    private Integer postStatus;

    private static final long serialVersionUID = 1L;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getPsotName() {
        return psotName;
    }

    public void setPsotName(String psotName) {
        this.psotName = psotName == null ? null : psotName.trim();
    }

    public String getPostCategoryId() {
        return postCategoryId;
    }

    public void setPostCategoryId(String postCategoryId) {
        this.postCategoryId = postCategoryId == null ? null : postCategoryId.trim();
    }

    public Integer getPostMaxNum() {
        return postMaxNum;
    }

    public void setPostMaxNum(Integer postMaxNum) {
        this.postMaxNum = postMaxNum;
    }

    public Integer getPostNowNum() {
        return postNowNum;
    }

    public void setPostNowNum(Integer postNowNum) {
        this.postNowNum = postNowNum;
    }

    public String getPostDescribe() {
        return postDescribe;
    }

    public void setPostDescribe(String postDescribe) {
        this.postDescribe = postDescribe == null ? null : postDescribe.trim();
    }

    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postId=").append(postId);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", psotName=").append(psotName);
        sb.append(", postCategoryId=").append(postCategoryId);
        sb.append(", postMaxNum=").append(postMaxNum);
        sb.append(", postNowNum=").append(postNowNum);
        sb.append(", postDescribe=").append(postDescribe);
        sb.append(", postStatus=").append(postStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}