package com.cosmax.shop.system.provider.api;

import com.cosmax.shop.system.provider.domain.Permission;

import java.util.List;

/**
 * @program: shop-system
 * @description: 权限服务
 * @author: Cosmax
 * @create: 2020/02/18 17:36
 */
public interface PermissionService {

    /**
     * 通过用户id获取权限
     * @param id 用户id
     * @return {@link List<Permission>}
     */
    List<Permission> selectPermissionByUserId(Integer id);
}
