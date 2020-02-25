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
public class UserIconParam implements Serializable {
    private static final long serialVersionUID = -5733161853438277225L;
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 头像路径
     */
    private String icon;
}
