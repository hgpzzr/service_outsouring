package com.example.service_outsourcing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/29 21:42
 */
@Data
public class LoginForm {
//    @ApiModelProperty("用户id")
//    @NotBlank(message = "用户id不能为空")
//    private String userId;

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String passwd;
}
