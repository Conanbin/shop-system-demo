package com.cosmax.shop.system.login.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: shop-system
 * @description: 登录启动类
 * @author: Cosmax
 * @create: 2020/02/23 12:30
 */

@SpringBootApplication
@MapperScan(basePackages = "com.cosmax.shop.system.login.provider.mapper")
public class LoginProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginProviderApplication.class, args);
    }
}

