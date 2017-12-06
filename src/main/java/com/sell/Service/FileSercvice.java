package com.sell.Service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2017/10/7.
 */
public interface FileSercvice {
    String upload (MultipartFile file , String path);
}
