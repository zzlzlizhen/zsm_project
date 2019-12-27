package com.zsm.personplay.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 解决前端调用接口跨域问题
 * created by zsm on 2019/12/27
 */
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:8080");//允许域名访问，如果*，代表所有域名
                registry.addMapping("/**")
                        .allowedOrigins("*");//允许域名访问，如果*，代表所有域名
            }
        };
    }
}
