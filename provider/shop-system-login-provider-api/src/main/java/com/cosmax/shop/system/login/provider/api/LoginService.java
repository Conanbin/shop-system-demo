package com.cosmax.shop.system.login.provider.api;

import com.cosmax.shop.system.commons.dto.BaseResult;
import com.cosmax.shop.system.login.provider.domain.LoginLog;

/**
 * @program: shop-system
 * @description: 登录相关api
 * @author: Cosmax
 * @create: 2020/02/23 12:29
 */
public interface LoginService {

    /**
     * 登录记录日志
     * @param loginLog 日志实体
     * @return 响应实体 {@link BaseResult}
     */
    BaseResult insertLoginLog(LoginLog loginLog);

    /**
     * 根据id查询用户登录查询日志
     * @param userId 用户id
     * @return 响应实体 {@link BaseResult}
     */
    BaseResult getLoginLogsByUserId(Integer userId);

}
