package com.cosmax.shop.system.message.login.controller;

import com.cosmax.shop.system.commons.dto.BaseResult;
import com.cosmax.shop.system.message.login.dto.LoginLogDto;
import com.cosmax.shop.system.message.login.message.MessageProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: shop-system
 * @description: 登录日志mq控制器
 * @author: Cosmax
 * @create: 2020/02/23 23:20
 */

@RestController
@RequestMapping("message/login/log")
public class LoginLogController {

    @Resource
    private MessageProducer messageProducer;

    @PostMapping("/insert")
    public BaseResult sendLoginLog(@RequestBody LoginLogDto loginLogDto){
        if (loginLogDto == null){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "参数实体不能为空！", null);
        }
        boolean flag = messageProducer.sendLoginLog(loginLogDto);
        if (flag){
            return BaseResult.success(BaseResult.STATECODE.OK, "loginlog推送成功！", null);
        }
        return BaseResult.fail(BaseResult.STATECODE.ERROR, "loginlog推送失败！", null);
    }
}
