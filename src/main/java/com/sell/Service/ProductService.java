package com.sell.Service;

import com.sell.dataobject.ProductInfo;
import com.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
public interface ProductService {
    ProductInfo findOne(String productId);
    //查询在架的商品
    List<ProductInfo>findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);
    //更新库存
    //加库存
    void increaseStock(List<CartDTO > cartDTOList);
    //减库存
    void decreaseStock(List<CartDTO > cartDTOList);

    ProductInfo onSale(String productId);

    ProductInfo offSale(String productId);
}
