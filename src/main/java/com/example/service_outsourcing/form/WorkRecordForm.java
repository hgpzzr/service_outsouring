package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/13 10:40
 */
@Data
public class WorkRecordForm {
	@ApiModelProperty("员工id")
	@NotBlank(message = "员工id不能为空")
	private String employeeId;

	@ApiModelProperty("企业id")
	@NotBlank(message = "企业id不能为空")
	private String organizationId;

	@ApiModelProperty("岗位id")
	@NotBlank(message = "岗位id不能为空")
	private String postId;

	@ApiModelProperty("开始时间")
	@NotBlank(message = "开始时间不能为空")
	private String beginTime;

	@ApiModelProperty("结束时间")
	@NotBlank(message = "结束时间不能为空")
	private String endTime;

	@ApiModelProperty("工作状态，0为离职，1为在职")
	@NotBlank(message = "工作状态不能为空")
	private Integer workStatus;
}
