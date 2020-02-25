package com.cosmax.shop.system.message.login.fallback;

import com.cosmax.shop.system.message.login.feign.LoginLogFeign;
import org.springframework.stereotype.Component;

/**
 * @program: shop-system
 * @description: 登录日志熔断
 * @author: Cosmax
 * @create: 2020/02/23 23:00
 */

@Component
public class LoginLogFeignFallback implements LoginLogFeign {
}
