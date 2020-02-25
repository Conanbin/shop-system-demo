package com.cosmax.shop.system.storage.provider.controller;

import com.cosmax.shop.system.commons.dto.BaseResult;
import com.cosmax.shop.system.storage.provider.service.FileService;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * @program: shop-system
 * @description: 文件相关操作
 * @author: Cosmax
 * @create: 2020/02/20 20:27
 */
@RestController
@RequestMapping("storage")
public class StorageController {

    @Resource
    private FileService fileService;

    private String UPLOAD_PATH = new ApplicationHome(getClass()).getSource().getParentFile().getParent() + "/upload";
    @PostMapping("/common/upload")
    public BaseResult uploadCommon(@RequestPart("multipartFile") MultipartFile multipartFile){
        BaseResult upload = fileService.upload(multipartFile, UPLOAD_PATH + "/common");
        if (upload.getCode() != BaseResult.STATECODE.OK){
            return upload;
        }
        String path = "/storage/common/" + upload.getData().toString();
        upload.setData(path);
        return upload;
    }

    @PostMapping("/auth/upload")
    public BaseResult uploadAuth(@RequestPart("multipartFile") MultipartFile multipartFile){
        BaseResult upload = fileService.upload(multipartFile, UPLOAD_PATH + "/auth");
        if (upload.getCode() != BaseResult.STATECODE.OK){
            return upload;
        }
        String path = "/storage/auth/" + upload.getData().toString();
        upload.setData(path);
        return upload;
    }

    @PreAuthorize("hasAuthority('ROLE_USER_READ')")
    @PostMapping("/common/delete")
    public BaseResult deleteCommon(@RequestParam(value = "fileName") String fileName) {
        File source = new File(UPLOAD_PATH + "/common" + File.separator + fileName);

        boolean delete = source.delete();
        if (delete){
            return BaseResult.success(BaseResult.STATECODE.OK, "删除成功！", null);
        }
        return BaseResult.fail(BaseResult.STATECODE.ERROR, "删除失败！", null);
    }

    @PreAuthorize("hasAuthority('ROLE_USER_READ')")
    @PostMapping("/auth/delete")
    public BaseResult deleteAuth(@RequestParam(value = "fileName") String fileName) {
        File source = new File(UPLOAD_PATH + "/auth" + File.separator + fileName);
        boolean delete = source.delete();
        if (delete){
            return BaseResult.success(BaseResult.STATECODE.OK, "删除成功！", null);
        }
        return BaseResult.fail(BaseResult.STATECODE.ERROR, "删除失败！", null);
    }

}
