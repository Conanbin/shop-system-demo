package com.cosmax.shop.system.message.login.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: shop-system
 * @description: 登录日志dto
 * @author: Cosmax
 * @create: 2020/02/23 22:44
 */

@Data
@Builder
public class LoginLogDto implements Serializable {
    private static final long serialVersionUID = 1395207844937195890L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 登录地点
     */
    private String loginIp;
}
