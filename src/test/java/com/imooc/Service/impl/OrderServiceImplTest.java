package com.imooc.Service.impl;

import com.sell.Service.impl.OrderServiceImpl;
import com.sell.dataobject.OrderDetail;
import com.sell.dto.OrderDTO;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;
    private final String BUYEROPENID="110110";
    private final String ORDER_ID = "150555745480119478";
    @Test
    public void testCreate() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("测试测试2");
        orderDTO.setBuyerAddress("慕课");
        orderDTO.setBuyerPhone("12345678912");
        orderDTO.setBuyerOpenid(BUYEROPENID);

        List<OrderDetail>orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123457");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);


    }

    @Test
    public void testFindOne() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        System.out.println("测试结果");
        System.out.println(orderDTO.toString()+"测试结果");
    }

    @Test
    public void testFinList() throws Exception {
        PageRequest request = new PageRequest(0,2);
       Page<OrderDTO> orderDTOPage = orderService.findList(BUYEROPENID,request);
        Assert.assertEquals(0,orderDTOPage.getTotalElements());
        System.out.print(orderDTOPage.toString());
    }

    @Test
    public void testCancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        System.out.print(result.getOrderStatus());
        System.out.print(result.toString());
//        Assert.assertNotSame(result.getOrderStatus(), OrderStatusEnum.CANCEL.getCode());
    }

    @Test
    public void testFinish() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        System.out.print(result.getOrderStatus());
        System.out.print(result.toString());
    }

    @Test
    public void testPaid() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        System.out.print(result.getPayStatus());
        System.out.print(result.toString());
    }
    @Test
    public void list(){
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        System.out.print(orderDTOPage.getTotalElements());
    }
}