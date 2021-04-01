package com.example.service_outsourcing.entity;

import java.io.Serializable;

public class Certificate implements Serializable {
    private String certificateId;

    private String resumeId;

    private String certificateName;

    private String certificateDescribe;

    private String certificateProvePicUrl;

    private static final long serialVersionUID = 1L;

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId == null ? null : certificateId.trim();
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId == null ? null : resumeId.trim();
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName == null ? null : certificateName.trim();
    }

    public String getCertificateDescribe() {
        return certificateDescribe;
    }

    public void setCertificateDescribe(String certificateDescribe) {
        this.certificateDescribe = certificateDescribe == null ? null : certificateDescribe.trim();
    }

    public String getCertificateProvePicUrl() {
        return certificateProvePicUrl;
    }

    public void setCertificateProvePicUrl(String certificateProvePicUrl) {
        this.certificateProvePicUrl = certificateProvePicUrl == null ? null : certificateProvePicUrl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", certificateId=").append(certificateId);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", certificateName=").append(certificateName);
        sb.append(", certificateDescribe=").append(certificateDescribe);
        sb.append(", certificateProvePicUrl=").append(certificateProvePicUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}