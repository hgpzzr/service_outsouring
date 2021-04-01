package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.WorkExperience;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WorkExperienceMapper {
    int deleteByPrimaryKey(String workId);

    int insert(WorkExperience record);

    WorkExperience selectByPrimaryKey(String workId);

    List<WorkExperience> selectByResumeId(String ResumeId);

    List<WorkExperience> selectAll();

    int updateByPrimaryKey(WorkExperience record);
}