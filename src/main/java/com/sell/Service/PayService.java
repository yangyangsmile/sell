package com.sell.Service;

import com.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * Created by Administrator on 2017/10/1.
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);
    PayResponse notify(String notifyDate);
    RefundResponse refund(OrderDTO orderDTO);
}
