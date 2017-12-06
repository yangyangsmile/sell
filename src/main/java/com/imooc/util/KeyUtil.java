package com.imooc.util;

import java.util.Random;

/**
 * Created by Administrator on 2017/9/16.
 */
public class KeyUtil {
    /**
     * 生成主键
     * 时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer a = random.nextInt(90000)+10000;
        return System.currentTimeMillis()+ String.valueOf(a);
    }
}
