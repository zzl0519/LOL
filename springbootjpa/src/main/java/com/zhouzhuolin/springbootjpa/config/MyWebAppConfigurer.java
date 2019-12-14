package com.zhouzhuolin.springbootjpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 资源映射路径
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/uploadImages/**").addResourceLocations("file:D:/temp/");
        super.addResourceHandlers(registry);
    }
}