package com.cosmax.shop.system.provider.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * permission
 * @author
 */
@Data
public class Permission implements Serializable {
    /**
     * 权限id
     */
    private Integer id;

    /**
     * 父级权限id
     */
    private Integer pid;

    /**
     * 权限中文名
     */
    private String nameCn;

    /**
     * 权限英文名
     */
    private String name;

    /**
     * 授权路径
     */
    private String path;

    private static final long serialVersionUID = 1L;
}
