package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/30 15:20
 */
@Data
public class BasicInformationForm {
    @ApiModelProperty("简历id")
    @NotBlank(message = "简历id不能为空")
    private String resumeId;

    @ApiModelProperty("姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    @ApiModelProperty("出生日期")
    @NotBlank(message = "出生日期不能为空")
    @Past
    private String birth;

    @ApiModelProperty("性别（0为女，1为男）")
    @NotNull(message = "性别不能为空")
    private Integer gender;

    @ApiModelProperty("联系电话")
    @NotBlank(message = "联系电话不能为空")
    private String phone;

    @ApiModelProperty("联系邮箱")
    @NotBlank(message = "联系邮箱不能为空")
    @Email
    private String email;

    @ApiModelProperty("工作年龄")
    @NotNull(message = "工作年龄不能为空")
    @Min(0)
    private Integer workYear;

    @ApiModelProperty("婚姻状况（0为未婚，1为已婚，2为离异）")
    @NotNull(message = "婚姻状况不能为空")
    private Integer marryStatus;

    @ApiModelProperty("政治面貌")
    @NotBlank(message = "政治面貌不能为空")
    private String politicalOutlook;

    @ApiModelProperty("籍贯")
    @NotBlank(message = "籍贯不能为空")
    private String nativePlace;

    @ApiModelProperty("民族")
    @NotBlank(message = "民族不能为空")
    private String nation;

    @ApiModelProperty("身高，单位为m，两位小数")
    @NotNull(message = "身高不能为空")
    private double height;

    @ApiModelProperty("体重，单位为kg，两位小数")
    @NotNull(message = "体重不能为空")
    private double weight;

    @ApiModelProperty("学历")
    @NotBlank(message = "学历不能为空")
    private String educationLevel;
}
