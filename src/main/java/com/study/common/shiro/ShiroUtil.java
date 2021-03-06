package com.study.common.shiro;


import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;



public class ShiroUtil {
    private static Logger logger = Logger.getLogger(ShiroUtil.class);

    public static ShiroUser getShiroUser() {
        Subject user = SecurityUtils.getSubject();
        return (ShiroUser) user.getPrincipal();
    }


    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static ShiroUser getUser() {
        return getShiroUser();
    }

    public static void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (null != session) {
                logger.debug("set Session=[" + session.getTimeout() + "]ms");
                logger.debug(key + "=" + value);
                session.setAttribute(key, value);
            }
        }
    }

    public static Object getSession(Object key) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (null != session) {
                return session.getAttribute(key);
            }
        }
        return null;
    }

    public static void removeSession(Object key) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (null != session) {
                logger.debug("remove=" + key);
                session.removeAttribute(key);
            }
        }
    }
}
