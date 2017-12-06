package com.imooc.repository.springDataTest;

import com.sell.dataobject.OrderMaster;
import com.sell.repository.springDataTest.EmployeeRepository;
import com.sell.repository.springDataTest.OrderMasterExtendRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by Administrator on 2017/10/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterExtendRepositoryTest {
    @Autowired
    private OrderMasterExtendRepository orderMasterExtendRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Test
    public void pageTest(){
       // Sort sort = new Sort("");
        Pageable pageable = new PageRequest(0,5);
        Page<OrderMaster> page = orderMasterExtendRepository.findAll(pageable);
        System.out.println("一共有"+page.getTotalPages()+"页");
    }
    @Test
    public void PageAndSortTest(){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"createTime");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(0,2,sort);
        Page<OrderMaster> page = orderMasterExtendRepository.findAll(pageable);
        List<OrderMaster> orderMasterList = page.getContent();
        for (OrderMaster item : orderMasterList){
            System.out.println(item.toString());
        }



    }
    @Test
    public void Query() {

        Specification<OrderMaster> specification = new Specification<OrderMaster>() {
            @Override
            public Predicate toPredicate(Root<OrderMaster> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //root(ordermaster(createtime))
                Path path = root.get("createTime");
                return criteriaBuilder.gt(path, 50);

            }
        };
        orderMasterExtendRepository.findAll(specification);

    }















}