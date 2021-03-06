package com.study.common.filter;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

/**
 * 初始化 ApplicationContext spring加载器
 */
public class AppContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    /**
     *
     * @param applicationContext
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        // Assert.isNull(SpringAppContextHolder.applicationContext,"ApplicationContext alread holden");
        AppContextUtil.applicationContext = applicationContext;
    }

    /**
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        Assert.notNull(applicationContext, "AppContextUtil ApplicationContext  must be not null!");
        return applicationContext;
    }

    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

}
