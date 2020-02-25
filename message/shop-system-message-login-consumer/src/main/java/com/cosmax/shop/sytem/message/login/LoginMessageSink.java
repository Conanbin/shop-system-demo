package com.cosmax.shop.sytem.message.login;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @program: shop-system
 * @description: 登录日志sink
 * @author: Cosmax
 * @create: 2020/02/24 15:19
 */
public interface LoginMessageSink {

    @Input("login-log-topic")
    SubscribableChannel loginLog();
}
