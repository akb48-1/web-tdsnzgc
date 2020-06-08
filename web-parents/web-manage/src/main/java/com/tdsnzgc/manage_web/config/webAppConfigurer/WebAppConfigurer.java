package com.tdsnzgc.manage_web.config.webAppConfigurer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 资源映射路径
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    @Value("${fileUploadRootPath}")
    String fileUploadRootPath;

    @Value("${drainy}")
    String drainy;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(fileUploadRootPath + "/**").addResourceLocations("file:" + drainy + fileUploadRootPath + "/");
    }
}
