package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/2 14:18
 */
@Data
public class SelfEvaluateForm {
    @ApiModelProperty("简历id")
    @NotBlank(message = "简历id不能为空")
    private String resumeId;

    @ApiModelProperty("简要描述")
    @NotBlank(message = "简要描述不能为空")
    private String evaluateDescribe;
}
