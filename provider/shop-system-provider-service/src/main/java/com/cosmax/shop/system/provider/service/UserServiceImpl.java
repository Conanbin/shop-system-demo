package com.cosmax.shop.system.provider.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cosmax.shop.system.commons.dto.BaseResult;
import com.cosmax.shop.system.provider.api.UserService;
import com.cosmax.shop.system.provider.domain.User;
import com.cosmax.shop.system.provider.fallback.UserServiceFallback;
import com.cosmax.shop.system.provider.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @program: shop-system
 * @description: 用户服务实现
 * @author: Cosmax
 * @create: 2020/02/18 17:23
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @SentinelResource(value = "getUserByUserName", fallback = "getUserByUserNameFallback", fallbackClass = UserServiceFallback.class)
    @Override
    public User getUserByUserName(String username) {

        if (StringUtils.isBlank(username)){
            return null;
        }
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username", username);
        return userMapper.selectOneByExample(example);
    }

    @SentinelResource(value = "updateInfo", fallback = "updateInfoFallback", fallbackClass = UserServiceFallback.class)
    @Override
    public BaseResult updateInfo(User user) {
        if(user == null){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "user实体为空！", null);
        }
        if (user.getId() == null || user.getId() <= 0){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "用户id有误！", null);
        }


        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id", user.getId());
        User checkUser = userMapper.selectOneByExample(example);
        if (checkUser == null){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "用户 [ "+ user.getId() +" ] 不存在！", null);
        }
        checkUser.setEmail(user.getEmail());
        int update = userMapper.updateByExample(checkUser, example);
        if (update <= 0){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "修改信息失败！", null);
        }
        return BaseResult.success(BaseResult.STATECODE.OK, "修改信息成功！", checkUser.getId());
    }
    @SentinelResource(value = "getUserByById", fallback = "getUserByByIdFallback", fallbackClass = UserServiceFallback.class)
    @Override
    public User getUserByById(Integer id) {
        if (id == null || id <= 0){
            return null;
        }
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id", id);
        return userMapper.selectOneByExample(example);
    }

    @SentinelResource(value = "updatePasswordById", fallback = "updatePasswordByIdFallback", fallbackClass = UserServiceFallback.class)
    @Override
    public BaseResult updatePasswordById(Integer id, String oldPassword, String newPassword) {
        if (id == null || id <= 0){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "用户id有误！", null);
        }

        if (StringUtils.isBlank(oldPassword)){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "原密码字段不能为空！", null);
        }

        if (StringUtils.isBlank(newPassword)){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "原密码字段不能为空！", null);
        }

        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id", id);
        User checkUser = userMapper.selectOneByExample(example);
        if (checkUser == null){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "用户 [ "+ id +" ] 不存在！", null);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(oldPassword, checkUser.getPassword())){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "用户 [ "+ id +" ] 原密码错误！", null);

        }
        checkUser.setPassword(encoder.encode(newPassword));
        int update = userMapper.updateByExample(checkUser, example);
        if (update <= 0){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "修改密码失败！", null);
        }
        return BaseResult.success(BaseResult.STATECODE.OK, "修改密码成功！", id);
    }

    @SentinelResource(value = "updateIconById", fallback = "updateIconByIdFallback", fallbackClass = UserServiceFallback.class)
    @Override
    public BaseResult updateIconById(Integer id, String path) {
        if (id == null || id <= 0){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "用户id有误！", null);
        }

        if (StringUtils.isBlank(path)){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "头像路径字段不能为空！", null);
        }

        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id", id);
        User checkUser = userMapper.selectOneByExample(example);
        if (checkUser == null){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "用户 [ "+ id +" ] 不存在！", null);
        }

        checkUser.setIcon(path);
        int update = userMapper.updateByExample(checkUser, example);
        if (update <= 0){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "修改头像失败！", null);
        }
        return BaseResult.success(BaseResult.STATECODE.OK, "修改头像成功！", id);
    }
}
