package com.tdsnzgc.common_web.config.account.service.impl;

import cn.hutool.json.JSONUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tdsnzgc.common_web.config.account.pojo.mapper.AccountMapper;
import com.tdsnzgc.common_web.config.account.pojo.Account;
import com.tdsnzgc.common_web.config.account.service.AccountService;
import com.tdsnzgc.common_web.config.redisConfig.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Service
public class AccountServiceImpl implements AccountService {
    final String _token = "_token";

    @Value("${tokenExpires}") // token实效时间
    int tokenExpires;

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public Account selectAccount(String username) {
        Account account = accountMapper.selectAccount(username);
        return account;
    }

    @Autowired
    Algorithm algorithm;
    public String genToken(String username, String password) {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, tokenExpires); // 生效一天
        return JWT.create()
                .withClaim("username", username)
                .withClaim("password", password)
//                .withClaim("isAdmin", true)
                .withExpiresAt(calendar.getTime())
                .sign(algorithm);
    }

    @Override
    public String getToken(String username) {
        return (String) redisUtil.get(username + this._token);
    }

    public String validateToken(HttpServletRequest req) {
        String token = req.getParameter("token");
        if(token == null) {
            return "no token";
        } else {
            DecodedJWT decodedJWT = JWT.require(algorithm).build().verify(token);
            return decodedJWT.getClaims().get("username").asString();
        }
    }

    /*
    * 通过token 在 redis查用户信息
    * */
    @Override
    public Account getUserInfo(String token) {
        String accountStr = (String) redisUtil.get(token);
        return JSONUtil.toBean(accountStr, Account.class);
    }

    public String getOrgan_ids() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String token = getToken(username);

        Account account = getUserInfo(token);

        String organ_ids = account.getOrgan_ids();

        return organ_ids;
    }

    public String getPrincipal() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


}
