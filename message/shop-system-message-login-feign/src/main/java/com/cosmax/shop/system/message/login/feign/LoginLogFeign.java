package com.cosmax.shop.system.message.login.feign;

import com.cosmax.shop.system.cofiguration.feign.configuration.FeignConfiguration;
import com.cosmax.shop.system.message.login.fallback.LoginLogFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @program: shop-system
 * @description: 登录日志feign
 * @author: Cosmax
 * @create: 2020/02/23 22:46
 */

@FeignClient(name = "message-login-service",path = "", configuration = FeignConfiguration.class, fallback = LoginLogFeignFallback.class)
public interface LoginLogFeign {
}
