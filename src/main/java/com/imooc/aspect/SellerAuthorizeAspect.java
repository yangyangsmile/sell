//package com.imooc.aspect;
//
//import com.imooc.constant.CookieConstant;
//import com.imooc.constant.RedisConstant;
//import com.imooc.exception.SellerAuthorizeException;
//import com.imooc.util.CookieUtil;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by Administrator on 2017/10/4.
// */
//@Aspect
//@Component
//@Slf4j
//public class SellerAuthorizeAspect {
////// TODO: 2017/10/5
//    StringRedisTemplate  redisTemplate= new StringRedisTemplate();
//
//    @Pointcut("execution(public * com.imooc.controller.Seller*.*(..))"+
//            "&&!execution(public * com.imooc.controller.SellerUserController.*(..))")
//    public void verify(){
//
//    }
//    @Before("verify()")
//    public void doVerify(){
//       ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//       HttpServletRequest request = attributes.getRequest();
//        //查询cookie
//        Cookie cookie = CookieUtil.getCookie(request, CookieConstant.TOKEN);
//        if (cookie==null){
//            log.warn("[登录校验]cookie中查不到token");
//            throw new SellerAuthorizeException();
//        }
//        //去redis 里查询
//        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKE_PREFIX,cookie.getValue()));
//        if (tokenValue==null){
//            log.warn("【登录校验】redis中查不到token");
//            throw new SellerAuthorizeException();
//        }
//
//
//    }
//
//
//
//
//}


package com.imooc.aspect;

import com.imooc.constant.CookieConstant;
import com.imooc.constant.RedisConstant;
import com.imooc.exception.SellerAuthorizeException;


import com.imooc.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 廖师兄
 * 2017-07-30 17:31
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.imooc.controller.Sell*.*(..))" +
            "&& !execution(public * com.imooc.controller.SellerUserController.*(..))")
    public void verify() {}

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询cookie
        Cookie cookie = null;
        try {
             cookie = CookieUtil.getCookie(request, CookieConstant.TOKEN);
        }catch(Exception e){
            throw new SellerAuthorizeException();
        }
        if (cookie == null) {
            log.warn("【登录校验】Cookie中查不到token");
           //todo
             throw new SellerAuthorizeException();
        }

        //去redis里查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKE_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】Redis中查不到token");
         //todo
             throw new SellerAuthorizeException();
        }
    }
}

