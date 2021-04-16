package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/16 16:37
 */
@Data
public class UpdateSocialInfoForm {
	@ApiModelProperty("社会信息id")
	@NotBlank(message = "社会信息id不能为空")
	private String socialInfoId;

	@ApiModelProperty("信息名称")
	@NotBlank(message = "信息名称不能为空")
	private String infoName;

	@ApiModelProperty("具体内容")
	@NotBlank(message = "具体内容不能为空")
	private String concreteContent;
}
