package com.zap.office.config;

import com.zap.office.interceptor.ViewInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: ZhuApeng
 * @Title: MyWebMvcConfiguration
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/11/1 12:17
 */
@Configuration
public class MyWebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    ViewInterceptor viewInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(viewInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/static/**");
    }
}
