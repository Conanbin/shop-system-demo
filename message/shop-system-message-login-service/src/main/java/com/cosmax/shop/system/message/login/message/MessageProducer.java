package com.cosmax.shop.system.message.login.message;

import com.cosmax.shop.system.message.login.Source;
import com.cosmax.shop.system.message.login.dto.LoginLogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: shop-system
 * @description: message生产者
 * @author: Cosmax
 * @create: 2020/02/23 23:14
 */

@Service
public class MessageProducer {

    @Autowired
    private Source source;

    /**
     * 发送登录日志
     * @param logDto 登录日志 {@link LoginLogDto}
     * @return 成功或失败
     */
    public boolean sendLoginLog(LoginLogDto logDto){
        return source.loginLog().send(MessageBuilder.withPayload(logDto).build());
    }
}
