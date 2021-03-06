package com.study.common.filter;

import org.apache.ibatis.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.web.util.Log4jWebConfigurer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;


public class Log4JConfig implements ServletContextListener {
    public Log4JConfig() {
    }

    public void contextInitialized(ServletContextEvent event) {
        String fileseparator = File.separator;
        String path = event.getServletContext().getRealPath("/") + fileseparator+ ("WEB-INF");
        System.setProperty("logs.home", path);
        String log = path + fileseparator + "etc" + fileseparator + "log4j.properties";
        Logger logger = Logger.getLogger(Log4JConfig.class.getName());
        Log4jWebConfigurer.initLogging(event.getServletContext());
        LogFactory.useLog4JLogging();
        logger.info("path-----"+path);
        logger.info("----------初始化LOG日志成功------------------");
    }

    public void contextDestroyed(ServletContextEvent event) {
        Log4jWebConfigurer.shutdownLogging(event.getServletContext());
    }
}
