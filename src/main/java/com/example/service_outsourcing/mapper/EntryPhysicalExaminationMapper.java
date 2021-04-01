package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.EntryPhysicalExamination;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EntryPhysicalExaminationMapper {
    int deleteByPrimaryKey(String physicalExaminationId);

    int insert(EntryPhysicalExamination record);

    EntryPhysicalExamination selectByPrimaryKey(String physicalExaminationId);

    List<EntryPhysicalExamination> selectAll();

    int updateByPrimaryKey(EntryPhysicalExamination record);
}