package com.cosmax.shop.system.business.oauth2.service.impl;

import com.cosmax.shop.system.provider.domain.Permission;
import com.cosmax.shop.system.provider.api.PermissionService;
import com.cosmax.shop.system.provider.api.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: shop-system
 * @description: 用户信息服务实现
 * @author: Cosmax
 * @create: 2020/02/14 13:57
 */

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Reference(version = "1.0.0")
    private UserService userService;

    @Reference(version = "1.0.0")
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.cosmax.shop.system.provider.domain.User userByUserName = userService.getUserByUserName(username);
        if (userByUserName == null){
            return null;
        }

        List<Permission> permissions = permissionService.selectPermissionByUserId(userByUserName.getId());

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        permissions.forEach(permission -> grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName())));

        return new User(userByUserName.getUsername(), userByUserName.getPassword(), grantedAuthorities);
    }
}
