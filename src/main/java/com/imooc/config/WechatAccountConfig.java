package com.imooc.config;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/1.
 */
@Data
@Component
public class WechatAccountConfig {
//    private String mpAppId = "wxd46b84acdd906bc4";
//    private String mpAppSecret="6d14b67bc3fa4a8bc31f5d393b7e6b48";
    private String mpAppId = "wxd898fcb01713c658";
   // private String mpAppSecret="6d14b67bc3fa4a8bc31f5d393b7e6b48";
    private String mchId ="1483469312";
    private String mchKey="C5245D70627C1F8E9964D494B0735025";
    private String keyPath="E:\\sell\\src\\main\\resources\\h5.p12";
    private String notifyUrl = "http://kunkun.natapp1.cc/notify";
}
