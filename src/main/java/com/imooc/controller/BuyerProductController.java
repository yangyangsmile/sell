package com.imooc.controller;

import com.imooc.Service.CategoryService;
import com.imooc.Service.ProductService;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.util.ResultVOUtil;
import com.imooc.vo.ProductInfoVO;
import com.imooc.vo.ProductVo;
import com.imooc.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 买家商品
 * Created by Administrator on 2017/9/15.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames ="product" ,key ="#sellerId",condition = "#sellerId.leng()>3",unless = "#result.getCode()!=0")//KEY设置为接口参数，这样可以动态存储每一个key ,conditiion可以指定判断条件 条件成立 缓存，否则不缓存//unless 设置返回code 如果是0 则缓存，否则不缓存
    public ResultVO list(String sellerId){
        //查询所有的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //查询类目
        List<Integer>categoryTypeList= new ArrayList<>();
       for(ProductInfo productInfo:productInfoList){
           categoryTypeList.add(productInfo.getCategoryType());
       }
        List<ProductCategory>productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //数据拼装
        List<ProductVo>productVoList = new ArrayList<>();
        for (ProductCategory productCategory :productCategoryList){
            ProductVo productVo = new ProductVo();
            productVo.setCategoryType(productCategory.getCategoryType());
           productVo.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO>productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo :productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    productInfoVO.setProductDescription(productInfo.getProductDescription());
                    productInfoVO.setProductIcon(productInfo.getProductIcon());
                    productInfoVO.setProductId(productInfo.getProductId());
                    productInfoVO.setProductPrice(productInfo.getProductPrice());
                    productInfoVO.setProductName(productInfo.getProductName());
                    productInfoVOList.add(productInfoVO);
                }
            }
           productVo.setProductVoList(productInfoVOList);
            productVoList.add(productVo);

        }
      return ResultVOUtil.success(productVoList);
    }
}
