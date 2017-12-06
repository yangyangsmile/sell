package com.sell.repository;

import com.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/10/4.
 */
@Repository
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String>,CrudRepository<SellerInfo,String>,JpaSpecificationExecutor <SellerInfo>{

    SellerInfo findByOpenid(String openid);

    @Query(value = "select p from SellerInfo p where p.username=?1 and p.password=?2")
     SellerInfo findByUsername( String username,String password) ;


}
