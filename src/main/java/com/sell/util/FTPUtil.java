package com.sell.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/10/7.
 */
@Data
@Slf4j
public class FTPUtil {
    private static String ftpIp = "127.0.0.1";
    private static String ftpUser="root";
    private static String ftpPass="123456";

    private String ip;
    private int port;
    private String user;
    private String pwd;
    private FTPClient ftpClient;
    public FTPUtil(String ip,int port,String user,String pwd){
        this.ip=ip;
        this.port = port;
        this.user = user;
        this.pwd = pwd;
    }

    public static boolean uploadFile(List<File>fileList) throws IOException {
        FTPUtil ftpUtil = new FTPUtil(ftpIp,21,ftpUser,ftpPass);
        log.info("开始连接FTP服务器");
        Boolean result = ftpUtil.uploadFile("img",fileList);
        log.info("结束上传");
        return result;
    }


    private boolean uploadFile(String remotePath,List<File>fileList) throws IOException {
        boolean uploaded = true;
        FileInputStream fis = null;
        //连接ftp服务器
        if (coonectionSerer(this.ip,this.port,this.user,this.pwd)){
            try {
                ftpClient.changeWorkingDirectory(remotePath);
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();
                for (File fileItem :fileList){
                    fis = new FileInputStream(fileItem);
                    ftpClient.storeFile(fileItem.getName(),fis);
                }
            } catch (IOException e) {
                uploaded = false;
                log.error("上传文件异常",e);
                e.printStackTrace();
            }finally {
                fis.close();
                ftpClient.disconnect();
            }
        }
        return uploaded;
    }

    private boolean coonectionSerer(String ip, int port,String user,String pwd){
        boolean isSuccess = false;
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            isSuccess= ftpClient.login(user,pwd);
        } catch (IOException e) {
            log.error("ftp服务器连接异常");
            e.printStackTrace();
        }
        return isSuccess;
    }





}
