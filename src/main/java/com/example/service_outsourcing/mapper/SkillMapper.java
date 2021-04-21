package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.Skill;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SkillMapper {
    int deleteByPrimaryKey(String skillId);

    int isExist(String skillId);

    int deleteByResumeId(String resumeId);

    int insert(Skill record);

    Skill selectByPrimaryKey(String skillId);

    List<Skill> selectByResumeId(String resumeId);

    List<Skill> selectAll();

    int updateByPrimaryKey(Skill record);
}