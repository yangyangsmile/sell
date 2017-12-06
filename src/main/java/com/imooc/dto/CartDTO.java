package com.imooc.dto;

import lombok.Data;

/**
 * Created by Administrator on 2017/9/16.
 */
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
