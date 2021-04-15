package com.example.service_outsourcing.controller;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Employee;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.form.EmployeeForm;
import com.example.service_outsourcing.form.InsertPostForm;
import com.example.service_outsourcing.service.EmployeeService;
import com.example.service_outsourcing.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/30 16:26
 */
@RestController
@Slf4j
@RequestMapping("/employees")
@CrossOrigin
@Api(tags = "员工接口")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping()
	@ApiOperation("添加新员工")
	public ResultVO insertPost(EmployeeForm employeeForm) {
		return employeeService.insertEmployee(employeeForm);
	}

	@GetMapping("/post_id/{postId}")
	@ApiOperation("以岗位id查询员工信息")
	public ResultVO getEmployeeByPostId(@PathVariable String postId) {
		return employeeService.getEmployeeByPostId(postId);
	}

	@PutMapping()
	@ApiOperation("修改员工信息")
	public ResultVO updatePost(Employee employee) {
		return employeeService.updateEmployee(employee);
	}

}
