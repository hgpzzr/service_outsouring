package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/14 16:53
 */
@Data
public class EvaluateForm {
	@ApiModelProperty("记录id")
	@NotBlank(message = "记录id不能为空")
	private String recordId;

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
