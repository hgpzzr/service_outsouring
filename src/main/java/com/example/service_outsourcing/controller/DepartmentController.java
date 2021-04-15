package com.example.service_outsourcing.controller;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Department;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.form.InsertDepartmentForm;
import com.example.service_outsourcing.form.InsertPostForm;
import com.example.service_outsourcing.service.DepartmentService;
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
@RequestMapping("/departments")
@CrossOrigin
@Api(tags = "部门接口")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping()
    @ApiOperation("添加新部门")
    public ResultVO insertDepartment(InsertDepartmentForm insertDepartmentForm){
        return departmentService.insertDepartment(insertDepartmentForm);
    }

    @GetMapping("/organization_id/{organizationId}")
    @ApiOperation("以组织id查询部门信息")
    public ResultVO getDepartmentByOrganizationId(@PathVariable String organizationId){
        return departmentService.getPostByOrganizationId(organizationId);
    }

    @GetMapping("/department_id/{departmentId}")
    @ApiOperation("以部门id查询岗位信息")
    public ResultVO getDepartmentByDepartmentId(@PathVariable String departmentId){
        return departmentService.getPostByDepartmentId(departmentId);
    }

    @GetMapping()
    @ApiOperation("查询所有部门信息")
    public ResultVO departmentList(){
        return departmentService.departmentList();
    }

    @PutMapping()
    @ApiOperation("修改岗位信息")
    public ResultVO updatePost(Department department){
        return departmentService.updateDepartment(department);
    }

}
