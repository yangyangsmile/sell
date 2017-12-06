package com.imooc.Service.impl;

import com.imooc.Service.PushMessageService;
import com.imooc.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/10/5.
 */
@Service("PushMessageService")
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    private WxMpService wxMpService;

    @Override
    public void orderStatus(OrderDTO orderDTO) {

        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId("C5245D70627C1F8E9964D494B0735025");
        templateMessage.setToUser("oTgZpweNnfivA9ER9EIXoH-jlrWQ");
//        templateMessage.setToUser("oTgZpwRq9r_xvXj9Xu0VrnvXzJDQ");

        List<WxMpTemplateData> data = Arrays.asList(
            new WxMpTemplateData("first","亲，请记得收货"),
            new WxMpTemplateData("keyword1","微信点餐"),
                new WxMpTemplateData("keyword2","15801113139"),
                new WxMpTemplateData("keyword3",orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4",orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5",orderDTO.getOrderAmount()+""),
                new WxMpTemplateData("remark","感谢您的购买，欢迎再次光临")
        );

        templateMessage.setData(data);
            try {
                wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            }catch (WxErrorException e){
                log.error("微信模板消息发送失败，{}",e);
            }
    }
}
