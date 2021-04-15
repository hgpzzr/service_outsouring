package com.example.service_outsourcing.service;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Department;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.form.InsertDepartmentForm;
import com.example.service_outsourcing.form.InsertPostForm;
import org.springframework.stereotype.Service;

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
public interface DepartmentService {
	/**
	 *  添加部门
	 */
	ResultVO insertDepartment(InsertDepartmentForm insertDepartmentForm);

	/**
	 *	修改其他信息，包括修改部门状态
	 */
	ResultVO updateDepartment(Department department);


	ResultVO getPostByDepartmentId(String departmentId);

	ResultVO getPostByOrganizationId(String organizationId);

	/**
	 *  获取所有岗位信息
	 * @return
	 */
	ResultVO departmentList();

}
