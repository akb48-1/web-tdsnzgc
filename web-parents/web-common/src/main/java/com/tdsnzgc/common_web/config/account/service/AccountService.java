package com.tdsnzgc.common_web.config.account.service;

import com.tdsnzgc.common_web.config.account.pojo.Account;
import org.springframework.stereotype.Service;

public interface AccountService {
    public Account getUserInfo(String token);
    public Account selectAccount(String username);
    public String genToken(String username, String password);
}
