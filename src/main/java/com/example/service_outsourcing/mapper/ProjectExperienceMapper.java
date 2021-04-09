package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.ProjectExperience;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectExperienceMapper {
    int deleteByPrimaryKey(String projectId);

    int deleteByResumeId(String resumeId);

    int insert(ProjectExperience record);

    ProjectExperience selectByPrimaryKey(String projectId);

    List<ProjectExperience> selectByResumeId(String resumeId);

    List<ProjectExperience> selectAll();

    int updateByPrimaryKey(ProjectExperience record);
}