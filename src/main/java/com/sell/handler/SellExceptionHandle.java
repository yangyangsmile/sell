//package com.imooc.handler;
//
//import SellerAuthorizeException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Map;
//
///**
// * Created by Administrator on 2017/10/5.
// */
//@ControllerAdvice
//@Slf4j
//public class SellExceptionHandle {
//    //拦截登录异常
//    @ExceptionHandler(value= SellerAuthorizeException.class)
//    public ModelAndView handlerAuthorizeException(){
//
//      log.info("【测试是否能进入此方法】");
//        return new ModelAndView("redirect:http://kunkun.natapp1.cc/seller/login");
//    }
//}
package com.sell.handler;


import com.sell.exception.SellException;
import com.sell.exception.SellerAuthorizeException;
import com.sell.util.ResultVOUtil;
import com.sell.vo.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 廖师兄
 * 2017-07-30 17:44
 */
@ControllerAdvice
public class SellExceptionHandle {

    //@Autowired
   // private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    //http://sell.natapp4.cc/sell/wechat/qrAuthorize?returnUrl=http://sell.natapp4.cc/sell/seller/login
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView   handlerAuthorizeException() {
        return new ModelAndView("redirect:".concat("http://kunkun.natapp1.cc/seller/login"));
        //        .concat(projectUrlConfig.getWechatOpenAuthorize())
        //        .concat("/sell/wechat/qrAuthorize")
          //      .concat("?returnUrl=")
            //    .concat(projectUrlConfig.getSell())
              //  .concat("/sell/seller/login")
            //System.out.print("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
          //      );

    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
}
