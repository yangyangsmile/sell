package com.imooc.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/15.
 */
@Data
public class ResultVO<T> implements Serializable{


    private static final long serialVersionUID = -8349181922768084604L;
    private Integer code;
    private String msg;
    private T data;


}
