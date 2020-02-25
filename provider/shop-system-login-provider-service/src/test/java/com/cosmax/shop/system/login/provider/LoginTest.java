package com.cosmax.shop.system.login.provider;

import com.alibaba.fastjson.JSON;
import com.cosmax.shop.system.login.provider.api.LoginService;
import com.cosmax.shop.system.login.provider.domain.LoginLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: shop-system
 * @description: 登录相关测试
 * @author: Cosmax
 * @create: 2020/02/23 13:32
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {

    @Resource
    private LoginService loginService;

    @Test
    public void testInsert(){
//        LoginLog build = LoginLog.builder().userId(1007).loginIp("192.168.123.111").build();
//        System.out.println(JSON.toJSONString?(loginService.insertLoginLog(build)));
    }
}
