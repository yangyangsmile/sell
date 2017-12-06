package com.imooc.controller;

import com.imooc.dto.CartDTO;
import com.imooc.dto.OrderDTO;
import com.imooc.dto.User;
import com.imooc.dto.UserFrom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/9/19.
 */
@Controller
public class testController {
    @RequestMapping("baseType")
    @ResponseBody
    public String baseType(int age) {
        return "age" + age;
    }

    @RequestMapping(value="array.do")
    @ResponseBody
    public String baseType(String[] age) {

        StringBuffer stringBuffer = new StringBuffer();
        for (String item : age) {
            stringBuffer.append(item);
        }
        return stringBuffer.toString();
    }
    @RequestMapping(value="object.do")
    @ResponseBody
    public String baseType(User user) {
        return user.toString();

    }
    @RequestMapping(value="list.do")
    @ResponseBody
    public String baseType(UserFrom user) {
        return user.toString();

    }



}
