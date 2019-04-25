<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge charset=utf-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<% pageContext.setAttribute("ctx", request.getContextPath());%>
<c:set var="_v">?v=<%=System.currentTimeMillis()%></c:set>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
