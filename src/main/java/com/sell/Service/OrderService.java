package com.sell.Service;

import com.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2017/9/16.
 */
public interface OrderService {
    /**
     * 创建订单
     */
    OrderDTO create(OrderDTO orderDTO);
    /**
     * 查询订单
     */
    OrderDTO findOne(String orderId);
    /**
     * 查询订单列表
     *
     */
    Page<OrderDTO>findList(String buyerOpenid, Pageable pageable);

    //取消
    OrderDTO cancel(OrderDTO orderDTO);
    //完结
    OrderDTO finish(OrderDTO orderDTO);
    //支付
    OrderDTO paid(OrderDTO orderDTO);

    Page<OrderDTO>findList( Pageable pageable);





}
