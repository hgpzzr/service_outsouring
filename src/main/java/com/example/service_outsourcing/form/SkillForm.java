package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/31 18:43
 */
@Data
public class SkillForm {
    @ApiModelProperty("简历id")
    @NotBlank(message = "简历id不能为空")
    private String resumeId;

    @ApiModelProperty("技能名称")
    @NotBlank(message = "技能名称不能为空")
    private String skillName;

    @ApiModelProperty("技能描述")
    @NotBlank(message = "技能描述不能为空")
    private String skillDescribe;
}
