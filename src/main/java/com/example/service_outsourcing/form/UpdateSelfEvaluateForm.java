package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/15 19:34
 */
@Data
public class UpdateSelfEvaluateForm {
	@ApiModelProperty("自我评价id")
	@NotBlank(message = "自我评价id不能为空")
	private String selfEvaluateId;

	@ApiModelProperty("简要描述")
	@NotBlank(message = "简要描述不能为空")
	private String evaluateDescribe;
}
