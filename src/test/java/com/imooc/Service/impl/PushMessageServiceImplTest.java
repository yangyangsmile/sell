package com.imooc.Service.impl;

import com.imooc.Service.OrderService;
import com.imooc.Service.PushMessageService;
import com.imooc.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/10/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PushMessageServiceImplTest {
    @Autowired
    private PushMessageService pushMessageService;
    @Autowired
    private OrderService orderService;
    @Test
    public void testOrderStatus() throws Exception {
        OrderDTO orderDTO = orderService.findOne("150712757247460257");
        pushMessageService.orderStatus(orderDTO);
    }
}