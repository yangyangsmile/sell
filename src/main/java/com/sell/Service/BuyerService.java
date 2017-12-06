package com.sell.Service;

import com.sell.dto.OrderDTO;

/**
 * 买家
 * Created by Administrator on 2017/9/17.
 */
public interface BuyerService {
    //查询订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
