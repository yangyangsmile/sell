package com.imooc.controller;

import com.imooc.Service.BuyerService;
import com.imooc.Service.OrderService;
import com.imooc.converter.OrderForm2OrderDTOConverter;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderFrom;
import com.imooc.util.ResultVOUtil;
import com.imooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/17.
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {
    //创建订单
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;
    @PostMapping (value = "/create")
    public ResultVO<Map<String,String>>create(@Valid OrderFrom orderFrom
                                                , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderFrom);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);
        Map<String ,String > map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVOUtil.success(map);
    }
    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>>list(@RequestParam("openid") String openid,
                                        @RequestParam(value = "page",defaultValue = "0")Integer page,
                                        @RequestParam(value = "size",defaultValue ="10") Integer size){
        if (StringUtils.isEmpty(openid)){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);
        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO>detail (@RequestParam("openid")String openid,
                                    @RequestParam("orderid")String orderId){
        OrderDTO orderDTo =  buyerService.findOrderOne(openid,orderId);
        return ResultVOUtil.success(orderDTo);

    }
    @GetMapping("/cancel")
    public ResultVO<OrderDTO>cancel(@RequestParam("openid")String openid,
                                    @RequestParam("orderid")String orderId){

         buyerService.cancelOrder(openid,orderId);
        return ResultVOUtil.success();
    }





    //取消订单

}
