package com.example.config;
import com.example.common.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author: xiuchong
 * @Date: 2020/8/13 14:35
 * @Description: 将拦截器配置到项目中
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Resource
    TokenInterceptor tokenInterceptor;
    @Bean
    public JwtUtils jwtUtils(){
        return new JwtUtils();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置所有的路径都要进行拦截，除了/test/login
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**");
    }
}

