package com.cosmax.shop.system.message.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @program: shop-system
 * @description: 登录mq启动类
 * @author: Cosmax
 * @create: 2020/02/23 22:48
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding({Source.class})
public class LoginMessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginMessageApplication.class, args);
    }
}
