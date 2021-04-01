package com.example.service_outsourcing.service.impl;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.*;
import com.example.service_outsourcing.enums.ResultEnum;
import com.example.service_outsourcing.form.*;
import com.example.service_outsourcing.mapper.*;
import com.example.service_outsourcing.service.ApplicantService;
import com.example.service_outsourcing.utils.FileUtil;
import com.example.service_outsourcing.utils.GenerateIdUtil;
import com.example.service_outsourcing.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/30 15:38
 */
@Slf4j
@Service
public class ApplicantServiceImpl implements ApplicantService {
    @Autowired
    private ResumeMapper resumeMapper;

    @Autowired
    private BasicInformationMapper basicInformationMapper;

    @Autowired
    private EducationBackgroundMapper educationBackgroundMapper;

    @Autowired
    private WorkExperienceMapper workExperienceMapper;

    @Autowired
    private ProjectExperienceMapper projectExperienceMapper;

    @Autowired
    private SkillMapper skillMapper;

    @Autowired
    private SelfEvaluateMapper selfEvaluateMapper;

    @Value("${img.basicInformation.url}")
    private String basicInformationUrl;

    @Value("${img.workExperience.url}")
    private String workExperienceUrl;

    @Value("${img.projectExperience.url}")
    private String projectExperienceUrl;

