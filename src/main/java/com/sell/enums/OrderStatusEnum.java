package com.sell.enums;

/**
 * Created by Administrator on 2017/9/15.
 */
public enum OrderStatusEnum implements CodeEnum{
    NEW(0,"新订单"),
    FINISH(1,"完结"),
    CANCEL(2,"已取消");
    private Integer code;
    private String message;
    OrderStatusEnum(Integer code,String  message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
