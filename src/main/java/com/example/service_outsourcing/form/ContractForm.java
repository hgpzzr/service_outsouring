package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/13 10:32
 */
@Data
public class ContractForm {
	@ApiModelProperty("材料id")
	@NotBlank(message = "材料id不能为空")
	private String materialId;

	@ApiModelProperty("过期时间")
	@NotBlank(message = "过期时间不能为空")
	private String expirationTime;
}
