package com.cosmax.shop.system.provider.api;

import com.cosmax.shop.system.commons.dto.BaseResult;
import com.cosmax.shop.system.provider.domain.User;

/**
 * @program: shop-system
 * @description: 用户服务层
 * @author: Cosmax
 * @create: 2020/02/18 17:22
 */
public interface UserService {

    /**
     * 通过用户名获取用户信息
     * @param username 用户名
     * @return {@link User}
     */
    User getUserByUserName(String username);

    /**
     * 修改用户信息
     * @param user 用户实体{@link User}
     * @return 修改结果 {@link BaseResult}
     */
    BaseResult updateInfo(User user);

    /**
     * 通过用户id获取用户信息
     * @param id 用户id
     * @return {@link User}
     */
    User getUserByById(Integer id);

    /**
     * 修改用户密码
     * @param id 用户id
     * @param oldPassword 用户旧密码（未加密）
     * @param newPassword 用户新密码（未加密）
     * @return 修改结果 {@link BaseResult}
     */
    BaseResult updatePasswordById(Integer id, String oldPassword, String newPassword);

    /**
     * 修改用户头像
     * @param id 用户id
     * @param path 用户头像路径
     * @return 修改结果 {@link BaseResult}
     */
    BaseResult updateIconById(Integer id, String path);
}
