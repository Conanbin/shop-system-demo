package com.cosmax.shop.system.cofiguration.feign.configuration;

import com.cosmax.shop.system.cofiguration.feign.interceptor.FeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: shop-system
 * @description:
 * @author: Cosmax
 * @create: 2020/02/19 12:49
 */

@Configuration
public class FeignConfiguration {


    @Bean
    public RequestInterceptor requestInterceptor(){
        return new FeignRequestInterceptor();
    }
}
