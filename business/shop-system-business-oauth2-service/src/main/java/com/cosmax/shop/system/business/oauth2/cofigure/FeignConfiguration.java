package com.cosmax.shop.system.business.oauth2.cofigure;

import com.cosmax.shop.system.business.profile.fallback.ProfileFeignFallBack;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: shop-system
 * @description:
 * @author: Cosmax
 * @create: 2020/02/22 01:23
 */


@Configuration
public class FeignConfiguration {

    @Bean
    public ProfileFeignFallBack profileFeignFallBack(){
        return new ProfileFeignFallBack();
    }
}
