package com.example.service_outsourcing.controller;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.accessctro.RoleControl;
import com.example.service_outsourcing.enums.RoleEnum;
import com.example.service_outsourcing.form.EnterpriseCertificationForm;
import com.example.service_outsourcing.form.LoginForm;
import com.example.service_outsourcing.form.RegisterForm;
import com.example.service_outsourcing.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/30 10:16
 */
@RestController
@Slf4j
@RequestMapping("/user")
@CrossOrigin
@Api(tags = "用户接口")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public ResultVO login(@Valid LoginForm loginForm, HttpServletResponse response){
        return  userService.login(loginForm, response);
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public ResultVO register(@Valid RegisterForm registerForm){
        return userService.register(registerForm);
    }

    @RoleControl(role = RoleEnum.ADMIN)
    @ApiOperation("企业认证")
    @PostMapping("/enterpriseCertification")
    @ResponseBody
    public ResultVO enterpriseCertification(@Valid EnterpriseCertificationForm form,@RequestParam("file")MultipartFile file){
        return userService.enterpriseCertification(form,file);
    }

    @RoleControl(role = RoleEnum.ADMIN)
    @ApiOperation("添加hr账号")
    @PostMapping("/addHr")
    public ResultVO addHR(@Valid LoginForm form){
        return userService.addHR(form);
    }

    @ApiOperation("获得当前用户所有hr账号")
    @PostMapping("/allHR")
    @RoleControl(role = RoleEnum.ADMIN)
    public ResultVO getAllHRAccount(){
        return userService.getAllHRAccount();
    }
}
