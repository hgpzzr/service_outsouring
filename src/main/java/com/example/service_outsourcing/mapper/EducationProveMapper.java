package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.EducationProve;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EducationProveMapper {
    int deleteByPrimaryKey(String educationId);

    int insert(EducationProve record);

    EducationProve selectByPrimaryKey(String educationId);

    List<EducationProve> selectAll();

    int updateByPrimaryKey(EducationProve record);
}