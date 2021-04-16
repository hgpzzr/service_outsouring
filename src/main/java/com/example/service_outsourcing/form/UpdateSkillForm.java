package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/15 19:16
 */
@Data
public class UpdateSkillForm {
    @ApiModelProperty("技能id")
    @NotBlank(message = "技能id不能为空")
    private String skillId;

    @ApiModelProperty("技能名称")
    @NotBlank(message = "技能名称不能为空")
    private String skillName;

    @ApiModelProperty("技能描述")
    @NotBlank(message = "技能描述不能为空")
    private String skillDescribe;
}
