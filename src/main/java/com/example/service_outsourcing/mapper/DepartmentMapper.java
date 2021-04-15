package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.VO.DepartmentVO;
import com.example.service_outsourcing.VO.PostVO;
import com.example.service_outsourcing.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {

    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    DepartmentVO selectByPrimaryKey(String departmentId);

    Boolean checkExist(String departmentName,String organizationId);

    List<DepartmentVO> selectAll();

    List<DepartmentVO> selectByOrganizationId(String organizationId);

    int updateByPrimaryKey(Department record);
}