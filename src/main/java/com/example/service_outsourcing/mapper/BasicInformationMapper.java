package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.BasicInformation;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BasicInformationMapper {
    int deleteByPrimaryKey(String resumeId);

    int insert(BasicInformation record);

    BasicInformation selectByPrimaryKey(String resumeId);

    List<BasicInformation> selectAll();

    int updateByPrimaryKey(BasicInformation record);
}