package com.example.service_outsourcing.service;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Employee;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.form.EmployeeForm;
import com.example.service_outsourcing.form.InsertPostForm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 类描述：
 *
 * @ClassName PostService
 * @Description TODO
 * @Author Jack
 * @Date 2021/4/12 19:35
 * @Version 1.0
 */
@Service
public interface EmployeeService {

	/**
	 * 添加
	 * @param employeeForm
	 * @return
	 */
	ResultVO insertEmployee(EmployeeForm employeeForm);

	/**
	 * 修改
	 * @param employee
	 * @return
	 */
	ResultVO updateEmployee(Employee employee);

	/**
	 * 查询某个岗位下所有员工
	 * @param postId
	 * @return
	 */
	ResultVO getEmployeeByPostId(String postId);

}
