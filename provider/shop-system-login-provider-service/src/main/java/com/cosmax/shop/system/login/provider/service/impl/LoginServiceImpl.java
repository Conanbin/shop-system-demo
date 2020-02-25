package com.cosmax.shop.system.login.provider.service.impl;

import com.cosmax.shop.system.commons.dto.BaseResult;
import com.cosmax.shop.system.commons.dto.ValidatorUtil;
import com.cosmax.shop.system.login.provider.api.LoginService;
import com.cosmax.shop.system.login.provider.domain.LoginLog;
import com.cosmax.shop.system.login.provider.mapper.LoginLogMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: shop-system
 * @description: 登录接口实现
 * @author: Cosmax
 * @create: 2020/02/23 12:31
 */

@Service(version = "1.0.0")
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginLogMapper loginLogMapper;

    @Override
    public BaseResult insertLoginLog(LoginLog loginLog) {

        BaseResult checkInsertLog = checkLoginLog(loginLog);
        if (checkInsertLog.getCode() != BaseResult.STATECODE.OK){
            return checkInsertLog;
        }
        loginLog.setId(System.currentTimeMillis());
        loginLog.setLoginTime(new Date());
        int insert = loginLogMapper.insert(loginLog);
        if (insert <= 0){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "新增日志失败！", null);
        }
        return BaseResult.success(BaseResult.STATECODE.OK, "新增日志成功！", loginLog);
    }

    /**
     * 传入实体参数校验
     * @param loginLog 日志实体 {@link LoginLog}
     * @return 响应实体 {@link BaseResult}
     */
    private BaseResult checkLoginLog(LoginLog loginLog) {
        if (loginLog == null){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "参数实体不能为空！", null);
        }

        if (loginLog.getUserId() == null || loginLog.getUserId() <= 0){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "用户id不能为空！", null);
        }

        if (StringUtils.isBlank(loginLog.getLoginIp())){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "登录地址不能为空！", null);
        }

        if (!ValidatorUtil.isIPAddr(loginLog.getLoginIp())){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "登录地址格式有误！", null);
        }
        return BaseResult.success(BaseResult.STATECODE.OK,"校验成功！", null);

    }

    @Override
    public BaseResult getLoginLogsByUserId(Integer userId) {
        Example example = new Example(LoginLog.class);
        example.createCriteria().andEqualTo("userId", userId);
        example.setOrderByClause("loginTime desc");
        List<LoginLog> loginLogs = loginLogMapper.selectByExample(example);
        return BaseResult.success(BaseResult.STATECODE.OK, "查询成功！", loginLogs);
    }

}
