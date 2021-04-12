package com.example.service_outsourcing.utils;


import com.example.service_outsourcing.entity.User;
import com.example.service_outsourcing.mapper.*;
import lombok.extern.java.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author HGP
 * @create 2020/9/11 20:32
 */
@Log
public class GenerateIdUtil {

    /**
     * 随机生成不重复的user_id
     * @param userMapper
     * @return
     */
    public static String getUserId(UserMapper userMapper){
        String num;
        do{
            Random random= new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum +10000000;
            num = String.valueOf(intNum);
        }while (userMapper.selectByPrimaryKey(num) != null);
        return num;
    }

    /**
     * 随机生成不重复的organization_id
     * @param organizationMapper
     * @return
     */
    public static String getOrganizationId(OrganizationMapper organizationMapper){
        String num;
        do{
            Random random= new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum +10000000;
            num = String.valueOf(intNum);
        }while (organizationMapper.selectByPrimaryKey(num) != null);
        return num;
    }

    /**
     * 随机生成不重复的resume_id
     * @param resumeMapper
     * @return
     */
    public static String getResumeId(ResumeMapper resumeMapper){
        String num;
        StringBuilder stringBuilder = new StringBuilder("RE");
        do{
            Random random= new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum +10000000;
            num = String.valueOf(intNum);
        }while (resumeMapper.selectByPrimaryKey(num) != null);
        stringBuilder.append(num);
        return stringBuilder.toString();
    }

    /**
     * 随机生成不重复的background_id
     * @param educationBackgroundMapper
     * @return
     */
    public static String getBackgroundId(EducationBackgroundMapper educationBackgroundMapper){
        String num;
        StringBuilder stringBuilder = new StringBuilder("EB");
        do{
            Random random= new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum +10000000;
            num = String.valueOf(intNum);
        }while (educationBackgroundMapper.selectByPrimaryKey(num) != null);
        stringBuilder.append(num);
        return stringBuilder.toString();
    }

    /**
     * 随机生成不重复的background_id
     * @param workExperienceMapper
     * @return
     */
    public static String getWorkId(WorkExperienceMapper workExperienceMapper){
        String num;
        StringBuilder stringBuilder = new StringBuilder("WE");
        do{
            Random random= new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum +10000000;
            num = String.valueOf(intNum);
        }while (workExperienceMapper.selectByPrimaryKey(num) != null);
        stringBuilder.append(num);
        return stringBuilder.toString();
    }

    /**
     * 随机生成不重复的background_id
     * @param projectExperienceMapper
     * @return
     */
    public static String getProjectId(ProjectExperienceMapper projectExperienceMapper){
        String num;
        StringBuilder stringBuilder = new StringBuilder("PE");
        do{
            Random random= new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum +10000000;
            num = String.valueOf(intNum);
        }while (projectExperienceMapper.selectByPrimaryKey(num) != null);
        stringBuilder.append(num);
        return stringBuilder.toString();
    }

    /**
     * 随机生成不重复的background_id
     * @param skillMapper
     * @return
     */
    public static String getSkillId(SkillMapper skillMapper){
        String num;
        StringBuilder stringBuilder = new StringBuilder("JN");
        do{
            Random random= new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum +10000000;
            num = String.valueOf(intNum);
        }while (skillMapper.selectByPrimaryKey(num) != null);
        stringBuilder.append(num);
        return stringBuilder.toString();
    }

    /**
     * 随机生成不重复的background_id
     * @param certificateMapper
     * @return
     */
    public static String getCertificateId(CertificateMapper certificateMapper){
        String num;
        StringBuilder stringBuilder = new StringBuilder("ZS");
        do{
            Random random= new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum +10000000;
            num = String.valueOf(intNum);
        }while (certificateMapper.selectByPrimaryKey(num) != null);
        stringBuilder.append(num);
        return stringBuilder.toString();
    }

    /**
     * 随机生成不重复的selfEvaluateId
     * @param selfEvaluateMapper
     * @return
     */
    public static String getSelfEvaluateId(SelfEvaluateMapper selfEvaluateMapper){
        String num;
        StringBuilder stringBuilder = new StringBuilder("SE");
        do{
            Random random= new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum +10000000;
            num = String.valueOf(intNum);
        }while (selfEvaluateMapper.selectByPrimaryKey(num) != null);
        stringBuilder.append(num);
        return stringBuilder.toString();
    }

    /**
     * 随机生成不重复的materialId
     * @param personnelMaterialMapper
     * @return
     */
    public static String getMaterialId(PersonnelMaterialMapper personnelMaterialMapper){
        String num;
        StringBuilder stringBuilder = new StringBuilder("PM");
        do{
            Random random= new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum +10000000;
            num = String.valueOf(intNum);
        }while (personnelMaterialMapper.selectByPrimaryKey(num) != null);
        stringBuilder.append(num);
        return stringBuilder.toString();
    }

    /**
     * 随机生成不重复的materialId
     * @param identifyCardMapper
     * @return
     */
    public static String getIdentifyCardId(IdentifyCardMapper identifyCardMapper){
        String num;
        StringBuilder stringBuilder = new StringBuilder("ID");
        do{
            Random random= new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum +10000000;
            num = String.valueOf(intNum);
        }while (identifyCardMapper.selectByPrimaryKey(num) != null);
        stringBuilder.append(num);
        return stringBuilder.toString();
    }

    /**
     * 随机生成不重复的materialId
     * @param educationProveMapper
     * @return
     */
    public static String getEducationId(EducationProveMapper educationProveMapper){
        String num;
        StringBuilder stringBuilder = new StringBuilder("ID");
        do{
            Random random= new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum +10000000;
            num = String.valueOf(intNum);
        }while (educationProveMapper.selectByPrimaryKey(num) != null);
        stringBuilder.append(num);
        return stringBuilder.toString();
    }

    /**
     * 随机生成不重复的materialId
     * @param socialInfoMapper
     * @return
     */
    public static String getSocialInfoId(SocialInfoMapper socialInfoMapper){
        String num;
        StringBuilder stringBuilder = new StringBuilder("SI");
        do{
            Random random= new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum +10000000;
            num = String.valueOf(intNum);
        }while (socialInfoMapper.selectByPrimaryKey(num) != null);
        stringBuilder.append(num);
        return stringBuilder.toString();
    }

    /**
     * 随机生成不重复的materialId
     * @param entryRegisterMapper
     * @return
     */
    public static String getRegisterId(EntryRegisterMapper entryRegisterMapper){
        String num;
        StringBuilder stringBuilder = new StringBuilder("ER");
        do{
            Random random= new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum +10000000;
            num = String.valueOf(intNum);
        }while (entryRegisterMapper.selectByPrimaryKey(num) != null);
        stringBuilder.append(num);
        return stringBuilder.toString();
    }
}
