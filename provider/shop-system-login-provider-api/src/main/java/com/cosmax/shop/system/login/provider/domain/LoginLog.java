package com.cosmax.shop.system.login.provider.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * login_log
 * @author
 */

@Data
public class LoginLog implements Serializable {
    private static final long serialVersionUID = 6780293058396058735L;
    /**
     * 日志id
     */
    private Long id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 登录时间
     */

    private Date loginTime;

    /**
     * 登录地点
     */
    private String loginIp;

}
