package com.yangningBPVlog.boot.configuration;

import com.yangningBPVlog.boot.interceptor.loginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: 阳寜
 * @Date: 2022-03-28
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    //注册拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new loginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login");
    }
}
