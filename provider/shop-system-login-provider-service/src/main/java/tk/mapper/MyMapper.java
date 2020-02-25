package tk.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @program: shop-system
 * @description:
 * @author: Cosmax
 * @create: 2020/02/23 12:32
 */
public interface MyMapper<T> extends MySqlMapper<T>, Mapper<T> {
}
