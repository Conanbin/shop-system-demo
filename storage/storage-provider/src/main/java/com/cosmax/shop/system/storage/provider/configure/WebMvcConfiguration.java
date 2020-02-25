package com.cosmax.shop.system.storage.provider.configure;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

/**
 * @program: shop-system
 * @description:
 * @author: Cosmax
 * @create: 2020/02/20 21:55
 */

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize(DataSize.ofMegabytes(20));
        // 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.ofMegabytes(100));
        return factory.createMultipartConfig();

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
                String uploadPath = "file:" + new ApplicationHome(getClass()).getSource().getParentFile().getParent() + "/upload/";
        registry.addResourceHandler("/storage/**").addResourceLocations(uploadPath);
    }

}
