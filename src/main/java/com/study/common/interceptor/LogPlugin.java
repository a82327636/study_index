package com.study.common.interceptor;


import com.study.common.util.ReflectHelper;
import com.study.common.util.StringUtils;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.apache.log4j.Logger;

import javax.xml.bind.PropertyException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * mybatis 日志拦截器
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class LogPlugin implements Interceptor {
    private static final Logger logger = Logger.getLogger(LogPlugin.class.getName());
    private String dialect = "";    //数据库方言
    private String pageSqlId = ""; //mapper.xml中需要拦截的ID(正则匹配)
    public Object intercept(Invocation ivk) throws Throwable {
        System.out.println("LogPlugin1="+ivk.getTarget());
        System.out.println("LogPlugin2="+ivk.getTarget().getClass());
        if (ivk.getTarget() instanceof RoutingStatementHandler) {
            RoutingStatementHandler statementHandler = (RoutingStatementHandler) ivk.getTarget();
            BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler, "delegate");
            MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");
            BoundSql boundSql = delegate.getBoundSql();
            Object parameterObject = boundSql.getParameterObject();
            logger.debug("SQL=" + boundSql.getSql());
            if (parameterObject != null) {
                List<ParameterMapping> list = boundSql.getParameterMappings();
                    Configuration configuration = mappedStatement.getConfiguration();
                MetaObject metaObject = parameterObject == null ? null: configuration.newMetaObject(parameterObject);
                String par="";
                ArrayList<Object> parlist=new ArrayList<Object>();
                for (ParameterMapping parameterMapping : list) {
                     TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
                   if (parameterMapping.getMode() != ParameterMode.OUT) {
                        Object value;
                        String propertyName = parameterMapping.getProperty();
                        PropertyTokenizer prop = new PropertyTokenizer(propertyName);
                        if (parameterObject == null) {
                            value = null;
                        } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                            value = parameterObject;
                        } else if (boundSql.hasAdditionalParameter(propertyName)) {
                            value = boundSql.getAdditionalParameter(propertyName);
                        } else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX) && boundSql.hasAdditionalParameter(prop.getName())) {
                            value = boundSql.getAdditionalParameter(prop.getName());
                            if (value != null) {
                                value = mappedStatement.getConfiguration().newMetaObject(value).getValue(propertyName.substring(prop.getName().length()));
                            }
                        } else {
                            value = metaObject == null ? null : metaObject.getValue(propertyName);
                        }
                       parlist.add(value);
                    }
                }
                String str="";
                for(int i=0;i<parlist.size();i++){
                    str+="["+parlist.get(i)+"]";
                    if(i<parlist.size()-1){
                        str+=",";
                    }
                }
                logger.debug("parameter="+str);
            }
        }
        return ivk.proceed();
    }

    public Object plugin(Object arg0) {
        return Plugin.wrap(arg0, this);
    }

    public void setProperties(Properties p) {
        dialect = p.getProperty("dialect");
        if (StringUtils.isEmpty(dialect)) {
            try {
                throw new PropertyException("dialect property is not found!");
            } catch (PropertyException e) {
                e.printStackTrace();
            }
        }
        pageSqlId = p.getProperty("pageSqlId");
        if (StringUtils.isEmpty(pageSqlId)) {
            try {
                throw new PropertyException("pageSqlId property is not found!");
            } catch (PropertyException e) {
                e.printStackTrace();
            }
        }
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getPageSqlId() {
        return pageSqlId;
    }

    public void setPageSqlId(String pageSqlId) {
        this.pageSqlId = pageSqlId;
    }
}
