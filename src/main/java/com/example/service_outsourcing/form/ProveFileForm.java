package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/12 21:26
 */
@Data
public class ProveFileForm {
	@ApiModelProperty("材料id")
	@NotBlank(message = "材料id不能为空")
	private String materialId;

	@ApiModelProperty("项目id")
	@NotBlank(message = "项目id不能为空")
	private String projectId;
}
