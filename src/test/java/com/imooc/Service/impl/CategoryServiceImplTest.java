package com.imooc.Service.impl;

import com.imooc.dataobject.ProductCategory;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Null;
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
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    public void testFindOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(1);
        System.out.print(productCategory.toString());

    }

    @Test
    public void testFindAll() throws Exception {
        List <ProductCategory>productCategoryList = categoryService.findAll();
        System.out.print(productCategoryList.toString());
    }

    @Test
    public void testFindByCategoryTypeIn() throws Exception {
        List<ProductCategory>productCategoryList= categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        System.out.println("共有这么多个数据 "+productCategoryList.size());
    }

    @Test
    public void testSave() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("男生专享");
        productCategory.setCategoryType(5);
        ProductCategory result = categoryService.save(productCategory);
        System.out.print(result.toString());
    }
}