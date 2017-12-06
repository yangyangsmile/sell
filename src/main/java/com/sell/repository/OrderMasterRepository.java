package com.sell.repository;

import com.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/9/16.
 */
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    Page<OrderMaster>findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
