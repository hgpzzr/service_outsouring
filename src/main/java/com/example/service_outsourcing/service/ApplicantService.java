package com.example.service_outsourcing.service;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.BasicInformation;
import com.example.service_outsourcing.form.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/30 15:19
 */
@Service
public interface ApplicantService {
    /**
     * 创建一份简历
     * @param IDNumber
     * @return
     */
    ResultVO createResume(String IDNumber);

    /**
     * 基本信息录入
     * @param form
     * @return
     */
    ResultVO insertBasicInformation(BasicInformationForm form, MultipartFile file);

    /**
     * 跟新基本信息
     * @param form
     * @return
     */
    ResultVO updateBasicInformation(BasicInformationForm form,MultipartFile file);

    /**
     * 浏览基本信息
     * @param resumeId
     * @return
     */
    ResultVO browseBasicInformation(String resumeId);

    /**
     * 插入教育背景
     * @param form
     * @return
     */
    ResultVO insertEducationBackground(EducationBackgroundForm form);

    /**
     * 更新教育背景
     * @param form
     * @return
     */
    ResultVO updateEducationBackground(UpdateEducationBackgroundForm form);

    /**
     * 浏览单个教育背景信息
     * @param backGroundId
     * @return
     */
    ResultVO browseEducationBackground(String backGroundId);

    /**
     * 浏览一张简历的所有教育背景信息
     * @param resumeId
     * @return
     */
    ResultVO browseAllEducationBackground(String resumeId);

    /**
     * 添加工作经历
     * @param form
     * @param file
     * @return
     */
    ResultVO insertWorkExperience(WorkExperienceForm form,MultipartFile file);

    /**
     * 删除工作经历
     * @param workId
     * @return
     */
    ResultVO deleteWorkExperience(String workId);

//    ResultVO updateWorkExperience(UpdateWorkExperienceForm form, MultipartFile file);

    /**
     * 添加项目经历
     * @param form
     * @param file
     * @return
     */
    ResultVO insertProjectExperience(ProjectExperienceForm form,MultipartFile file);

    /**
     * 删除项目经历
     * @param projectId
     * @return
     */
    ResultVO deleteProjectExperience(String projectId);

    /**
     * 添加技能特长
     * @param skillForm
     * @return
     */
    ResultVO insertSkill(SkillForm skillForm);

    /**
     * 删除技能特长
     * @param skillId
     * @return
     */
    ResultVO deleteSkill(String skillId);

    /**
     * 添加证书
     * @param form
     * @param file
     * @return
     */
    ResultVO insertCertificate(CertificateForm form,MultipartFile file);

    /**
     * 删除证书
     * @param certificateId
     * @return
     */
    ResultVO deleteCertificate(String certificateId);

    /**
     * 添加自我评价
     * @param form
     * @return
     */
    ResultVO insertSelfEvaluate(SelfEvaluateForm form);

    /**
     * 删除自我评价
     * @param selfEvaluateId
     * @return
     */
    ResultVO deleteSelfEvaluate(String selfEvaluateId);
}