    @Override
    public ResultVO createResume(String IDNumber) {
        Resume resume1 = resumeMapper.selectByPrimaryKey(IDNumber);
        if(resume1 != null){
            log.error("【添加简历】：简历已存在，添加失败");
            return ResultVOUtil.error(ResultEnum.RESUME_EXIST_ERROR);
        }
        Resume resume = new Resume();
        resume.setEmployeeId(IDNumber);
        resume.setResumeId(GenerateIdUtil.getResumeId(resumeMapper));
        int insert = resumeMapper.insert(resume);
        if(insert != 1){
            log.error("【添加简历】：操作数据库是失败，添加失败");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        return ResultVOUtil.success(resume);
    }

    @Override
    public ResultVO insertBasicInformation(BasicInformationForm form, MultipartFile file) {
        if(resumeMapper.selectByPrimaryKey(form.getResumeId())==null){
            log.error("【添加基本信息】：简历不存在，添加失败");
            return ResultVOUtil.error(ResultEnum.RESUME_NOT_EXIST_ERROR);
        }
        BasicInformation Information = basicInformationMapper.selectByPrimaryKey(form.getResumeId());
        if(Information != null){
            log.error("【添加基本信息】：基本信息已存在，添加失败");
            return ResultVOUtil.error(ResultEnum.BASIC_INFORMATION_EXIST_ERROR);
        }
        BasicInformation basicInformation = new BasicInformation();
        BeanUtils.copyProperties(form,basicInformation);
        String filePath = basicInformationUrl;
        //获得图片路径
        StringBuilder stringBuilder = new StringBuilder();
        String fileName = FileUtil.generateFileName(file);
        stringBuilder.append(filePath).append(fileName);
        //上传图片
        boolean upload = FileUtil.upload(file, filePath,fileName);
        if(!upload){
            log.error("【添加基本信息】，文件上传失败，添加失败");
            return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
        }
        basicInformation.setPicUrl(stringBuilder.toString());
        int insert = basicInformationMapper.insert(basicInformation);
        if(insert != 1){
            log.error("【添加基本信息】：操作数据库失败，添加失败");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        return ResultVOUtil.success("添加成功");
    }

    @Override
    public ResultVO updateBasicInformation(BasicInformationForm form,MultipartFile file) {
        BasicInformation basicInformation = basicInformationMapper.selectByPrimaryKey(form.getResumeId());
        if(basicInformation == null){
            log.error("【更新基本信息】：简历不存在，更新失败");
            return ResultVOUtil.error(ResultEnum.RESUME_NOT_EXIST_ERROR);
        }
        //删除原来的图片
        FileUtil.deleteFile(basicInformation.getPicUrl());
        String filePath = basicInformationUrl;
        //获得图片路径
        StringBuilder stringBuilder = new StringBuilder();
        //图片名称
        String fileName = FileUtil.generateFileName(file);
        //图片url
        stringBuilder.append(filePath).append(fileName);
        //上传图片
        boolean upload = FileUtil.upload(file, filePath, fileName);
        if(!upload){
            log.error("【修改基本信息】，文件上传失败，修改失败");
            return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
        }
        BeanUtils.copyProperties(form,basicInformation);
        basicInformation.setPicUrl(stringBuilder.toString());
        int update = basicInformationMapper.updateByPrimaryKey(basicInformation);
        if(update != 1){
            log.error("【更新基本信息】：操作数据库失败，更新失败");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        return ResultVOUtil.success("更新成功");
    }

    @Override
    public ResultVO browseBasicInformation(String resumeId) {
        BasicInformation basicInformation = basicInformationMapper.selectByPrimaryKey(resumeId);
        return ResultVOUtil.success(basicInformation);
    }

    @Override
    public ResultVO insertEducationBackground(EducationBackgroundForm form) {
        Resume resume = resumeMapper.selectByPrimaryKey(form.getResumeId());
        if(resume == null){
            log.error("【添加教育背景】：简历不存在，添加失败");
            return ResultVOUtil.error(ResultEnum.RESUME_NOT_EXIST_ERROR);
        }
        if(form.getBeginTime().compareTo(form.getEndTime()) >0 ){
            log.error("【添加教育背景】：开始时间比结束时间晚，添加失败");
            return ResultVOUtil.error(ResultEnum.DATE_ORDER_ERROR);
        }
        //判断时间是否重叠
        List<EducationBackground> educationBackgrounds = educationBackgroundMapper.selectByResumeId(form.getResumeId());
        for (int i = 0; i < educationBackgrounds.size(); i++) {
            EducationBackground educationBackground = educationBackgrounds.get(i);
//            log.info("educationBackground:{}",educationBackground.toString());
            if(educationBackground.getBeginTime().compareTo(form.getEndTime())<0 || educationBackground.getEndTime().compareTo(form.getBeginTime())>0){
                log.error("【添加教育背景】：时间重叠，添加失败");
                return ResultVOUtil.error(ResultEnum.DATE_OVERLAP_ERROR);
            }
        }
        //加入数据库
        EducationBackground educationBackground = new EducationBackground();
        BeanUtils.copyProperties(form,educationBackground);
        String backgroundId = GenerateIdUtil.getBackgroundId(educationBackgroundMapper);
        educationBackground.setBackgroundId(backgroundId);
        int insert = educationBackgroundMapper.insert(educationBackground);
        if(insert!=1){
            log.error("【添加教育背景】：数据库操作失败，添加失败");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        Map<String,String> map = new HashMap<>();
        map.put("backgroundId",backgroundId);
        map.put("message","添加成功");
        return ResultVOUtil.success(map);
    }

    @Override
    public ResultVO updateEducationBackground(UpdateEducationBackgroundForm form) {
        EducationBackground educationBackground = educationBackgroundMapper.selectByPrimaryKey(form.getBackGroundId());
        if(educationBackground == null){
            log.error("【更新教育背景】教育背景不存在，更新失败");
            return ResultVOUtil.error(ResultEnum.EDUCATION_BACKGROUND_NOT_EXIST_ERROR);
        }
        BeanUtils.copyProperties(form,educationBackground);
        int update = educationBackgroundMapper.updateByPrimaryKey(educationBackground);
        if(update != 1){
            log.error("【更新教育背景】：数据库操作失败，更新失败");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        return ResultVOUtil.success("更新成功");
    }

    @Override
    public ResultVO browseEducationBackground(String backGroundId) {
        EducationBackground educationBackground = educationBackgroundMapper.selectByPrimaryKey(backGroundId);
        return ResultVOUtil.success(educationBackground);
    }

    @Override
    public ResultVO browseAllEducationBackground(String resumeId) {
        List<EducationBackground> educationBackgrounds = educationBackgroundMapper.selectByResumeId(resumeId);
        return ResultVOUtil.success(educationBackgrounds);
    }

    @Override
    public ResultVO insertWorkExperience(WorkExperienceForm form, MultipartFile file) {
        Resume resume = resumeMapper.selectByPrimaryKey(form.getResumeId());
        if(resume == null){
            log.error("【添加工作经历】：简历不存在，添加失败");
            return ResultVOUtil.error(ResultEnum.RESUME_NOT_EXIST_ERROR);
        }
        //判断开始时间是否晚于结束时间
        if(form.getBeginTime().compareTo(form.getEndTime()) >0 ){
            log.error("【添加工作经历】：开始时间比结束时间晚，添加失败");
            return ResultVOUtil.error(ResultEnum.DATE_ORDER_ERROR);
        }
        //判断时间是否重叠
        List<WorkExperience> workExperiences = workExperienceMapper.selectByResumeId(form.getResumeId());
        for (int i = 0; i < workExperiences.size(); i++) {
            WorkExperience workExperience = workExperiences.get(i);
            if(workExperience.getBeginTime().compareTo(form.getEndTime())<0 || workExperience.getEndTime().compareTo(form.getBeginTime())>0){
                log.error("【添加工作经历】：时间重叠，添加失败");
                return ResultVOUtil.error(ResultEnum.DATE_OVERLAP_ERROR);
            }
        }
        //获得图片路径
        String filePath = workExperienceUrl;
        StringBuilder stringBuilder = new StringBuilder();
        String fileName = FileUtil.generateFileName(file);
        stringBuilder.append(filePath).append(fileName);
        //上传图片
        boolean upload = FileUtil.upload(file, filePath, fileName);
        if(!upload){
            log.error("【添加工作经历】：文件上传失败，添加失败");
            return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
        }
        //存入数据库中
        WorkExperience workExperience = new WorkExperience();
        BeanUtils.copyProperties(form,workExperience);
        workExperience.setWorkProvePicUrl(stringBuilder.toString());

        //生成随机的work_id
        String workId = GenerateIdUtil.getWorkId(workExperienceMapper);
        workExperience.setWorkId(workId);
        int insert = workExperienceMapper.insert(workExperience);
        if(insert != 1){
            log.error("【添加工作经历】：数据库操作失败，添加失败");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        Map<String,String> map = new HashMap<>();
        map.put("workId",workId);
        map.put("message","添加成功");
        return ResultVOUtil.success(map);
    }

    @Override
    public ResultVO deleteWorkExperience(String workId) {
        WorkExperience workExperience = workExperienceMapper.selectByPrimaryKey(workId);
        if(workExperience == null){
            log.error("【删除工作经历】：工作经历不存在，删除失败");
            return ResultVOUtil.error(ResultEnum.WORK_EXPERIENCE_NOT_EXIST_ERROR);
        }
        FileUtil.deleteFile(workExperience.getWorkProvePicUrl());
        int delete = workExperienceMapper.deleteByPrimaryKey(workId);
        if(delete != 1){
            log.error("【删除工作经历】：数据库操作失败，删除失败");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        return ResultVOUtil.success("删除成功");
    }

    @Override
    public ResultVO insertProjectExperience(ProjectExperienceForm form, MultipartFile file) {
        //判断简历是否存在
        Resume resume = resumeMapper.selectByPrimaryKey(form.getResumeId());
        if(resume == null){
            log.error("【添加项目经历】：简历不存在，添加失败");
            return ResultVOUtil.error(ResultEnum.RESUME_NOT_EXIST_ERROR);
        }
        //判断开始时间是否晚于结束时间
        if(form.getBeginTime().compareTo(form.getEndTime()) >0 ){
            log.error("【添加项目经历】：开始时间比结束时间晚，添加失败");
            return ResultVOUtil.error(ResultEnum.DATE_ORDER_ERROR);
        }
        //判断时间是否重叠
        List<ProjectExperience> projectExperiences = projectExperienceMapper.selectByResumeId(form.getResumeId());
        for (int i = 0; i < projectExperiences.size(); i++) {
            ProjectExperience projectExperience = projectExperiences.get(i);
            if(projectExperience.getBeginTime().compareTo(form.getEndTime())<0 || projectExperience.getEndTime().compareTo(form.getBeginTime())>0){
                log.error("【添加项目经历】：时间重叠，添加失败");
                return ResultVOUtil.error(ResultEnum.DATE_OVERLAP_ERROR);
            }
        }
        //获得图片路径
        String filePath = projectExperienceUrl;
        StringBuilder stringBuilder = new StringBuilder();
        String fileName = FileUtil.generateFileName(file);
        stringBuilder.append(filePath).append(fileName);
        //上传图片
        boolean upload = FileUtil.upload(file, filePath, fileName);
        if(!upload){
            log.error("【添加项目经历】：文件上传失败，添加失败");
            return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
        }
        //存入数据库
        ProjectExperience projectExperience = new ProjectExperience();
        BeanUtils.copyProperties(form,projectExperience);
        projectExperience.setProjectProvePicUrl(stringBuilder.toString());
        String projectId = GenerateIdUtil.getProjectId(projectExperienceMapper);
        projectExperience.setProjectId(projectId);
        Map<String,String> map = new HashMap<>();
        map.put("projectId",projectId);
        map.put("message","添加成功");
        return ResultVOUtil.success(map);
    }

    @Override
    public ResultVO deleteProjectExperience(String projectId) {
        //判断项目经历是否存在
        ProjectExperience projectExperience = projectExperienceMapper.selectByPrimaryKey(projectId);
        if(projectExperience == null){
            log.error("【删除项目经历】项目经历不存在，删除失败");
            return ResultVOUtil.error(ResultEnum.PROJECT_EXPERIENCE_NOT_EXIST_ERROR);
        }
        //删除图片
        FileUtil.deleteFile(projectExperience.getProjectProvePicUrl());
        //删除数据库中的记录
        int delete = projectExperienceMapper.deleteByPrimaryKey(projectId);
        if(delete != 1){
            log.error("【删除项目经历】：数据库操作失败，删除失败");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        return ResultVOUtil.success("删除成功");
    }

    @Override
    public ResultVO insertSkill(SkillForm skillForm) {
        //判断简历是否存在
        Resume resume = resumeMapper.selectByPrimaryKey(skillForm.getResumeId());
        if(resume == null){
            log.error("【添加技能特长】：简历不存在，添加失败");
            return ResultVOUtil.error(ResultEnum.RESUME_NOT_EXIST_ERROR);
        }

        return null;
    }

    @Override
    public ResultVO deleteSkill(String skillId) {
        return null;
    }
}
