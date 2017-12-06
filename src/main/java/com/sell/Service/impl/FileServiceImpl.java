package com.sell.Service.impl;

import com.sell.Service.FileSercvice;
import com.sell.exception.SellException;
import com.sell.util.FTPUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by Administrator on 2017/10/7.
 *
 */
@Service("FileService")
@Slf4j
public class FileServiceImpl implements FileSercvice {


   public String upload (MultipartFile file ,String path){
       String fileName = file.getOriginalFilename();
       String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
       String uploadFileName = UUID.randomUUID().toString().concat(".").concat(fileExtensionName);
        log.info("开始上传文件，文件的文件名是：{}，上传的路径是：{},新文件名是：{}",fileName,path,uploadFileName);
       File fileDir = new File(path);
       if (!fileDir.exists()){
           fileDir.setWritable(true);
           fileDir.mkdirs();
       }
       File targetFile = new File(path,uploadFileName);
       try {
           file.transferTo(targetFile);

           //将文件上传到服务器上
           FTPUtil.uploadFile(Arrays.asList(targetFile));
           //已经上传到服务器上
           //将upload下边的文件
           targetFile.delete();
       } catch (IOException e) {
           log.error("上传文件失败");
           throw new SellException(103,"文件上传失败");
       }
        return targetFile.getName();
   }


}
