package com.cosmax.shop.system.provider.fallback;

import com.cosmax.shop.system.commons.dto.BaseResult;
import com.cosmax.shop.system.provider.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @program: shop-system
 * @description: user相关熔断
 * @author: Cosmax
 * @create: 2020/02/22 10:56
 */

public class UserServiceFallback {

    private static Logger logger = LoggerFactory.getLogger(UserServiceFallback.class);
    private static final String BREAKING_MESSAGE = "请求失败了，请检查您的网络";


    public static User getUserByUserNameFallback(String username, Throwable ex){
        logger.warn("dubbo熔断：" + ex.getClass().getTypeName());
        ex.printStackTrace();
        return null;
    }


    public static BaseResult updateInfoFallback(User user, Throwable ex) {
        logger.warn("dubbo熔断：" + ex.getClass().getTypeName());
        ex.printStackTrace();
        return BaseResult.builder().code(BaseResult.STATECODE.BREAKTIME).message(BREAKING_MESSAGE).build();
    }

    public static User getUserByByIdFallback(Integer id, Throwable ex) {
        logger.warn("dubbo熔断：" + ex.getClass().getTypeName());
        ex.printStackTrace();
        return null;
    }

    public static BaseResult updatePasswordByIdFallback(Integer id, String oldPassword, String newPassword, Throwable ex) {
        logger.warn("dubbo熔断：" + ex.getClass().getTypeName());
        ex.printStackTrace();
        return BaseResult.builder().code(BaseResult.STATECODE.BREAKTIME).message(BREAKING_MESSAGE).build();
    }

    public static BaseResult updateIconByIdFallback(Integer id, String path, Throwable ex) {
        logger.warn("dubbo熔断：" + ex.getClass().getTypeName());
        ex.printStackTrace();
        return BaseResult.builder().code(BaseResult.STATECODE.BREAKTIME).message(BREAKING_MESSAGE).build();
    }
}
