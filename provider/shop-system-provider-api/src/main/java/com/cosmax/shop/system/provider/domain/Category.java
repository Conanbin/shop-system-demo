package com.cosmax.shop.system.provider.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * category
 * @author 
 */
@Data
public class Category implements Serializable {
    /**
     * 分类id
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}