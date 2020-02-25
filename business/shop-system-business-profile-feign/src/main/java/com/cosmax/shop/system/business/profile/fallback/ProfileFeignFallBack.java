package com.cosmax.shop.system.business.profile.fallback;

import com.alibaba.fastjson.JSON;
import com.cosmax.shop.system.business.profile.feign.ProfileFeign;
import com.cosmax.shop.system.commons.dto.BaseResult;
import org.springframework.stereotype.Component;

/**
 * @program: shop-system
 * @description: profile服务熔断
 * @author: Cosmax
 * @create: 2020/02/21 22:20
 */

@Component
public class ProfileFeignFallBack implements ProfileFeign {
    private static final String BREAKING_MESSAGE = "请求失败了，请检查您的网络";
    @Override
    public String info(String username) {
        return JSON.toJSONString(BaseResult
                .builder()
                .code(BaseResult.STATECODE.BREAKTIME)
                .message(BREAKING_MESSAGE)
                .data(null)
                .build());
    }
}
