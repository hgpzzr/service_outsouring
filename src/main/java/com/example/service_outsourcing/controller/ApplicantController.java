package com.example.service_outsourcing.controller;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.form.*;
import com.example.service_outsourcing.mapper.WorkExperienceMapper;
import com.example.service_outsourcing.service.ApplicantService;
import com.example.service_outsourcing.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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
@RequestMapping("/applicant")
@CrossOrigin
@Api(tags = "应聘者接口")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @PostMapping("/createResume")
    @ApiOperation("创建一张简历")
    @ApiModelProperty(value = "身份证号",name = "IDNumber",required = true)
    public ResultVO createResume(String IDNumber ){
        return applicantService.createResume(IDNumber);
    }

    @PostMapping("/insertBasicInformation")
    @ApiOperation("录入基本信息")
    public ResultVO insertBasicInformation(BasicInformationForm form, @RequestParam("file") MultipartFile file){
        return applicantService.insertBasicInformation(form,file);
    }

    @GetMapping("/browseBasicInformation")
    @ApiOperation("浏览基本信息")
    public ResultVO browseBasicInformation(String resumeId){
        return applicantService.browseBasicInformation(resumeId);
    }

    @PostMapping("updateBasicInformation")
    @ApiOperation("修改基本信息")
    public ResultVO updateBasicInformation(BasicInformationForm form,@RequestParam("file")MultipartFile file){
        return applicantService.updateBasicInformation(form,file);
    }

    @PostMapping("/insertEducationBackground")
    @ApiOperation("添加教育背景")
    public ResultVO insertEducationBackground(EducationBackgroundForm form){
        return applicantService.insertEducationBackground(form);
    }

    @PostMapping("/updateEducationBackground")
    @ApiOperation("更新教育背景")
    public ResultVO updateEducationBackground(UpdateEducationBackgroundForm form){
        return applicantService.updateEducationBackground(form);
    }

    @GetMapping("/browseEducationBackground")
    @ApiOperation("查看单个教育背景")
    public ResultVO browseEducationBackground(String backGroundId){
        return applicantService.browseEducationBackground(backGroundId);
    }

    @GetMapping("browseAllEducationBackground")
    @ApiOperation("查看一张简历下的所有教育背景")
    public ResultVO browseAllEducationBackground(String resumeId){
        return applicantService.browseAllEducationBackground(resumeId);
    }

    @PostMapping("/insertWorkExperience")
    @ApiOperation("添加工作经历")
    public ResultVO insertWorkExperience(WorkExperienceForm form,@RequestParam("file")MultipartFile file){
        return applicantService.insertWorkExperience(form,file);
    }

    @GetMapping("/deleteWorkExperience")
    @ApiOperation("删除工作经历")
    public ResultVO deleteWorkExperience(String workId){
        return applicantService.deleteWorkExperience(workId);
    }

    @PostMapping("insertProjectExperience")
    @ApiOperation("添加项目经历")
    public ResultVO insertProjectExperience(ProjectExperienceForm form,@RequestParam("file")MultipartFile file){
        return applicantService.insertProjectExperience(form,file);
    }

    @GetMapping("/deleteProjectExperience")
    @ApiOperation("删除项目经历")
    public ResultVO deleteProjectExperience(String projectId){
        return applicantService.deleteProjectExperience(projectId);
    }

    @PostMapping("/insertSkill")
    @ApiOperation("添加技能特长")
    public ResultVO insertSkill(SkillForm form){
        return applicantService.insertSkill(form);
    }

    @GetMapping("/deleteSkill")
    @ApiOperation("删除技能特长")
    public ResultVO deleteSkill(String skillId){
        return applicantService.deleteSkill(skillId);
    }

    @PostMapping("/insertCertificate")
    @ApiOperation("添加证书")
    public ResultVO insertCertificate(CertificateForm form,@RequestParam("file") MultipartFile file){
        return applicantService.insertCertificate(form,file);
    }

    @GetMapping("deleteCertificate")
    @ApiOperation("删除证书")
    public ResultVO deleteCertificate(String certificateId){
        return applicantService.deleteCertificate(certificateId);
    }

    @PostMapping("/insertSelfEvaluate")
    @ApiOperation("添加自我评价")
    public ResultVO insertSelfEvaluate(SelfEvaluateForm form){
        return applicantService.insertSelfEvaluate(form);
    }

    @GetMapping("/deleteSelfEvaluate")
    @ApiOperation("删除自我评价")
    public ResultVO deleteSelfEvaluate(String selfEvaluateId){
        return applicantService.deleteSelfEvaluate(selfEvaluateId);
    }
}
