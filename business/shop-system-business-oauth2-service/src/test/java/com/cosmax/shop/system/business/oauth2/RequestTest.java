package com.cosmax.shop.system.business.oauth2;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: shop-system
 * @description:
 * @author: Cosmax
 * @create: 2020/02/17 22:59
 */

@SpringBootTest
public class RequestTest {

    @Test
    public void test(){
        System.out.println(new BCryptPasswordEncoder().encode("shop_secret"));
    }

}
