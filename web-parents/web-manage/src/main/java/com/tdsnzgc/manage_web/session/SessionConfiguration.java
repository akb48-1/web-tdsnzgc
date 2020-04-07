package com.tdsnzgc.manage_web.session;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class SessionConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry ){
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/");
        //网站配置生成器：添加一个拦截器，拦截路径为整个项目
    }
}
