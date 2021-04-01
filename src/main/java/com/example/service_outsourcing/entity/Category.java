package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class Category implements Serializable {
    private String postCategoryId;

    private String postCategoryName;

    private static final long serialVersionUID = 1L;

    public String getPostCategoryId() {
        return postCategoryId;
    }

    public void setPostCategoryId(String postCategoryId) {
        this.postCategoryId = postCategoryId == null ? null : postCategoryId.trim();
    }

    public String getPostCategoryName() {
        return postCategoryName;
    }

    public void setPostCategoryName(String postCategoryName) {
        this.postCategoryName = postCategoryName == null ? null : postCategoryName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postCategoryId=").append(postCategoryId);
        sb.append(", postCategoryName=").append(postCategoryName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}