package com.cosmax.shop.system.storage.provider.service;

import com.cosmax.shop.system.commons.dto.BaseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: shop-system
 * @description: 文件接口
 * @author: Cosmax
 * @create: 2020/02/20 21:17
 */
public interface FileService {

    /**
     * 上传文件
     * @param multipartFile 文件
     * @param path 上传路径
     * @return 响应实体 {@link BaseResult}
     */
    BaseResult upload(MultipartFile multipartFile, String path);

}
