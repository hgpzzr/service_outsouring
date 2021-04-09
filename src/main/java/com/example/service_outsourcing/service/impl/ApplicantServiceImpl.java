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
import sun.security.action.PutAllAction;

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
    private CertificateMapper certificateMapper;
    @Autowired
    private SelfEvaluateMapper selfEvaluateMapper;

    @Value("${img.basicInformation.url}")
    private String basicInformationUrl;

    @Value("${img.workExperience.url}")
    private String workExperienceUrl;

    @Value("${img.projectExperience.url}")
    private String projectExperienceUrl;

    @Value("${img.certificate.url}")
    private String certificateUrl;

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
            if(educationBackground.getBeginTime().compareTo(form.getEndTime())<=0 && educationBackground.getBeginTime().compareTo(form.getBeginTime())>=0
                    || educationBackground.getEndTime().compareTo(form.getBeginTime())>=0&&educationBackground.getEndTime().compareTo(form.getEndTime())<=0){
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
            if(workExperience.getBeginTime().compareTo(form.getEndTime())<=0 && workExperience.getBeginTime().compareTo(form.getBeginTime())>=0
                    || workExperience.getEndTime().compareTo(form.getBeginTime())>=0&&workExperience.getEndTime().compareTo(form.getEndTime())<=0){
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
            if(projectExperience.getBeginTime().compareTo(form.getEndTime())<=0 && projectExperience.getBeginTime().compareTo(form.getBeginTime())>=0
                    || projectExperience.getEndTime().compareTo(form.getBeginTime())>=0&&projectExperience.getEndTime().compareTo(form.getEndTime())<=0){
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
        int insert = projectExperienceMapper.insert(projectExperience);
        if(insert != 1){
            log.error("【添加项目经历】：数据库操作错误");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
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
        //存入数据库
        Skill skill = new Skill();
        BeanUtils.copyProperties(skillForm,skill);
        String skillId = GenerateIdUtil.getSkillId(skillMapper);
        skill.setSkillId(skillId);
        int insert = skillMapper.insert(skill);
        if(insert != 1){
            log.error("【添加技能特长】：数据库操作失败");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }

        Map<String,String> map = new HashMap<>();
        map.put("skillId",skillId);
        map.put("message","添加成功");
        return ResultVOUtil.success(map);
    }

    @Override
    public ResultVO deleteSkill(String skillId) {
        if(skillMapper.selectByPrimaryKey(skillId) == null){
            log.error("【删除技能特长】：技能不存在，删除失败");
            return ResultVOUtil.error(ResultEnum.SKILL_NOT_EXIST_ERROR);
        }
        int delete = skillMapper.deleteByPrimaryKey(skillId);
        if(delete != 1){
            log.error("【删除技能特长】：数据库操作失败");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        return ResultVOUtil.success("删除成功");
    }

    @Override
    public ResultVO insertCertificate(CertificateForm form, MultipartFile file) {
        if(resumeMapper.selectByPrimaryKey(form.getResumeId()) == null){
            log.error("【添加证书】：简历不存在");
            return ResultVOUtil.error(ResultEnum.RESUME_NOT_EXIST_ERROR);
        }
        //获得图片路径
        String filePath = certificateUrl;
        StringBuilder stringBuilder = new StringBuilder();
        //获得新文件名
        String fileName = FileUtil.generateFileName(file);
        stringBuilder.append(filePath).append(fileName);
        //上传图片
        boolean upload = FileUtil.upload(file, filePath, fileName);
        if(!upload){
            log.error("【添加证书】：文件上传失败");
            return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
        }
        //保存到数据库
        Certificate certificate = new Certificate();
        BeanUtils.copyProperties(form,certificate);
        certificate.setCertificateProvePicUrl(stringBuilder.toString());
        //获得certificateId
        String certificateId = GenerateIdUtil.getCertificateId(certificateMapper);
        certificate.setCertificateId(certificateId);
        int insert = certificateMapper.insert(certificate);
        if(insert != 1){
            log.error("【添加证书】：数据库操作失败");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }

        Map<String,String> map = new HashMap<>();
        map.put("certificateId",certificateId);
        map.put("message","添加成功");
        return ResultVOUtil.success(map);
    }

    @Override
    public ResultVO deleteCertificate(String certificateId) {
        Certificate certificate = certificateMapper.selectByPrimaryKey(certificateId);
        if(certificate == null){
            log.error("【删除证书】：证书不存在");
            return ResultVOUtil.error(ResultEnum.CERTIFICATE_NOT_EXIST_ERROR);
        }
        //删除图片
        FileUtil.deleteFile(certificate.getCertificateProvePicUrl());
        //删除数据库记录
        int delete = certificateMapper.deleteByPrimaryKey(certificateId);
        if(delete != 1){
            log.error("【删除证书】：数据库操作失败");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        return ResultVOUtil.success("删除成功");
    }

    @Override
    public ResultVO insertSelfEvaluate(SelfEvaluateForm form) {
        //判断简历是否存在
        if(resumeMapper.selectByPrimaryKey(form.getResumeId()) == null){
            log.error("【添加自我评价】：简历不存在");
            return ResultVOUtil.error(ResultEnum.RESUME_NOT_EXIST_ERROR);
        }
        //加入数据库
        SelfEvaluate selfEvaluate = new SelfEvaluate();
        BeanUtils.copyProperties(form,selfEvaluate);
        String selfEvaluateId = GenerateIdUtil.getSelfEvaluateId(selfEvaluateMapper);
        selfEvaluate.setSelfEvaluateId(selfEvaluateId);
        int insert = selfEvaluateMapper.insert(selfEvaluate);
        if(insert != 1){
            log.error("【添加自我评价】");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        Map<String,String> map = new HashMap<>();
        map.put("selfEvaluateId",selfEvaluateId);
        map.put("message","添加成功");
        return ResultVOUtil.success(map);
    }

    @Override
    public ResultVO deleteSelfEvaluate(String selfEvaluateId) {
        int delete = selfEvaluateMapper.deleteByPrimaryKey(selfEvaluateId);
        if(delete != 1){
            log.error("【删除自我评价】:数据库操作失败");
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        return ResultVOUtil.success("删除成功");
    }

    @Override
    public ResultVO deleteResume(String resumeId) {
        if(resumeMapper.selectByPrimaryKey(resumeId) == null){
            log.error("【删除简历】：简历不存在");
            return ResultVOUtil.error(ResultEnum.RESUME_NOT_EXIST_ERROR);
        }
        //删除基本信息
        basicInformationMapper.deleteByPrimaryKey(resumeId);
        FileUtil.deleteFile(basicInformationMapper.selectByPrimaryKey(resumeId).getPicUrl());
        //删除教育背景
        educationBackgroundMapper.deleteByResumeId(resumeId);
        //删除工作经历
        List<WorkExperience> workExperiences = workExperienceMapper.selectByResumeId(resumeId);
        for (int i = 0; i < workExperiences.size(); i++) {
            WorkExperience workExperience = workExperiences.get(i);
            FileUtil.deleteFile(workExperience.getWorkProvePicUrl());
        }
        workExperienceMapper.deleteByResumeId(resumeId);
        //删除项目经验
        List<ProjectExperience> projectExperiences = projectExperienceMapper.selectByResumeId(resumeId);
        for (int i = 0; i < projectExperiences.size(); i++) {
            ProjectExperience projectExperience = projectExperiences.get(i);
            FileUtil.deleteFile(projectExperience.getProjectProvePicUrl());
        }
        projectExperienceMapper.deleteByResumeId(resumeId);
        //删除技能特长
        skillMapper.deleteByResumeId(resumeId);
        //删除荣誉证书
        List<Certificate> certificates = certificateMapper.selectByResumeId(resumeId);
        for (int i = 0; i < certificates.size(); i++) {
            Certificate certificate = certificates.get(i);
            FileUtil.deleteFile(certificate.getCertificateProvePicUrl());
        }
        certificateMapper.deleteByResumeId(resumeId);
        //删除自我评价
        selfEvaluateMapper.deleteByResumeId(resumeId);
        //删除简历
        resumeMapper.deleteByPrimaryKey(resumeId);
        return ResultVOUtil.success("删除成功");
    }

    @Override
    public ResultVO browseResume(String resumeId) {
        //获得基本信息
        BasicInformation basicInformation = basicInformationMapper.selectByPrimaryKey(resumeId);
        //获得教育背景
        List<EducationBackground> educationBackgrounds = educationBackgroundMapper.selectByResumeId(resumeId);
        //获得工作经历
        List<WorkExperience> workExperiences = workExperienceMapper.selectByResumeId(resumeId);
        //获得项目经历
        List<ProjectExperience> projectExperiences = projectExperienceMapper.selectByResumeId(resumeId);
        //获得技能特长
        List<Skill> skills = skillMapper.selectByResumeId(resumeId);
        //获得证书
        List<Certificate> certificates = certificateMapper.selectByResumeId(resumeId);
        //获得自我评价
        List<SelfEvaluate> selfEvaluates = selfEvaluateMapper.selectByResumeId(resumeId);
        Map map = new HashMap();
        map.put("basicInformation",basicInformation);
        map.put("educationBackgrounds",educationBackgrounds);
        map.put("workExperiences",workExperiences);
        map.put("projectExperiences",projectExperiences);
        map.put("skills",skills);
        map.put("certificates",certificates);
        map.put("selfEvaluates",selfEvaluates);
        return ResultVOUtil.success(map);
    }
}
