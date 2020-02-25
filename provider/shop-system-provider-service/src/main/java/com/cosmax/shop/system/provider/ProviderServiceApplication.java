package com.cosmax.shop.system.provider;

import com.cosmax.shop.system.configuration.sentinel.configure.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

import javax.swing.*;

/**
 * @program: shop-system
 * @description: service启动类
 * @author: Cosmo
 * @create: 2020/01/29 17:10
 */

@SpringBootApplication(scanBasePackageClasses = {ProviderServiceApplication.class, DubboSentinelConfiguration.class})
@MapperScan(basePackages = "com.cosmax.shop.system.provider.mapper")
public class ProviderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderServiceApplication.class, args);
    }
}
