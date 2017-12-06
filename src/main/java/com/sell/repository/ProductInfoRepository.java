package com.sell.repository;

import com.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String > {
    List<ProductInfo> findByProductStatus(Integer productStatus);


}
