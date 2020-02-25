package com.cosmax.shop.system.business.oauth2.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: shop-system
 * @description: 用户dto
 * @author: Cosmax
 * @create: 2020/02/17 11:44
 */

@Data
public class UserDto implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
