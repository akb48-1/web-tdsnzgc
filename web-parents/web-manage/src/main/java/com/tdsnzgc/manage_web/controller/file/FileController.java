package com.tdsnzgc.manage_web.controller.file;

import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Api(tags = "文件上传Controller")
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private Environment environment;

    static final String[] types = {"organ", "goods", "user", "banner"}; // 图片所属模块类型

    @PostMapping(value = "/uploadImg")
    public Result upload(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "type") String fileType) {
        if (file.isEmpty()) {
            return new ResultUtil().setErrorMsg("文件为空");
        }
        if (fileType.isEmpty()) {
            return new ResultUtil().setErrorMsg("文件类型为空");
        }
        if (!Arrays.asList(this.types).contains(fileType)) {
            return new ResultUtil().setErrorMsg("暂未开通此类型");
        }
        String dir =  environment.getProperty(fileType + "ImgDir");
        return this.fileUpload(dir, file);
    }

    public Result fileUpload(String dir, MultipartFile file){

        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名

        String filePath = environment.getProperty("drainy") + dir; // 上传后的路径

        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = formatPath(dir + fileName);
        Map data = new HashMap();
        data.put("url", filename);
        return new ResultUtil().setData(data);
    }

    public String formatPath(String path) {
        return path.replaceAll("////", "/");
    }
}
