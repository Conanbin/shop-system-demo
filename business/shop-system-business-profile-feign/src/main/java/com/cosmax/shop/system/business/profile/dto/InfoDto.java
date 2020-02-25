package com.cosmax.shop.system.business.profile.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: shop-system
 * @description: 用户修改参数传递
 * @author: Cosmax
 * @create: 2020/02/21 09:38
 */

@Data
public class InfoDto implements Serializable {

    private static final long serialVersionUID = -4211421018521825418L;

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

}
