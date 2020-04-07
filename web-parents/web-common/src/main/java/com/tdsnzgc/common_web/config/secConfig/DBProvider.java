package com.tdsnzgc.common_web.config.secConfig;

import com.tdsnzgc.common_web.config.account.pojo.Account;
import com.tdsnzgc.common_web.config.account.pojo.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DBProvider implements AuthenticationProvider {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String accountName = authentication.getName();
        String accountPass = (String) authentication.getCredentials(); // 凭证

        System.out.println("accountName:" + accountName + "; accountPass:" + accountPass);
        Account account = accountMapper.selectAccount(accountName);

        if(account != null) {
            if(account.getPassword().equals(accountPass)) {
                return new UsernamePasswordAuthenticationToken(accountName, accountPass, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            } else {
                throw new  BadCredentialsException("用户密码错误");
            }
        } else {
            throw new UsernameNotFoundException("用户不存在");
        }

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
