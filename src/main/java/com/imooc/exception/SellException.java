package com.imooc.exception;

import com.imooc.enums.ResultEnum;
import com.lly835.bestpay.rest.type.Get;
import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Administrator on 2017/9/16.
 */
@Getter
public class SellException extends RuntimeException {
    private Integer code;


    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
