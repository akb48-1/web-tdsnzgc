package com.tdsnzgc.common_web.config.secConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity // 默认开启
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationSuccessHandler successHandler;

    @Autowired
    AuthenticationFailHandler failHandler;

    @Autowired
    private RestAccessDeniedHandler accessDeniedHandler;

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers("/swagger-ui.html")
//                .antMatchers("/v2/**")
//                .antMatchers("/swagger-resources/**");
//    }
//    @Override
    public void configure(WebSecurity web) throws Exception {
        //放行swagger
        web.ignoring().antMatchers(HttpMethod.GET,
                "/v2/api-docs",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui.html/**",
                "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers( "/toLogin", "/account/genToken", "/account/validateToken").permitAll()  // 无需验证的接口

            .anyRequest()
            .authenticated()
//            .and()
//            .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())

            .and()
            .formLogin()
            .successHandler(successHandler)
            .failureHandler(failHandler)
//            .loginPage("/needLogin")
            .loginProcessingUrl("/toLogin") // 登录请求路径
//            .and()
//            .cors()
            .and()
            .csrf().disable()
//            .addFilterBefore(new ContextFilter(), UnameFilter.class) // 清除Token 二选一
//            .addFilter(new UnameFilter())
//
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 清除Token 二选一
                //自定义权限拒绝处理类
            .and()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
            .and()
            .addFilter(new UnameFilter());
//
//        http.exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
//            @Override
//            public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//                httpServletRequest.getRequestDispatcher("/tokenError").forward(httpServletRequest, httpServletResponse);
//            }
//        });
    }

    // 数据库读取账户
//    @Autowired
//    DBProvider dbProvider;
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(dbProvider);
//    }
}

class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}