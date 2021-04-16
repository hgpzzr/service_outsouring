package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/14 16:36
 */
@Data
public class AchievementForm {
	@ApiModelProperty("记录id")
	@NotBlank(message = "记录id不能为空")
	private String recordId;

	@ApiModelProperty("绩效等级（A、B、C、D等）")
	@NotBlank(message = "绩效等级不能为空")
	private String achievementGrade;

	@ApiModelProperty("绩效评价")
	@NotBlank(message = "绩效评价不能为空")
	private String achievementEvaluate;
}
