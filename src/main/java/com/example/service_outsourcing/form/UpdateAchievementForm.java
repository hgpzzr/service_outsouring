package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/17 13:52
 */
@Data
public class UpdateAchievementForm {
	@ApiModelProperty("绩效id")
	@NotBlank(message = "绩效id不能为空")
	private String achievementId;

	@ApiModelProperty("绩效等级（A、B、C、D等）")
	@NotBlank(message = "绩效等级不能为空")
	private String achievementGrade;

	@ApiModelProperty("绩效评价")
	@NotBlank(message = "绩效评价不能为空")
	private String achievementEvaluate;
}
