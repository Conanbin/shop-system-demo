package com.cosmax.shop.system.business.oauth2.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: shop-system
 * @description:
 * @author: Cosmax
 * @create: 2020/02/17 19:23
 */

@Data
public class OAuth2Response implements Serializable {

    private String access_token;

    private String token_type;

    private String refresh_token;

    private Integer expires_in;

    private String scope;
}
