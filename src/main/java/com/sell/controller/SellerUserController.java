package com.sell.controller;

import com.sell.Service.SellerService;
import com.sell.constant.CookieConstant;
import com.sell.constant.RedisConstant;
import com.sell.dataobject.SellerInfo;
import com.sell.enums.ResultEnum;
import com.sell.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/10/4.
 */
@Slf4j
@Controller
@RequestMapping("/seller")
public class SellerUserController {
    @Autowired
    private SellerService sellerService;
    //// TODO: 2017/10/5
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/login/login");
    }
    @GetMapping("/login")
    public ModelAndView login(@RequestParam(value = "username",required = false)String username,
                      @RequestParam(value = "password",required = false)String password,
                              HttpServletResponse response,
                      Map<String,Object> map){
        SellerInfo sellerInfo= sellerService.findSellerInfoByUsernameAndPassword(username,password);
        if (sellerInfo==null){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url","/seller/order/list");
            return new ModelAndView("/login/login",map );
        }
        log.info("登录成功");
        String  token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKE_PREFIX,token),username  ,expire, TimeUnit.SECONDS);

        CookieUtil.setCookie(response, CookieConstant.TOKEN,token,expire);
        log.info("测试");
        return new ModelAndView("redirect:"+"/seller/order/list");
        //校验
        //设置token 至redis

        //设置token 至cookie
    }
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletResponse response, HttpServletRequest request,Map<String,Object> map){
        //1,从cookie查询
      Cookie  cookie = CookieUtil.getCookie(request,CookieConstant.TOKEN);
        if (cookie!=null){
            //清楚redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKE_PREFIX,cookie.getValue()));
            //清除cookie
           CookieUtil.setCookie(response,CookieConstant.TOKEN,null,0);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url","/seller/login/");
        return new ModelAndView("common/success",map);
    }
}
