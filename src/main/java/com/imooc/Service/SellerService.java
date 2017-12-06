package com.imooc.Service;

import com.imooc.dataobject.SellerInfo;

/**
 * Created by Administrator on 2017/10/4.
 */
public interface SellerService {
    /**
     * 通过openid查询卖家信息
     * @param openId
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openId);
    SellerInfo findSellerInfoByUsernameAndPassword(String username,String password);
}
