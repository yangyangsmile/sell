package com.sell.repository.springDataTest;

import com.sell.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2017/10/29.
 */
public interface OrderMasterExtendRepository extends PagingAndSortingRepository<OrderMaster,String>,JpaSpecificationExecutor {




}
