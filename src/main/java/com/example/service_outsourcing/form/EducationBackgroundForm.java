package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/30 19:19
 */
@Data
public class EducationBackgroundForm {
    @ApiModelProperty("简历id")
    @NotBlank(message = "简历id不能为空")
    private String resumeId;

    @ApiModelProperty("学校名称")
    @NotBlank(message = "学校名称不能为空")
    private String schoolName;

    @ApiModelProperty("专业")
    @NotBlank(message = "专业不能为空")
    private String major;

    @ApiModelProperty("开始时间")
    @NotBlank(message = "开始时间不能为空")
    private String beginTime;

    @ApiModelProperty("结束时间")
    @NotBlank(message = "结束时间不能为空")
    private String endTime;

    @ApiModelProperty("简要描述")
    @NotBlank(message = "简要描述不能为空")
    private String educationDescribe;
}
