package com.imooc.Service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by Administrator on 2017/9/15.
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory>findByCategoryTypeIn(List<Integer>categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
