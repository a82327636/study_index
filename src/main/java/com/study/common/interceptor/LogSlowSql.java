package com.study.common.interceptor;



import org.apache.log4j.Logger;

public class LogSlowSql {
    private static final Logger logger = Logger.getLogger(LogSlowSql.class.getName());

    public static void logSql(long time, String sql) throws Throwable {
        if (time >=100) {
            logger.debug("\n执行方法:" + sql);
        }
    }
}