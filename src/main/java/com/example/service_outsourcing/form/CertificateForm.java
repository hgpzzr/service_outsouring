package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/4/2 13:55
 */
@Data
public class CertificateForm {
    @ApiModelProperty("简历id")
    @NotBlank(message = "简历id不能为空")
    private String resumeId;

    @ApiModelProperty("证书名称")
    @NotBlank(message = "证书名称不能为空")
    private String certificateName;

    @ApiModelProperty("证书描述")
    @NotBlank(message = "证书描述不能为空")
    private String certificateDescribe;

}
