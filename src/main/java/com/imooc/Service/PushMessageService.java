package com.imooc.Service;

import com.imooc.dto.OrderDTO;

/**
 * Created by Administrator on 2017/10/5.
 */
public interface PushMessageService {
    void orderStatus(OrderDTO orderDTO);
}
