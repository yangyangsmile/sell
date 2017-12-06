package com.sell.enums;

import lombok.Getter;

/**
 * Created by Administrator on 2017/9/16.
 */
@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),
   PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不正确"),
    ORDER_NOT_EXIT(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(12,"訂單詳情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_FAIL(15,"更新项目失败"),
    ORDER_DATAIL_EMPTY(16,"订单中无产品"),
    ORDER_PAY_STATUS_ERROR(17,"订单支付状态不正确"),
    PARAM_ERROR(1,"参数不正确"),
   CART_EMPTY(18,"购物车不能为空"),
    ORDER_OWNER_ERROR(19,"该订单不属于当前用户"),
    WECHAT_MP_ERROR(20,"微信公众账号方面错误"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21,"微信通知校验不通过"),
    ORDER_CANCEL_SUCCESS(22,"订单取消成功"),
    ORDER_FINISH_SUCCESS(23,"订单完结成功"),
    LOGIN_FAIL(25,"登录信息不正确"),
    LOGOUT_SUCCESS(26,"登出成功")
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
