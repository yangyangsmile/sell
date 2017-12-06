package com.imooc.repository;

import com.sell.dataobject.ProductCategory;
import com.sell.repository.ProductCategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void finOneTest() {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest() {
    ProductCategory productCategory = new ProductCategory();
    productCategory.setCategoryId(2);
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer>list = Arrays.asList(2,3,4);
        List<ProductCategory>result =repository.findByCategoryTypeIn(list);
//        Assert.assertEquals(0,result.size());
    }
}