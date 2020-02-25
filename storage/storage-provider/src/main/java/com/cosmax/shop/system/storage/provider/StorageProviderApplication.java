package com.cosmax.shop.system.storage.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: shop-system
 * @description: 文件服务器启动类
 * @author: Cosmax
 * @create: 2020/02/20 23:11
 */

@SpringBootApplication
@EnableDiscoveryClient
public class StorageProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageProviderApplication.class, args);
    }
}
