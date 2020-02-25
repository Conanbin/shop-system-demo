package com.cosmax.shop.system.business.profile.controller;

import com.cosmax.shop.system.business.profile.dto.InfoDto;
import com.cosmax.shop.system.business.profile.dto.UserIconParam;
import com.cosmax.shop.system.business.profile.dto.UserPasswordParam;
import com.cosmax.shop.system.commons.dto.BaseResult;
import com.cosmax.shop.system.provider.api.UserService;
import com.cosmax.shop.system.provider.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @program: shop-system
 * @description: 个人信息控制层
 * @author: Cosmax
 * @create: 2020/02/18 19:27
 */

@RestController
@RequestMapping("profile")
public class ProfileController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @GetMapping("/info/{username}")
    public BaseResult getUserInfo(@PathVariable String username){
        if (StringUtils.isBlank(username)){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "用户名不能为空！", null);
        }
        User userByUserName = userService.getUserByUserName(username);
        if (userByUserName == null){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "用户 [ "+ username +" ] 信息不存在！", null);
        }
        return BaseResult.success(BaseResult.STATECODE.OK, "查询成功！", userByUserName);
    }
    @GetMapping("/info/id/{id}")
    public BaseResult getUserInfoById(@PathVariable Integer id){
        if (id == null || id <= 0){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "用户id不能为空！", null);
        }
        User userByById = userService.getUserByById(id);
        if (userByById == null){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "用户 [ "+ id +" ] 信息不存在！", null);
        }
        return BaseResult.success(BaseResult.STATECODE.OK, "查询成功！", userByById);
    }

    @PostMapping("/info")
    public BaseResult updateInfo(@RequestBody InfoDto infoDto){

        User user = new User();
        BeanUtils.copyProperties(infoDto, user);
        return userService.updateInfo(user);
    }

    @PostMapping("/info/password")
    public BaseResult updatePassword(@RequestBody UserPasswordParam passwordParam){

        if (passwordParam == null){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "参数实体为空！", null);
        }
        return userService.updatePasswordById(passwordParam.getId(), passwordParam.getOldPassword(), passwordParam.getNewPassword());
    }

    @PostMapping("/info/icon")
    public BaseResult updateIcon(@RequestBody UserIconParam userIconParam){
        if (userIconParam == null){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "参数实体为空！", null);
        }

        return userService.updateIconById(userIconParam.getId(), userIconParam.getIcon());
    }
}
