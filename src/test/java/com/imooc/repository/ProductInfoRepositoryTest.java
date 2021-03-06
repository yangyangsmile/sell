package com.imooc.repository;

import com.sell.dataobject.ProductInfo;
import com.sell.repository.ProductInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    ProductInfoRepository productInfoRepository;
    @Test
    public void testFindByProductStatus() throws Exception {
        List<ProductInfo> result =productInfoRepository.findByProductStatus(0);
        System.out.print(result.toString());
    }
    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductStock(100);
        productInfo.setProductDescription("不错很好喝");
        productInfo.setProductIcon("http://www.baidu.com.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);
        ProductInfo result = productInfoRepository.save(productInfo);
        System.out.print(result.toString());
    }




}