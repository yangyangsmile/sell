package com.imooc.controller;

import com.imooc.Service.OrderService;
import com.imooc.Service.PayService;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Administrator on 2017/10/1.
 */
@Slf4j
@Controller
//@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;
    @GetMapping("/pay")
    public ModelAndView  index(@RequestParam("openid")String openid,
                               @RequestParam("orderId")String orderId,
                               @RequestParam("returnUrl")String returnUrl,
                         Map<String ,Object> map){
        log.info("openid={}",openid);
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }
       // orderDTO.setBuyerOpenid(openid);
        PayResponse payResponse =  payService.create(orderDTO);
        map.put("payResponse",payResponse);
        map.put("returnUrl", returnUrl);
        return new ModelAndView("pay/create",map);
    }


    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId")String orderId, @RequestParam("returnUrl") String returnUrl,
                               Map<String ,Object> map){

        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }
       PayResponse payResponse =  payService.create(orderDTO);
        map.put("payResponse",payResponse);
        return new ModelAndView("pay/create",map);

    }


    @PostMapping ("/notify")
    public ModelAndView notify(@RequestBody String notifyDate){

        payService.notify(notifyDate);
        return new ModelAndView("pay/success");
    }

}
