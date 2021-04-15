package com.example.service_outsourcing.service.impl;

import com.example.service_outsourcing.VO.DepartmentVO;
import com.example.service_outsourcing.VO.PostVO;
import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Department;
import com.example.service_outsourcing.entity.Employee;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.enums.ResultEnum;
import com.example.service_outsourcing.form.EmployeeForm;
import com.example.service_outsourcing.form.InsertPostForm;
import com.example.service_outsourcing.mapper.DepartmentMapper;
import com.example.service_outsourcing.mapper.EmployeeMapper;
import com.example.service_outsourcing.mapper.PostMapper;
import com.example.service_outsourcing.service.DepartmentService;
import com.example.service_outsourcing.service.EmployeeService;
import com.example.service_outsourcing.service.PostCategoryService;
import com.example.service_outsourcing.service.PostService;
import com.example.service_outsourcing.utils.GenerateIdUtil;
import com.example.service_outsourcing.utils.ResultVOUtil;
import javafx.geometry.Pos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @Description
 * @Author Jack
 * @Date 2021/4/12
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private GenerateIdUtil generateIdUtil;

	@Autowired
	private PostMapper postMapper;

	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResultVO insertEmployee(EmployeeForm employeeForm) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeForm, employee);
		String employeeId = generateIdUtil.getRandomId(employeeMapper, "EP");
		employee.setEmployeeId(employeeId);
		employee.setStatus("在职");
		if (employeeMapper.insert(employee) != 1) {
			logger.error("【员工添加】 : 员工添加数据库错误");
			return ResultVOUtil.error(ResultEnum.EMPLOYEE_ADD_ERROR);
		}
		try {
			PostVO postVO = postMapper.selectByPrimaryKey(employeeForm.getPostId());
			Post post = new Post();
			BeanUtils.copyProperties(postVO, post);
			post.setPostNowNum(post.getPostNowNum() + 1);
			postMapper.updateByPrimaryKey(post);
			DepartmentVO departmentVo = departmentMapper.selectByPrimaryKey(post.getDepartmentId());
			Department department = new Department();
			BeanUtils.copyProperties(departmentVo, department);
			department.setNowNum(department.getMaxNum() + 1);
			departmentMapper.updateByPrimaryKey(department);
		} catch (BeansException e) {
			e.printStackTrace();
			logger.error("【员工添加】 : 员工添加数据库错误");
			return ResultVOUtil.error(ResultEnum.EMPLOYEE_ADD_ERROR);
		}
		return ResultVOUtil.success();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResultVO updateEmployee(Employee employee) {
		Employee employee1 = employeeMapper.selectByPrimaryKey(employee.getEmployeeId());
		if (employee1 == null) {
			logger.error("【员工修改】 : 员工修改错误，员工Id不存在");
			return ResultVOUtil.error(ResultEnum.EMPLOYEE_NOT_EXISTS);
		}
		if (!employee1.getPostId().equals(employee.getPostId())) {
			try {
				PostVO postVO = postMapper.selectByPrimaryKey(employee1.getPostId());
				Post post = new Post();
				BeanUtils.copyProperties(postVO, post);
				post.setPostNowNum(post.getPostNowNum() - 1);
				postMapper.updateByPrimaryKey(post);
				PostVO postVO2 = postMapper.selectByPrimaryKey(employee.getPostId());
				Post post2 = new Post();
				BeanUtils.copyProperties(postVO2, post2);
				post2.setPostNowNum(post2.getPostNowNum() + 1);
				postMapper.updateByPrimaryKey(post2);
				if (!post.getDepartmentId().equals(post2.getDepartmentId())) {
					DepartmentVO departmentVo = departmentMapper.selectByPrimaryKey(post.getDepartmentId());
					Department department = new Department();
					BeanUtils.copyProperties(departmentVo, department);
					department.setNowNum(department.getMaxNum() - 1);
					departmentMapper.updateByPrimaryKey(department);
					DepartmentVO departmentVo2 = departmentMapper.selectByPrimaryKey(post2.getDepartmentId());
					Department department2 = new Department();
					BeanUtils.copyProperties(departmentVo2, department2);
					department2.setNowNum(department2.getMaxNum() +1 );
					departmentMapper.updateByPrimaryKey(department2);
				}
			} catch (BeansException e) {
				e.printStackTrace();
				logger.error("【员工添加】 : 员工添加数据库错误");
				return ResultVOUtil.error(ResultEnum.EMPLOYEE_ADD_ERROR);
			}

		}
		if (employeeMapper.updateByPrimaryKey(employee) != 1) {
			logger.error("【员工修改】 : 员工修改错误，修改数据库失败");
			return ResultVOUtil.error(ResultEnum.EMPLOYEE_UPDATE_ERROR);
		}
		return ResultVOUtil.success();
	}

	@Override
	public ResultVO getEmployeeByPostId(String postId) {
		List<Employee> employees = employeeMapper.selectByPostId(postId);
		return ResultVOUtil.success(employees);
	}
}
