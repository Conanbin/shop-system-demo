package com.cosmax.shop.system.storage.provider.service.impl;

import com.cosmax.shop.system.commons.dto.BaseResult;
import com.cosmax.shop.system.storage.provider.service.FileService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: shop-system
 * @description: 文件接口实现
 * @author: Cosmax
 * @create: 2020/02/20 21:21
 */

@Service(version = "1.0.0")
public class FileServiceImpl implements FileService {


    @Override
    public BaseResult upload(MultipartFile multipartFile, String path) {

        if (multipartFile.isEmpty()){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "上传文件不能为空！", null);
        }
        if (StringUtils.isBlank(path)){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "上传路径不能为空！", null);
        }

        // 获取后缀
        String suffix = "";
        String originalFilename = multipartFile.getOriginalFilename();
        if (StringUtils.isBlank(originalFilename)){
            return BaseResult.fail(BaseResult.STATECODE.ERROR, "文件获取异常！", null);
        }
        if (originalFilename.contains(".")){
            String[] split = originalFilename.split("\\.");
            suffix = split[split.length - 1];
        }

        String fileName = UUID.randomUUID().toString().replaceAll("-","") + "." + suffix;
        File filepath = new File(path, fileName);

        // 判断路径是否存在，不存在则新创建一个
        if (!filepath.getParentFile().exists()) {
            boolean mkdirs = filepath.getParentFile().mkdirs();
            if (!mkdirs){
                return BaseResult.fail(BaseResult.STATECODE.ERROR, "创建文件夹异常！", null);
            }
        }
        // 将上传文件保存到目标文件目录
        try {
            multipartFile.transferTo(new File(path + File.separator + fileName));
            return BaseResult.success(BaseResult.STATECODE.OK, "上传成功！", fileName);
        } catch (IOException e) {
                return BaseResult.fail(BaseResult.STATECODE.ERROR, e.toString(), null);

        }
//        Path savePath = Paths.get(path, fileName);
//        try {
//            Files.write(savePath, multipartFile.getBytes());
//
//        } catch (IOException e) {
//            return BaseResult.fail(BaseResult.STATECODE.ERROR, e.toString(), null);
//        }

    }

}
