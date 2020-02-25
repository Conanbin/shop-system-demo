package com.cosmax.shop.system.provider.mapper;

import com.cosmax.shop.system.provider.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import tk.mapper.MyMapper;

@Mapper
public interface CategoryMapper extends MyMapper<Category> {
}