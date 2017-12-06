package com.sell.controller;

import com.sell.Service.OrderService;
import com.sell.dto.OrderDTO;
import com.sell.enums.ResultEnum;
import com.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/30.
 */
@Slf4j
@Controller
@RequestMapping("/seller/order")
public class SellOrderController {

    @Autowired
    private OrderService orderService;
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page" ,defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map map){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"createTime");
        Sort sort = new Sort(order);
        PageRequest pageRequest = new PageRequest(page-1,size,sort);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
        map.put("orderDTOPage",orderDTOPage);
        map.put("currentPage",page);
        return new ModelAndView("order/list",map);
      //  return null;
    }
    @RequestMapping(value = "/cancel",method = RequestMethod.GET)
    public ModelAndView cancel(@RequestParam("orderId")String orderId,Map<String ,Object>map){
      try{  OrderDTO orderDTO = orderService.findOne(orderId);
           orderService.cancel(orderDTO);
      }
        catch(SellException e){
                log.error("卖家端取消订单，查询不到订单");
                map.put("msg",e.getMessage());
                map.put("url","/seller/order/list");
                return  new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url","/seller/order/list");

        return new ModelAndView("common/success",map);
    }
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ModelAndView detail(@RequestParam("orderId")String orderId,Map<String ,Object>map){
        OrderDTO orderDTO ;
        try{  orderDTO = orderService.findOne(orderId);
        }
        catch(SellException e){
            log.error("卖家端查询订单详情发生异常");
            map.put("msg",e.getMessage());
            map.put("url","/seller/order/list");
            return  new ModelAndView("common/error", map);
        }
        map.put("orderDTO",orderDTO);
        return  new ModelAndView("order/detail", map);
    }

    @GetMapping("/finish")
    public ModelAndView finished(@RequestParam("orderId")String orderId,Map<String ,Object>map){
        try{  OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        }
        catch(SellException e){
            log.error("卖家端完结订单，查询不到订单");
            map.put("msg",e.getMessage());
            map.put("url","/seller/order/list");
            return  new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url","/seller/order/list");

        return new ModelAndView("common/success",map);
    }












}
