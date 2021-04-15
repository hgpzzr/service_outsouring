package com.example.service_outsourcing.service.impl;

import com.example.service_outsourcing.VO.DepartmentVO;
import com.example.service_outsourcing.VO.PostVO;
import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Department;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.enums.ResultEnum;
import com.example.service_outsourcing.form.InsertDepartmentForm;
import com.example.service_outsourcing.form.InsertPostForm;
import com.example.service_outsourcing.mapper.DepartmentMapper;
import com.example.service_outsourcing.mapper.EmployeeMapper;
import com.example.service_outsourcing.mapper.PostMapper;
import com.example.service_outsourcing.service.DepartmentService;
import com.example.service_outsourcing.service.PostCategoryService;
import com.example.service_outsourcing.service.PostService;
import com.example.service_outsourcing.utils.GenerateIdUtil;
import com.example.service_outsourcing.utils.ResultVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Jack
 * @Date 2021/4/12
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentMapper departmentMapper;

	@Autowired
	private GenerateIdUtil generateIdUtil;


	@Override
	public ResultVO insertDepartment(InsertDepartmentForm insertDepartmentForm) {
		boolean isHave = departmentMapper.checkExist(insertDepartmentForm.getDepartmentName(), insertDepartmentForm.getOrganizationId());
		if (isHave) {
			logger.error("【部门添加】: 部门名称已经存在");
			return ResultVOUtil.error(ResultEnum.DEPARTMENT_HAS_EXISTS);
		}
		Department department = new Department();
		BeanUtils.copyProperties(insertDepartmentForm, department);
		department.setDepartmentEffectiveness(1);
		String departmentId = generateIdUtil.getRandomId(departmentMapper, "DT");
		department.setDepartmentId(departmentId);
		if (departmentMapper.insert(department) != 1) {
			logger.error("【部门添加】: 岗位插入数据库失败");
			return ResultVOUtil.error(ResultEnum.DEPARTMENT_ADD_ERROR);
		}
		logger.info("【部门添加】: 岗位添加成功=={}", department);
		return ResultVOUtil.success();
	}

	@Override
	public ResultVO updateDepartment(Department department) {
		boolean isHave = departmentMapper.checkExist(department.getDepartmentName(), department.getOrganizationId());
		if (isHave) {
			logger.error("【部门修改】: 部门名称已经存在");
			return ResultVOUtil.error(ResultEnum.DEPARTMENT_HAS_EXISTS);
		}
		if (departmentMapper.updateByPrimaryKey(department) != 1) {
			logger.error("【部门修改】: 部门修改失败");
			return ResultVOUtil.error(ResultEnum.DEPARTMENT_UPDATE_ERROR);
		}
		return ResultVOUtil.success();
	}

	@Override
	public ResultVO getPostByDepartmentId(String departmentId) {
		DepartmentVO department = departmentMapper.selectByPrimaryKey(departmentId);
		if (department == null) {
			logger.error("【部门查找】: 部门查找失败");
			return ResultVOUtil.error(ResultEnum.DEPARTMENT_NOT_EXISTS);
		}
		return ResultVOUtil.success(department);
	}

	@Override
	public ResultVO getPostByOrganizationId(String organizationId) {
		List<DepartmentVO> department = departmentMapper.selectByOrganizationId(organizationId);
		if (department == null) {
			logger.error("【部门查找】: 部门查找失败");
			return ResultVOUtil.error(ResultEnum.DEPARTMENT_NOT_EXISTS);
		}
		return ResultVOUtil.success(department);
	}

	@Override
	public ResultVO departmentList() {
		List<DepartmentVO> departmentVOs = departmentMapper.selectAll();
		return ResultVOUtil.success(departmentVOs);
	}

}
