package com.example.service_outsourcing.service;

import com.example.service_outsourcing.VO.ResultVO;
import com.example.service_outsourcing.entity.User;
import com.example.service_outsourcing.form.EnterpriseCertificationForm;
import com.example.service_outsourcing.form.LoginForm;
import com.example.service_outsourcing.form.RegisterForm;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/29 20:00
 */
@Service
public interface UserService {

    /**
     * 根据用户名获得用户
     *
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 获取当前用用户
     *
     * @return
     */
    User getCurrentUser();

    /**
     * 注册
     *
     * @param registerForm
     * @return
     */
    ResultVO register(RegisterForm registerForm);

    /**
     * 用户登录
     * @param loginForm
     * @return
     */
    ResultVO login(LoginForm loginForm, HttpServletResponse response);

    /**
     * 用户添加hr账号
     * @param form
     * @return
     */
    ResultVO addHR(LoginForm form);

    /**
     * 用户进行企业认证
     * @param form
     * @param file
     * @return
     */
    ResultVO enterpriseCertification(EnterpriseCertificationForm form,MultipartFile file);

    /**
     * 获取当前用户所有用的所有hr账号
     * @return
     */
    ResultVO getAllHRAccount();

}
