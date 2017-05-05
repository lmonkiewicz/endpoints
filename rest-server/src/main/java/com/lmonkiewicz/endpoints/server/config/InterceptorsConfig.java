package com.lmonkiewicz.endpoints.server.config;

import com.lmonkiewicz.endpoints.server.config.interceptor.MonkeyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by lmonkiewicz on 05.05.2017.
 */
@Configuration
class InterceptorsConfig implements WebMvcConfigurer {




    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MonkeyInterceptor());
    }
}
