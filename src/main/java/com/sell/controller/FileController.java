package com.sell.controller;

import com.sell.Service.FileSercvice;
import com.sell.util.ResultVOUtil;
import com.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/10/7.
 */
@Controller
@Slf4j
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileSercvice fileSercvice;

    @RequestMapping("/upload")
    @ResponseBody
    public ResultVO upload(@RequestParam("upload_file") MultipartFile file , HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("upload");
        String pathd = fileSercvice.upload(file,path);
        log.info("文件上传结束");
        return ResultVOUtil.success(pathd);

    }

    @RequestMapping("/html")
    public ModelAndView html(){
        return new ModelAndView("file/fileupload");
    }



}
