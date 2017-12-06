package com.imooc.repository;

import com.imooc.dataobject.SellerInfo;
import com.imooc.util.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/10/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;
    @Test
    public void testFindByOpenid() throws Exception {
        SellerInfo sellerInfo = sellerInfoRepository.findByOpenid("测试");
        System.out.println(sellerInfo.toString());
    }
    @Test
    public  void testSave()throws  Exception{
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setOpenid("abc");
        sellerInfo.setPassword("admin");
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
         SellerInfo sellerInfo1 = sellerInfoRepository.save(sellerInfo);
        System.out.println(sellerInfo1.toString());
    }

    @Test
    public void testFindByUsername() throws Exception {
        SellerInfo sellerInfoList = sellerInfoRepository.findByUsername("admin","admin");
            System.out.println(sellerInfoList.toString());
    }
}