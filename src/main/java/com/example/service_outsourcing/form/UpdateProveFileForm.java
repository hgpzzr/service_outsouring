package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/17 12:53
 */
@Data
public class UpdateProveFileForm {
	@ApiModelProperty("证明材料id")
	@NotBlank(message = "证明材料id不能为空")
	private String proveId;

	@ApiModelProperty("项目id")
	@NotBlank(message = "项目id不能为空")
	private String projectId;
}
