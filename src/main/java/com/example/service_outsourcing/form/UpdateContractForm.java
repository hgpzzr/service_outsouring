package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/17 13:18
 */
@Data
public class UpdateContractForm {
	@ApiModelProperty("合同id")
	@NotBlank(message = "合同id不能为空")
	private String contractId;

	@ApiModelProperty("过期时间")
	@NotBlank(message = "过期时间不能为空")
	private String expirationTime;
}
