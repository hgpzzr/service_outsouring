package com.example.service_outsourcing.mapper;

import com.example.service_outsourcing.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeMapper {
    int deleteByPrimaryKey(String employeeId);

    int insert(Employee record);

    Employee selectByPrimaryKey(String employeeId);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);
}