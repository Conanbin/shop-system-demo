package com.cosmax.shop.system.provider.mapper;

import com.cosmax.shop.system.provider.domain.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mapper.MyMapper;

@Mapper
public interface UserMapper extends MyMapper<User> {
}