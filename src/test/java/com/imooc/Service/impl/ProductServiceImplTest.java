package com.imooc.Service.impl;

import com.sell.Service.impl.ProductServiceImpl;
import com.sell.dataobject.ProductInfo;
import com.sell.enums.ProductStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void testFindOne() throws Exception {
        ProductInfo result = productService.findOne("123456");
        System.out.print(result.toString());
    }

    @Test
    public void testFindUpAll() throws Exception {
        List<ProductInfo>result = productService.findUpAll();
    }

    @Test

    public void testFindAll() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo>productInfoPage = productService.findAll(request);
        System.out.print(productInfoPage.getTotalElements());
    }

    @Test
    public void testSave() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductStock(100);
        productInfo.setProductDescription("不错很好吃");
        productInfo.setProductIcon("http://www.baidu.com.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(3);
        ProductInfo result = productService.save(productInfo);
        System.out.println(result.toString());
    }

    @Test
    public void testOnSale() throws Exception {
        ProductInfo productInfo = productService.onSale("123456");
        System.out.print(productInfo.getProductStatusEnum().getMessage());
    }

    @Test
    public void testOffSale() throws Exception {
        ProductInfo productInfo = productService.offSale("123456");
        System.out.print(productInfo.getProductStatusEnum().getMessage());
    }
}