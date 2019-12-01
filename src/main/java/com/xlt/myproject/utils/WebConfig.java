package com.xlt.myproject.utils;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      //添加拦截器,拦截所有
        registry.addInterceptor(new JwtInterceptor()).addPathPatterns("/**");
    }
}
