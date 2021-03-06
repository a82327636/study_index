package com.study.common.filter;



import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * httpservlet 初始化
 */
public class InitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Logger logger = null;

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, java.io.IOException {
        doPost(httpServletRequest, httpServletResponse);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        logger.info("ServletInit" + request.getServletPath());
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String act = request.getParameter("act");
        logger.debug(act);
        out.write(act);
        out.flush();
    }


    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        logger = Logger.getLogger(InitServlet.class.getName());
        logger.info("----------初始化ApplicationContext开始------------------");
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        logger.info("----------初始化ApplicationContext完成------------------");
        logger.info("----------初始化缓存Redis完成------------------");
        logger.info("----------初始化慧营销WEB服务器启动完成------------------");
    }
}
