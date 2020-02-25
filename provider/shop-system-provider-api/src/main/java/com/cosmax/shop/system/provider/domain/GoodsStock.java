package com.cosmax.shop.system.provider.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * goods_stock
 * @author
 */
@Data
public class GoodsStock implements Serializable {
    /**
     * 商品id
     */
    private Integer id;

    /**
     * 商品数量
     */
    private Long num;

    private static final long serialVersionUID = 1L;
}
