package com.cosmax.shop.sytem.message.login.consumer;

import com.alibaba.fastjson.JSON;
import com.cosmax.shop.system.commons.dto.BaseResult;
import com.cosmax.shop.system.login.provider.api.LoginService;
import com.cosmax.shop.system.login.provider.domain.LoginLog;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.LongConsumer;

/**
 * @program: shop-system
 * @description:
 * @author: Cosmax
 * @create: 2020/02/24 15:22
 */

@Service
public class LoginLogConsumer {

    private static Logger logger = LoggerFactory.getLogger(LongConsumer.class);
    @Reference(version = "1.0.0")
    private LoginService loginService;


    @StreamListener("login-log-topic")
    public void insertLoginLog(String json){
        LoginLog loginLog = JSON.parseObject(json).toJavaObject(LoginLog.class);
        BaseResult baseResult = loginService.insertLoginLog(loginLog);
        if (baseResult.getCode() == BaseResult.STATECODE.OK){
            logger.info(baseResult.getMessage());
        }else {
            logger.error(baseResult.getMessage());
        }
    }
}
