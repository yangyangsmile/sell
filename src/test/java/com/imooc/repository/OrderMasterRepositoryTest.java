package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void testFindByBuyerOpenid() throws Exception {
        PageRequest request = new PageRequest(0,1);
        Page<OrderMaster >result  =repository.findByBuyerOpenid("110110",request);
        System.out.print(result.getTotalElements());
    }
    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234568");
        orderMaster.setBuyerName("八戒");
        orderMaster.setBuyerPhone("12345678912");
        orderMaster.setBuyerAddress("北京大学");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.8));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
}