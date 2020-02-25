package com.cosmax.shop.system.provider.mapper;

import com.cosmax.shop.system.provider.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mapper.MyMapper;

import java.util.List;

/**
 * @program: shop-system
 * @description:
 * @author: Cosmax
 * @create: 2020/02/18 19:03
 */

@Mapper
@Component
public interface PermissionMapper extends MyMapper<Permission> {

    List<Permission> selectPermissionByUserId(@Param("id") Integer id);
}
