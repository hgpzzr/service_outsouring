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
public class EmployeeForm {

	@NotBlank(message = "岗位id不能为空")
	@ApiModelProperty("岗位id")
	private String postId;

}
