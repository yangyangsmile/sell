package com.imooc.Service.impl;

import com.imooc.Service.OrderService;
import com.imooc.Service.PayService;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.util.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lly835.bestpay.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/1.
 */
@Service("PayService")
@Slf4j
public class PayServiceImpl implements PayService {
    private static final String ORDER_NAME ="微信点餐订单";
    @Autowired
    private BestPayServiceImpl bestPayService;
    @Autowired
    private OrderService orderService;
    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);

        log.info("【微信支付】发起支付request={}", JsonUtil.toJson( payRequest));
        PayResponse payResponse =bestPayService.pay(payRequest);
        log.info("【微信支付response】发起支付={}",JsonUtil.toJson(payResponse));
        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyDate) {
        //1、验证签名
        //2、支付状态
        //3、支付金额
        //4，支付人
        log.info("进入notify方法");

        PayResponse payResponse = bestPayService.asyncNotify(notifyDate);
        log.info("【微信处理异步通知】 payResponse ={}" ,JsonUtil.toJson(payResponse));
        //查询订单
        OrderDTO orderDTO =orderService.findOne(payResponse.getOrderId());
        if (orderDTO ==null){
            log.error("[微信支付]异步通知 订单不存在 orderID={}",payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }
        if(!MathUtil.equals(payResponse.getOrderAmount(),orderDTO.getOrderAmount().doubleValue())){
            log.error("微信异步支付  订单金额不一致  orderid ={} 微信 ={} 系统={}",
                    payResponse.getOrderId(),payResponse.getOrderAmount(),orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }

        orderService.paid(orderDTO);
        return payResponse;
    }

    /**
     * 退款
     * @param orderDTO
     */
    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("微信退款 request={}",refundRequest);

         RefundResponse refundResponse =bestPayService.refund(refundRequest);

        log.info("微信退款response{}",refundResponse);
        return refundResponse;
    }
}
