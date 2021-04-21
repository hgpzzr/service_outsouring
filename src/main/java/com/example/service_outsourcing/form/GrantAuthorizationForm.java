package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/17 18:57
 */
@Data
public class GrantAuthorizationForm {
	@ApiModelProperty("用户id")
	@NotBlank(message = "用户id不能为空")
	private String userId;

	@ApiModelProperty("员工id")
	@NotBlank(message = "员工id不能为空")
	private String employeeId;

	@ApiModelProperty("过期时间")
	@NotBlank(message = "过期时间不能为空")
	private String expirationTime;
}
