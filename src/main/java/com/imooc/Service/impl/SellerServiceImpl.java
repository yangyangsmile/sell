package com.imooc.Service.impl;

import com.imooc.Service.SellerService;
import com.imooc.dataobject.SellerInfo;
import com.imooc.repository.SellerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/4.
 */
@Service("SellerService")
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;
    /**
     * 通过openid查询卖家信息
     *
     * @param openId
     * @return
     */
    @Override
    public SellerInfo findSellerInfoByOpenid(String openId) {
        return sellerInfoRepository.findByOpenid(openId);
    }

    @Override
    public SellerInfo findSellerInfoByUsernameAndPassword(String username, String password) {
        return sellerInfoRepository.findByUsername(username,password);
    }
}
