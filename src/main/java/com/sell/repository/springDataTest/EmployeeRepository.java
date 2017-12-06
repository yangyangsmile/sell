package com.sell.repository.springDataTest;

import com.sell.dataobject.OrderMaster;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/10/29.
 */
public interface EmployeeRepository extends JpaRepository<OrderMaster,String> {

}
