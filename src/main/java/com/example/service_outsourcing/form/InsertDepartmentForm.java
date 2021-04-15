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
public class InsertDepartmentForm {

	@ApiModelProperty("部门名称")
	@NotBlank(message = "部门id不能为空")
	private String departmentName;

	@ApiModelProperty("成立时间")
	@NotBlank(message = "成立时间不能为空")
	private String establishTime;

	@ApiModelProperty("部门最大人数")
	@NotNull(message = "部门最大人数不能为空")
	private Integer maxNum;

	@ApiModelProperty("部门现人数")
	@NotNull(message = "部门现人数不能为空")
	private Integer nowNum;

	@ApiModelProperty("部门领导")
	@NotBlank(message = "部门领导不能为空")
	private String leader;

	@ApiModelProperty("部门负责人")
	@NotBlank(message = "部门负责人不能为空")
	private String peopleInCharge;

	@ApiModelProperty("组织")
	@NotBlank(message = "组织不能为空")
	private String organizationId;
}
