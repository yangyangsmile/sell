package com.sell.converter;

import com.sell.dataobject.OrderMaster;
import com.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/9/16.
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO> conver(List<OrderMaster>orderMasterList){
       return  orderMasterList.stream().map(e->
                convert(e)
        ).collect(Collectors.toList());
    }
}
