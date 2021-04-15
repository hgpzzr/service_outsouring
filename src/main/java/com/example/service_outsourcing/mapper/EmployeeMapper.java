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

    List<Employee> selectByPostId(String postId);

    int updateByPrimaryKey(Employee record);


    /**
     * @param postId  将该岗位下员工的岗位id改为null
     * @return
     */
    int updatePostByPostId(String postId);
}