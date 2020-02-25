package com.cosmax.shop.system.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * goods_opt
 * @author
 */
@Data
public class GoodsOpt implements Serializable {
    /**
     * 库存id
     */
    private Long id;

    /**
     * 状态：0为进货，1为销售，2为退货
     */
    private Integer status;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 操作时间
     */
    private Date createDate;

    private static final long serialVersionUID = 1L;
}
