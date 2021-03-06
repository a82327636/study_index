package com.study.common.filter;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogTime implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(LogTime.class);

    //before the actual handler will be executed
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("urlStartTime", startTime);
        return true;
    }

    //after the handler is executed
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("urlStartTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        request.setAttribute("urlEndTime", endTime);
        //modified the exisitng modelAndView
        //  modelAndView.addObject("executeTime", executeTime);
        if (logger.isDebugEnabled()) {
            // logger.debug("\n[" + handler + "] executeTime : " + executeTime + "ms");
            logger.debug("  Request:[控制层生成]耗时:" + executeTime + "ms");
        }
    }


    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
        // TODO Auto-generated method stub

    }

}
