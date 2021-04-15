package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author Jack
 * @Date 2021/4/12
 */
@Data
public class UpdateOrganizationForm {

	@ApiModelProperty("组织id")
	@NotBlank(message = "组织id不能为空")
	private String organizationId;

	@ApiModelProperty("组织名称")
	@NotBlank(message = "组织名称不能为空")
	private String organizationName;

	@ApiModelProperty("组织状态")
	@NotNull(message = "组织状态不能为空")
	private Integer authenticationStatus;


}
