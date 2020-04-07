package com.tdsnzgc.common_web.config.secConfig;

import com.tdsnzgc.common_web.config.responseUtil.ResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * 登陆失败处理类
 * */
@Component
public class AuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        ResponseUtil.write(response, 200, false, "用户名或密码错误", "");
    }
}
