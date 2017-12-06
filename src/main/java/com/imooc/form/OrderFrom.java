package com.imooc.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Administrator on 2017/9/17.
 */
@Data
public class OrderFrom {
    @NotEmpty(message = "买家姓名必填")
    private String name;
    @NotEmpty(message = "电话号必填")
    private String phone;
    @NotEmpty(message = "地址必填")
    private String  address;
    @NotEmpty(message = "openid 必填")
    private String openid;
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
