package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.WorkExperience;
import com.example.service_outsourcing.entity.WorkRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/9 18:45
 */
@Repository
public interface WorkRecordMapper {
	int deleteByPrimaryKey(String recordId);

	int insert(WorkRecord record);

	WorkRecord selectByPrimaryKey(String recordId);

	List<WorkRecord> selectAll();

	List<WorkRecord> selectByEmployeeId(String employeeId);

	int updateByPrimaryKey(WorkRecord record);
}
