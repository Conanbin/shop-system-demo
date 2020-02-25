package com.cosmax.shop.sytem.message.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @program: shop-system
 * @description: 登录日志消费者启动类
 * @author: Cosmax
 * @create: 2020/02/24 15:18
 */

@SpringBootApplication
@EnableBinding({LoginMessageSink.class})
public class LoginMessageConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginMessageConsumerApplication.class, args);
    }
}
