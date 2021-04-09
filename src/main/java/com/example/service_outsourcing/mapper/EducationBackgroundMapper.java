package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.EducationBackground;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EducationBackgroundMapper {
    int deleteByPrimaryKey(String backgroundId);

    int deleteByResumeId(String resumeId);

    int insert(EducationBackground record);

    EducationBackground selectByPrimaryKey(String backgroundId);

    List<EducationBackground> selectByResumeId(String resumeId);

    List<EducationBackground> selectAll();

    int updateByPrimaryKey(EducationBackground record);
}