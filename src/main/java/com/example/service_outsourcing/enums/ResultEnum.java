package com.example.service_outsourcing.enums;

import lombok.Getter;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/29 19:45
 */
@Getter
public enum  ResultEnum {
    USER_EXIST(1,"用户已存在"),
    DATABASE_OPTION_ERROR(2,"数据库操作失败"),
    USER_NOT_EXIST(3,"用户不存在"),
    PASSWORD_ERROR(4,"密码错误"),
    FILE_UPLOAD_ERROR(5,"文件上传失败"),
    CERTIFICATE_REPEAT_ERROR(6,"不能重复认证"),
    ENTERPRISES_WITHOUT_CERTIFICATION_ERROR(7,"企业未认证"),
    HR_NUM_ERROR(8,"hr账号数量到达上限"),
    RESUME_EXIST_ERROR(9,"简历已存在"),
    BASIC_INFORMATION_EXIST_ERROR(10,"该简历的基本信息已存在"),
    RESUME_NOT_EXIST_ERROR(11,"简历不存在"),
    EDUCATION_BACKGROUND_NOT_EXIST_ERROR(12,"教育背景不存在"),
    DATE_OVERLAP_ERROR(13,"时间重叠错误"),
    DATE_ORDER_ERROR(14,"开始时间比结束时间晚"),
    WORK_EXPERIENCE_NOT_EXIST_ERROR(15,"工作经历不存在"),
    PROJECT_EXPERIENCE_NOT_EXIST_ERROR(16,"项目经历不存在"),
    SKILL_NOT_EXIST_ERROR(17,"技能特长不存在"),
    CERTIFICATE_NOT_EXIST_ERROR(18,"证书不存在"),
    EMPLOYEE_NOT_EXIST_ERROR(19,"员工不存在"),
    PERSONNEL_MATERIAL_NOT_EXIST_ERROR(20,"人事材料不存在"),
    ID_NOT_EXIST_ERROR(21,"身份证不存在"),
    SOCIAL_INFO_NOT_EXIST_ERROR(22,"社会信息不存在"),
    ENTRY_REGISTER_NOT_EXIST_ERROR(23,"入职登记不存在"),
    PHYSICAL_EXAMINATION_NOT_EXIST_ERROR(24,"入职体检不存在"),
    QUIT_PROVE_NOT_EXIST_ERROR(25,"离职证明不存在"),
    PROVE_FILE_NOT_EXIST_ERROR(26,"证明材料不存在"),
    CONTRACT_NOT_EXIST_ERROR(27,"合同不存在"),
    ORGANIZATION_NOT_EXIST_ERROR(28,"企业不存在"),
    POST_NOT_EXIST_ERROR(29,"岗位不存在"),
    WORK_RECORD_NOT_EXIST_ERROR(30,"工作记录不存在"),
    DATE_EARLY_ERROR(31,"过期时间不能比当前时间早"),
    PROJECT_PROVE_FILE_EXIST_ERROR(32,"项目证明材料已存在"),
    ACHIEVEMENT_NOT_EXIST_ERROR(33,"绩效不存在"),
    EVALUATE_NOT_EXIST_ERROR(34,"评价不存在"),
    ATTENDANCE_NOT_EXIST_ERROR(35,"考勤不存在"),



    AUTHENTICATION_ERROR(401, "用户认证失败,请重新登录"),
    PERMISSION_DENNY(403, "权限不足"),
    NOT_FOUND(404, "url错误,请求路径未找到"),
    SERVER_ERROR(500, "服务器未知错误:%s"),
    BIND_ERROR(511, "参数校验错误:%s"),
    REQUEST_METHOD_ERROR(550, "不支持%s的请求方式");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
