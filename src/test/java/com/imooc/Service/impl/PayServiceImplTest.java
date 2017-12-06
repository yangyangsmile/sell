package com.imooc.Service.impl;

import com.imooc.Service.OrderService;
import com.imooc.Service.PayService;
import com.imooc.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/10/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;
    @Autowired
    private OrderService orderService;

    @Test
    public void testCreate() throws Exception {
        OrderDTO orderDTO = orderService.findOne("150686056057146151");
        payService.create(orderDTO);

    }

    @Test
    public void testRefund() throws Exception {
        OrderDTO orderDTO = orderService.findOne("150694789093717363");
        payService.refund(orderDTO);
    }
}