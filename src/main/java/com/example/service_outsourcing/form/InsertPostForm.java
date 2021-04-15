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
public class InsertPostForm {

	@ApiModelProperty("部门id")
	@NotBlank(message = "部门id不能为空")
	private String departmentId;

	@ApiModelProperty("岗位名称")
	@NotBlank(message = "岗位名称不能为空")
	private String psotName;

	@ApiModelProperty("岗位类别")
	@NotBlank(message = "岗位类别不能为空")
	private String postCategoryId;

	@ApiModelProperty("编制")
	@NotNull(message = "编制不能为空")
	private Integer postMaxNum;

	@ApiModelProperty("现有人数")
	@NotNull(message = "现有人数不能为空")
	private Integer postNowNum;

	@ApiModelProperty("职务说明")
	@NotBlank(message = "职务说明不能为空")
	private String postDescribe;

}
