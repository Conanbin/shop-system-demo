package com.cosmax.shop.system.message.login;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @program: shop-system
 * @description: 定义bindings
 * @author: Cosmax
 * @create: 2020/02/23 23:04
 */
public interface Source {

    @Output("login-log-topic")
    MessageChannel loginLog();
}
