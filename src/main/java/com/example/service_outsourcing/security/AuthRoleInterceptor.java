package com.example.service_outsourcing.security;

import com.alibaba.fastjson.JSON;
import com.example.service_outsourcing.accessctro.RoleControl;
import com.example.service_outsourcing.entity.User;
import com.example.service_outsourcing.enums.ResultEnum;
import com.example.service_outsourcing.service.UserService;
import com.example.service_outsourcing.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/29 19:47
 */
@Slf4j
@Service
public class AuthRoleInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(".....................");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String json = JSON.toJSONString(ResultVOUtil.error(ResultEnum.AUTHENTICATION_ERROR));
        User user = userService.getCurrentUser();
        if (user == null) {
            return true;
        }
        log.info("============执行权限验证============");
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RoleControl roleContro = handlerMethod.getMethodAnnotation(RoleControl.class);
            if (roleContro == null) {
                return true;
            }
            Integer roleValue = roleContro.role().getValue();
            Integer userValue = user.getRole();
            log.info("RoleValue:{},userRole:{}", roleValue, userValue);
            if (userValue >= roleValue) {
                return true;
            } else {
                json = JSON.toJSONString(ResultVOUtil.error(ResultEnum.PERMISSION_DENNY));
                log.info("============权限不足===============");
            }
        }
        response.getWriter().append(json);
        return false;
    }
}

