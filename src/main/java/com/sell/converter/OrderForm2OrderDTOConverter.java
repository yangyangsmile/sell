package com.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sell.dataobject.OrderDetail;
import com.sell.dto.OrderDTO;
import com.sell.enums.ResultEnum;
import com.sell.exception.SellException;
import com.sell.form.OrderFrom;

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
