package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/15 18:57
 */
@Data
public class UpdateProjectExperienceForm {
    @ApiModelProperty("项目id")
    @NotBlank(message = "项目id不能为空")
    private String projectId;

    @ApiModelProperty("开始时间")
    @NotBlank(message = "开始时间不能为空")
    private String beginTime;

    @ApiModelProperty("结束时间")
    @NotBlank(message = "结束时间不能为空")
    private String endTime;

    @ApiModelProperty("项目名称")
    @NotBlank(message = "项目名称不能为空")
    private String projectName;

    @ApiModelProperty("项目描述")
    @NotBlank(message = "项目描述不能为空")
    private String projectDescribe;
}
