package com.sell.controller;

import com.sell.Service.impl.SeckillServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/10/6.
 */
@RestController
@RequestMapping("/skill")
@Slf4j
public class SeckillController {

    @Autowired
    private SeckillServiceImpl seckillService;

    @GetMapping("/query/{productId}")
    public String query(@PathVariable String productId)throws  Exception {
        return seckillService.querySeckillProductInfo(productId);
    }

    @GetMapping("/order/{productId}")
    public String skill(@PathVariable String productId) throws  Exception{
        log.info("@skill request,productId"+productId);
        seckillService.orderProductMockDiffUser(productId);
        return  seckillService.querySeckillProductInfo(productId);
    }
}
