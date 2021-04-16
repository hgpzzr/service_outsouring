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

    @PutMapping("updateBasicInformation")
    @ApiOperation("修改基本信息")
    public ResultVO updateBasicInformation(BasicInformationForm form,@RequestParam("file")MultipartFile file){
        return applicantService.updateBasicInformation(form,file);
    }

    @PostMapping("/insertEducationBackground")
    @ApiOperation("添加教育背景")
    public ResultVO insertEducationBackground(EducationBackgroundForm form){
        return applicantService.insertEducationBackground(form);
    }

    @PutMapping("/updateEducationBackground")
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

    @DeleteMapping("/deleteWorkExperience")
    @ApiOperation("删除工作经历")
    public ResultVO deleteWorkExperience(String workId){
        return applicantService.deleteWorkExperience(workId);
    }

    @PutMapping("/updateWorkExperience")
    @ApiOperation("更新工作经历")
    public ResultVO updateWorkExperience(UpdateWorkExperienceForm form,@RequestParam("file")MultipartFile file){
        return applicantService.updateWorkExperience(form,file);
    }

    @GetMapping("/getWorkExperience")
    @ApiOperation("获得单个工作经历")
    public ResultVO getWorkExperience(String workId){
        return applicantService.getWorkExperience(workId);
    }

    @GetMapping("/getAllWorkExperience")
    @ApiOperation("获得一张简历下的所有工作经历")
    public ResultVO getAllWorkExperience(String resumeId){
        return applicantService.getAllWorkExperience(resumeId);
    }

    @PostMapping("insertProjectExperience")
    @ApiOperation("添加项目经历")
    public ResultVO insertProjectExperience(ProjectExperienceForm form,@RequestParam("file")MultipartFile file){
        return applicantService.insertProjectExperience(form,file);
    }

    @DeleteMapping("/deleteProjectExperience")
    @ApiOperation("删除项目经历")
    public ResultVO deleteProjectExperience(String projectId){
        return applicantService.deleteProjectExperience(projectId);
    }

    @PutMapping("/updateProjectExperience")
    @ApiOperation("更新项目经历")
    public ResultVO updateProjectExperience(UpdateProjectExperienceForm form,@RequestParam("file")MultipartFile file){
        return applicantService.updateProjectExperience(form,file);
    }

    @GetMapping("/getProjectExperience")
    @ApiOperation("获得单个项目经历")
    public ResultVO getProjectExperience(String projectId){
        return applicantService.getProjectExperience(projectId);
    }

    @GetMapping("/getAllProjectExperience")
    @ApiOperation("获得一张简历下的所有项目经历")
    public ResultVO getAllProjectExperience(String resumeId){
        return applicantService.getAllProjectExperience(resumeId);
    }

    @PostMapping("/insertSkill")
    @ApiOperation("添加技能特长")
    public ResultVO insertSkill(SkillForm form){
        return applicantService.insertSkill(form);
    }

    @DeleteMapping("/deleteSkill")
    @ApiOperation("删除技能特长")
    public ResultVO deleteSkill(String skillId){
        return applicantService.deleteSkill(skillId);
    }

    @PutMapping("/updateSkill")
    @ApiOperation("更新技能特长")
    public ResultVO updateSkill(UpdateSkillForm form){
        return applicantService.updateSkill(form);
    }

    @GetMapping("/getSkill")
    @ApiOperation("获得单个技能特长")
    public ResultVO getSkill(String skillId){
        return applicantService.getSkill(skillId);
    }

    @GetMapping("/getAllSkill")
    @ApiOperation("获得一张简历下的所有技能特长")
    public ResultVO getAllSkill(String resumeId){
        return applicantService.getAllSkill(resumeId);
    }

    @PostMapping("/insertCertificate")
    @ApiOperation("添加证书")
    public ResultVO insertCertificate(CertificateForm form,@RequestParam("file") MultipartFile file){
        return applicantService.insertCertificate(form,file);
    }

    @DeleteMapping("deleteCertificate")
    @ApiOperation("删除证书")
    public ResultVO deleteCertificate(String certificateId){
        return applicantService.deleteCertificate(certificateId);
    }

    @PutMapping("/updateCertificate")
    @ApiOperation("更新证书")
    public ResultVO updateCertificate(UpdateCertificateForm form,@RequestParam("file") MultipartFile file){
        return applicantService.updateCertificate(form,file);
    }

    @GetMapping("/getCertificate")
    @ApiOperation("获得单个证书")
    public ResultVO getCertificate(String certificateId){
        return applicantService.getCertificate(certificateId);
    }

    @GetMapping("/getAllCertificate")
    @ApiOperation("获得一张简历下的所有证书")
    public ResultVO getAllCertificate(String resumeId){
        return applicantService.getAllCertificate(resumeId);
    }

    @PostMapping("/insertSelfEvaluate")
    @ApiOperation("添加自我评价")
    public ResultVO insertSelfEvaluate(SelfEvaluateForm form){
        return applicantService.insertSelfEvaluate(form);
    }

    @DeleteMapping("/deleteSelfEvaluate")
    @ApiOperation("删除自我评价")
    public ResultVO deleteSelfEvaluate(String selfEvaluateId){
        return applicantService.deleteSelfEvaluate(selfEvaluateId);
    }

    @PutMapping("/updateSelfEvaluate")
    @ApiOperation("更新自我评价")
    public ResultVO updateSelfEvaluate(UpdateSelfEvaluateForm form){return applicantService.updateSelfEvaluate(form);}

    @GetMapping("/getSelfEvaluate")
    @ApiOperation("获得单个自我评价")
    public ResultVO getSelfEvaluate(String selfEvaluateId){
        return applicantService.getSelfEvaluate(selfEvaluateId);
    }


    @DeleteMapping("/deleteResume")
    @ApiOperation("删除简历")
    public ResultVO deleteResume(String resumeId){
        return applicantService.deleteResume(resumeId);
    }

    @GetMapping("browseResume")
    @ApiOperation("查看简历")
    public ResultVO browseResume(String resumeId){
        return applicantService.browseResume(resumeId);
    }
}
