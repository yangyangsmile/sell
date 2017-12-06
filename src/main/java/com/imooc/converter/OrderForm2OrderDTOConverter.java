package com.imooc.converter;

import com.google.gson.Gson;
import com.google.gson.internal.Excluder;
import com.google.gson.reflect.TypeToken;
import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderFrom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/17.
 */
public class OrderForm2OrderDTOConverter {
    public  static OrderDTO convert(OrderFrom orderFrom){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderFrom.getName());
        orderDTO.setBuyerPhone(orderFrom.getPhone());
        orderDTO.setBuyerAddress(orderFrom.getAddress());
        orderDTO.setBuyerOpenid(orderFrom.getOpenid());
        List<OrderDetail>orderDetailList = new ArrayList<>();
      try {
          orderDetailList = gson.fromJson(orderFrom.getItems(), new TypeToken<List<OrderDetail>>() {
          }.getType());
      }catch (Exception e){
          e.getStackTrace();
          throw new SellException(ResultEnum.PARAM_ERROR);
      }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
