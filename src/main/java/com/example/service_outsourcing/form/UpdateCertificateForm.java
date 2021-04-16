package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/15 19:21
 */
@Data
public class UpdateCertificateForm {
    @ApiModelProperty("证书id")
    @NotBlank(message = "证书id不能为空")
    private String certificateId;

    @ApiModelProperty("证书名称")
    @NotBlank(message = "证书名称不能为空")
    private String certificateName;

    @ApiModelProperty("证书描述")
    @NotBlank(message = "证书描述不能为空")
    private String certificateDescribe;
}
