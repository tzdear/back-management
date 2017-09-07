package com.ly.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

/**
* @ClassName: WbExceptionHandler
* @Description: 
* @author linyan
* @date 2017年7月15日 下午4:17:24
*
*/
public class WbExceptionHandler extends DefaultHandlerExceptionResolver {
    private static final Logger logger = Logger.getLogger(WbExceptionHandler.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        if (ex instanceof WbRuntimeException) {
            //判断如果是属于我们自定义的runtime异常，就是返回json格式的错误信息：设置response的响应错误码，添加json格式的错误信息
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            ModelAndView modelAndView = new ModelAndView();
//            modelAndView.addObject("error", ex.getMessage());
//            modelAndView.setViewName("/sys/index");
//            return modelAndView;
//        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                //重定向到error的controller中
                response.sendRedirect(request.getContextPath() + "/sys/index");
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
            return new ModelAndView();
//        }

    }

}