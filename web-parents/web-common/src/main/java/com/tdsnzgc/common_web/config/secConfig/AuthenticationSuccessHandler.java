package com.tdsnzgc.common_web.config.secConfig;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.tdsnzgc.common_web.config.account.pojo.Account;
import com.tdsnzgc.common_web.config.account.service.AccountServiceImpl;
import com.tdsnzgc.common_web.config.redisConfig.RedisUtil;
import com.tdsnzgc.common_web.config.responseUtil.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/*
* 登陆成功处理类
* */
@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    AccountServiceImpl acountServiceImpl;

    @Autowired
    RedisUtil redisUtil;

    @Value("${tokenExpires}") // token实效时间
    int tokenExpires;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String token = acountServiceImpl.genToken(username, password);

        Account account = acountServiceImpl.selectAccount(username);
        Map<String, Object> accountMap = BeanUtil.beanToMap(account);
        accountMap.remove("password");

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("username", username);
        userInfo.put("token", token);
        redisUtil.set(token, JSONUtil.toJsonStr(accountMap), tokenExpires);

        ResponseUtil.write(response, 200, true, "登陆成功", userInfo);
    }
}
