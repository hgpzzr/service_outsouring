package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/9 17:18
 */
@Data
public class IDForm {
	@NotBlank(message = "材料id不能为空")
	@ApiModelProperty("材料id")
	private String materialId;

	@NotBlank(message = "证件过期时间不能为空")
	@ApiModelProperty("证件过期时间")
	private String overdueTime;
}
