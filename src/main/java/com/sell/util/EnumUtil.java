package com.sell.util;

import com.sell.enums.CodeEnum;

/**
 * Created by Administrator on 2017/10/2.
 */
public class EnumUtil {
    public static <T extends CodeEnum> T  getEnum(Integer code,Class<T> enumClass){
        for (T each:enumClass.getEnumConstants()){
            if (each.getCode().equals(code)){
                return each;
            }
        }
        return null;
    }
}
