package com.cosmax.shop.system.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * goods_info
 * @author
 */
@Data
public class GoodsInfo implements Serializable {
    /**
     * 商品id
     */
    private Integer id;

    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 产地
     */
    private String place;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 单位
     */
    private String unit;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}
