package com.sell.enums;

import lombok.Getter;

/**
 * Created by Administrator on 2017/9/15.
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0,"在售卖"),
    DOWN(1,"已下架");
    private Integer code;
    private String  message;
    ProductStatusEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
