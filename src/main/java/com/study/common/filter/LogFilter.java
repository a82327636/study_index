package com.study.common.filter;



import org.apache.log4j.Logger;
import org.springframework.util.StopWatch;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: bxl
 */
public class LogFilter extends HttpServlet implements Filter {
    private static final long serialVersionUID = 1L;
    private Logger logger = Logger.getLogger(LogFilter.class.getName());
    private static final String[] INHERENT_ESCAPE_URIS = {"/common",
            "/static", "/view", "/favicon", ".css",
            "/getCaptcha", "JSESSIONID=", ".js", ".png", ".jpg"};//拦截匹配不输出的


    @SuppressWarnings({"unchecked"})
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        String url = request.getRequestURI();
        StopWatch stopWatch = new StopWatch(request.getRequestURI() + System.currentTimeMillis());
        stopWatch.start();
        arg2.doFilter(request, response);
        stopWatch.stop();

        if (!isURILogin(url, request)) {
            Long timeLength = stopWatch.getTotalTimeMillis();
            if (request.getAttribute("urlEndTime") != null) {
                long endTime = (Long) request.getAttribute("urlEndTime");
                logger.debug("Request:[JSP生成页面]耗时:" + (System.currentTimeMillis() - endTime) + "ms");
            }
            logger.debug("Request:[" + url + "]耗时:" + timeLength + "ms");
            request.removeAttribute("urlEndTime");
            request.removeAttribute("urlStartTime");
        }

    }

    //③ 当前URI资源是否需要登录才能访问
    private boolean isURILogin(String requestURI, HttpServletRequest request) {
        if (request.getContextPath().equalsIgnoreCase(requestURI) || (request.getContextPath() + "/").equalsIgnoreCase(requestURI))
            return true;
        for (String uri : INHERENT_ESCAPE_URIS) {
            if (requestURI != null && requestURI.indexOf(uri) >= 0) {
                return true;
            }
        }
        return false;
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}
