package com.study.common.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
* 解析xml文档时异常
* @author: wuwei
* @since: 2015年6月26日  下午4:27:05
* @history:
*/
public  class AuthExcepiton extends RuntimeException {
   private static Log logger = LogFactory.getLog(AuthExcepiton.class);
   private String msg;

   public void setMsg(String msg) {
       this.msg = msg;
   }

   public String getMsg() {
       return msg;
   }

   public AuthExcepiton(String msg){
       super(msg);
   }

   public AuthExcepiton(Throwable cause) {
       super(cause);
       StackTraceElement[] stes = cause.getStackTrace();
       StackTraceElement lastSte = stes[0];
       logger.error("异常发生  类名：" + lastSte.getClassName() + "，方法名： " + lastSte.getMethodName() +"，行号: " + lastSte.getLineNumber()+"，异常信息：",cause);
   }
}
