package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.Certificate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CertificateMapper {
    int deleteByPrimaryKey(String certificateId);

    int deleteByResumeId(String resumeId);

    int insert(Certificate record);

    Certificate selectByPrimaryKey(String certificateId);

    List<Certificate> selectByResumeId(String resumeId);

    List<Certificate> selectAll();

    int updateByPrimaryKey(Certificate record);
}