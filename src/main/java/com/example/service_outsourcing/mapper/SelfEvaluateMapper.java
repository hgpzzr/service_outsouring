package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.SelfEvaluate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SelfEvaluateMapper {
    int deleteByPrimaryKey(String selfEvaluateId);

    int deleteByResumeId(String resumeId);

    int insert(SelfEvaluate record);

    SelfEvaluate selectByPrimaryKey(String selfEvaluateId);

    List<SelfEvaluate> selectByResumeId(String resumeId);

    List<SelfEvaluate> selectAll();

    int updateByPrimaryKey(SelfEvaluate record);
}