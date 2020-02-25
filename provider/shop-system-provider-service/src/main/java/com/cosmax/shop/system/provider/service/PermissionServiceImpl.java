package com.cosmax.shop.system.provider.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cosmax.shop.system.provider.domain.Permission;
import com.cosmax.shop.system.provider.api.PermissionService;
import com.cosmax.shop.system.provider.fallback.PermissionServiceFallback;
import com.cosmax.shop.system.provider.mapper.PermissionMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shop-system
 * @description: 用户权限服务层实现
 * @author: Cosmax
 * @create: 2020/02/18 17:37
 */

@Service(version = "1.0.0")
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @SentinelResource(value = "selectPermissionByUserId", fallback = "selectPermissionByUserIdFallback", fallbackClass = PermissionServiceFallback.class)
    @Override
    public List<Permission> selectPermissionByUserId(Integer id) {
        if (id == null || id <= 0){
            return new ArrayList<>();
        }
        return permissionMapper.selectPermissionByUserId(id);
    }
}
