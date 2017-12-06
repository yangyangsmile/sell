package com.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/10/4.
 */
@Data
@Entity
@Table(name="seller_info")
public class SellerInfo {

    @Id
    private  String sellerId;
    private String username;
    private String password;
    private String openid;



}
