package com.cosmax.shop.system.provider.fallback;

import com.cosmax.shop.system.provider.domain.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: shop-system
 * @description: 权限服务熔断
 * @author: Cosmax
 * @create: 2020/02/22 11:16
 */
public class PermissionServiceFallback {
    private static Logger logger = LoggerFactory.getLogger(UserServiceFallback.class);

    public List<Permission> selectPermissionByUserIdFallback(Integer id, Throwable ex){
        logger.warn("dubbo熔断：" + ex.getClass().getTypeName());
        ex.printStackTrace();
        return new ArrayList<>();
    }
}
