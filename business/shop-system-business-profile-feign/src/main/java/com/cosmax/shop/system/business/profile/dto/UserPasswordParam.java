package com.cosmax.shop.system.business.profile.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: shop-system
 * @description: 用户修改头像传参
 * @author: Cosmax
 * @create: 2020/02/21 13:14
 */

@Data
public class UserPasswordParam implements Serializable {
    private static final long serialVersionUID = -10582716547893619L;
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户原密码
     */
    private String oldPassword;

    /**
     * 用户新密码
     */
    private String newPassword;
}
