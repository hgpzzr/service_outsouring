package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/16 16:25
 */
@Data
public class UpdateIDForm {
	@NotBlank(message = "身份证id不能为空")
	@ApiModelProperty("身份证id")
	private String identityCardId;

	@NotBlank(message = "证件过期时间不能为空")
	@ApiModelProperty("证件过期时间")
	private String overdueTime;
}
