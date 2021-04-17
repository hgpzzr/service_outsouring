package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/17 13:57
 */
@Data
public class UpdateEvaluateForm {
	@ApiModelProperty("评价id")
	@NotBlank(message = "评价id不能为空")
	private String evaluateId;

	@ApiModelProperty("评价时间")
	@NotBlank(message = "评价时间不能为空")
	private String evaluateTime;

	@ApiModelProperty("评价类型")
	@NotBlank(message = "评价类型不能为空")
	private String evaluateType;

	@ApiModelProperty("评价内容")
	@NotBlank(message = "评价内容不能为空")
	private String evaluateContent;

	@ApiModelProperty("评价人")
	@NotBlank(message = "评价人不能为空")
	private String evaluatePerson;

	@ApiModelProperty("评价人关系")
	@NotBlank(message = "评价人关系不能为空")
	private String evaluatePersonRelationship;

	@ApiModelProperty("评价名称")
	@NotBlank(message = "评价名称不能为空")
	private String evaluateName;
}
