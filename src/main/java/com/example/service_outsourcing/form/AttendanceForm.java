package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/14 17:15
 */
@Data
public class AttendanceForm {
	@ApiModelProperty("记录id")
	@NotBlank(message = "记录id不能为空")
	private String recordId;

	@ApiModelProperty("考勤次数")
	@NotNull(message = "考勤次数不能为空")
	private int attendanceNum;

	@ApiModelProperty("缺勤次数")
	@NotNull(message = "缺勤次数不能为空")
	private int absenceNum;

	@ApiModelProperty("迟到次数")
	@NotNull(message = "迟到次数不能为空")
	private int lateNum;

	@ApiModelProperty("请假次数")
	@NotNull(message = "请假次数不能为空")
	private int leaveNum;

	@ApiModelProperty("早退次数")
	@NotNull(message = "早退次数不能为空")
	private int leaveEarlyNum;

	@ApiModelProperty("综合评级")
	@NotNull(message = "综合评级不能为空")
	private String comprehensiveRating;
}
