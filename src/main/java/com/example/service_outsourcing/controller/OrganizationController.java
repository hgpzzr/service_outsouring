package com.example.service_outsourcing.controller;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.Post;
import com.example.service_outsourcing.form.InsertPostForm;
import com.example.service_outsourcing.form.UpdateOrganizationForm;
import com.example.service_outsourcing.service.OrganizationService;
import com.example.service_outsourcing.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/30 16:26
 */
@RestController
@Slf4j
@RequestMapping("/organizations")
@CrossOrigin
@Api(tags = "组织接口")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/organization_id/{organizationId}")
    @ApiOperation("以组织id查询组织信息")
    public ResultVO getOrganizationById(@PathVariable String organizationId){
        return organizationService.getOrganizationById(organizationId);
    }

    @GetMapping()
    @ApiOperation("查询所有组织信息")
    public ResultVO organizationList(){
        return organizationService.organizationList();
    }

    @PutMapping()
    @ApiOperation("修改组织信息")
    public ResultVO updateOrganization(UpdateOrganizationForm updateOrganizationForm,@RequestParam("file") MultipartFile file){
        return organizationService.updateOrganization(updateOrganizationForm,file);
    }

}
