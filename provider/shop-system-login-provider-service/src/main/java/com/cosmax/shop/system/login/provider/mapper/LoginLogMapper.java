package com.cosmax.shop.system.login.provider.mapper;

import com.cosmax.shop.system.login.provider.domain.LoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mapper.MyMapper;

@Mapper
@Component
public interface LoginLogMapper extends MyMapper<LoginLog> {
}
