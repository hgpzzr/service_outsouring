package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/15 16:07
 */
@Data
public class UpdateWorkExperienceForm {
    @ApiModelProperty("工作编号")
    @NotBlank(message = "工作id不能为空")
    private String workId;

    @ApiModelProperty("公司名称")
    @NotBlank(message = "公司名称不能为空")
    private String companyName;

    @ApiModelProperty("开始时间")
    @NotBlank(message = "开始时间不能为空")
    private String beginTime;

    @ApiModelProperty("结束时间")
    @NotBlank(message = "结束时间不能为空")
    private String endTime;

    @ApiModelProperty("简要描述")
    @NotBlank(message = "简要描述不能为空")
    private String workDescribe;

}
