package com.cosmax.shop.system.business.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: shop-system
 * @description:
 * @author: Cosmax
 * @create: 2020/02/18 18:19
 */

@SpringBootApplication
@EnableDiscoveryClient
public class BusinessProfileServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessProfileServiceApplication.class, args);
    }
}
