package com.cosmax.shop.system.configuration.sentinel.configure;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: shop-system
 * @description: dubbo sentinel熔断配置
 * @author: Cosmax
 * @create: 2020/02/22 10:17
 */

@Configuration
public class DubboSentinelConfiguration {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect(){
        return new SentinelResourceAspect();
    }
}
