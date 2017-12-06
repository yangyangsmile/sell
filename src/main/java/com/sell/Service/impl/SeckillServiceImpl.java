package com.sell.Service.impl;

import com.sell.Service.RedisLock;
import com.sell.exception.SellException;
import com.sell.util.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/6.
 */
@Service
public class SeckillServiceImpl {

    @Autowired
    private RedisLock redisLock;
    static Map<String ,Integer> products;
    static Map<String,Integer> stock;
    static Map<String,String>orders;
    static {
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456",100000);
        stock.put("123456",100000);
    }

    private String queryMap(String productId){
        return "国庆活动，皮蛋瘦肉粥特价，限量"+products.get(productId)+"还剩"+stock.get(productId)+"商品成功下单用户数目："+orders.size()+"人";
    }

    public String querySeckillProductInfo(String productId){
        return this.queryMap(productId);
    }


    public void orderProductMockDiffUser(String productId){

//        加锁
        String time =  String.valueOf(System.currentTimeMillis()+10000) ;
      if (! redisLock.lock(productId,time)){
          throw  new SellException(101,"redis加锁失败");
      }
        int stockNum = stock.get(productId);
        if (stockNum==0){
            throw new SellException(100,"活动已经结束");
        }else{
            orders.put(KeyUtil.genUniqueKey(),productId);
            stockNum = stockNum-1;
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            stock.put(productId,stockNum);


        }
//        解锁
        redisLock.unlock(productId,time);
    }
}

