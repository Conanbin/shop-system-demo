package com.cosmax.shop.system.business.profile.feign;

import com.cosmax.shop.system.business.profile.fallback.ProfileFeignFallBack;
import com.cosmax.shop.system.cofiguration.feign.configuration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: shop-system
 * @description: 请求个人信息接口
 * @author: Cosmax
 * @create: 2020/02/18 19:41
 */

@FeignClient(value = "business-profile", path = "profile", configuration = FeignConfiguration.class, fallback = ProfileFeignFallBack.class)
public interface ProfileFeign {

    @GetMapping("info/{username}")
    String info(@PathVariable String username);
}
