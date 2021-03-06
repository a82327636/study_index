package com.study.common.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 自定义的运行时异常类
 * 
 * @version V1.0
 * @author yhq [unicorn668@163.com] 创建时间：2012-11-2 上午10:23:16
 */
public class SysRunException extends RuntimeException {
	private static final long serialVersionUID = 8047908572920298917L;

	private static Log logger = LogFactory.getLog(SysRunException.class);

	/**
	 * 一般用此异常传递一些信息(DEBUG)
	 * 
	 * @param message
	 */
	public SysRunException(String message) {
		super(message);
		logger.debug(message);
	}

	/**
	 * 一般用此异常传递一些信息
	 *
	 *@param message 信息
	 *@param isToError true时将日志加入到error级别中
	 */
	public SysRunException(String message, boolean isToError) {
		super(message);

		if (isToError) {
			logger.error(message);
		} else {
			logger.debug(message);
		}
	}

	/**
	 * 传递异常信息及异常对象
	 *
	 *@param message
	 *@param cause
	 */
	public SysRunException(String message, Throwable cause) {
		super(message, cause);
		StackTraceElement[] stes = cause.getStackTrace();
		StackTraceElement lastSte = stes[0];
		logger.error("异常发生  类名：" + lastSte.getClassName() + "，方法名： " + lastSte.getMethodName() +"，行号: " + lastSte.getLineNumber()+"，异常信息：",cause);
	}

	/**
	 * 直接传递异常对象
	 *
	 *@param cause
	 */
	public SysRunException(Throwable cause) {
		super(cause);
		StackTraceElement[] stes = cause.getStackTrace();
		StackTraceElement lastSte = stes[0];
		logger.error("异常发生  类名：" + lastSte.getClassName() + "，方法名： " + lastSte.getMethodName() +"，行号: " + lastSte.getLineNumber()+"，异常信息：",cause);
	}
	
	/**
	 * 仅打印异常日志，不抛出异常
	 * @param cause
	 * @param onlyLog
	 */
	public SysRunException(Throwable cause,boolean onlyLog){
		
		StackTraceElement[] stes = cause.getStackTrace();
		StackTraceElement lastSte = stes[0];
		logger.error("异常发生  类名：" + lastSte.getClassName() + "，方法名： " + lastSte.getMethodName() +"，行号: " + lastSte.getLineNumber()+"，异常信息：",cause);
	}
}
