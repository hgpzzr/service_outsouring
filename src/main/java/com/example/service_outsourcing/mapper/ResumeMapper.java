package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.Resume;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ResumeMapper {
    int deleteByPrimaryKey(String resumeId);

    int insert(Resume record);

    Resume selectByPrimaryKey(String resumeId);

    List<Resume> selectAll();

    int updateByPrimaryKey(Resume record);
}