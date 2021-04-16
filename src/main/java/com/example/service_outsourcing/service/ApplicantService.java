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

    /**
     * 更新工作经历
     * @param form
     * @param file
     * @return
     */
    ResultVO updateWorkExperience(UpdateWorkExperienceForm form,MultipartFile file);

    /**
     * 获得单个工作经历
     * @param workId
     * @return
     */
    ResultVO getWorkExperience(String workId);

    /**
     * 获得一张简历的所有工作经历
     * @param resumeId
     * @return
     */
    ResultVO getAllWorkExperience(String resumeId);

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
     * 更新项目经历
     * @param form
     * @param file
     * @return
     */
    ResultVO updateProjectExperience(UpdateProjectExperienceForm form,MultipartFile file);

    /**
     * 获得单个项目经历
     * @param projectId
     * @return
     */
    ResultVO getProjectExperience(String projectId);

    /**
     * 获得一张简历下的所有项目经历
     * @param resumeId
     * @return
     */
    ResultVO getAllProjectExperience(String resumeId);
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
     * 更新技能特长
     * @param form
     * @return
     */
    ResultVO updateSkill(UpdateSkillForm form);

    /**
     * 获得单个技能特长
     * @param skillId
     * @return
     */
    ResultVO getSkill(String skillId);

    /**
     * 获得一张简历下的所有技能特长
     * @param resumeId
     * @return
     */
    ResultVO getAllSkill(String resumeId);

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
     * 更新证书
     * @param form
     * @param file
     * @return
     */
    ResultVO updateCertificate(UpdateCertificateForm form,MultipartFile file);

    /**
     * 获得单个证书
     * @param certificateId
     * @return
     */
    ResultVO getCertificate(String certificateId);

    /**
     * 获得一张简历下的所有证书
     * @param resumeId
     * @return
     */
    ResultVO getAllCertificate(String resumeId);

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

    ResultVO updateSelfEvaluate(UpdateSelfEvaluateForm form);

    /**
     * 获得自我评价
     * @param selfEvaluateId
     * @return
     */
    ResultVO getSelfEvaluate(String selfEvaluateId);


    /**
     * 删除简历
     * @param resumeId
     * @return
     */
    ResultVO deleteResume(String resumeId);

    /**
     * 浏览简历
     * @param resumeId
     * @return
     */
    ResultVO browseResume(String resumeId);
}