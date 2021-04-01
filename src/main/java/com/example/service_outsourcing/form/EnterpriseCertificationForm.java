package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/30 10:50
 */
@Data
public class EnterpriseCertificationForm {
    @ApiModelProperty("企业名称")
    @NotBlank(message = "企业名称不能为空")
    private String organizationName;

}
