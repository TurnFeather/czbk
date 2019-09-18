<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%--<%
    	Locale locale = request.getLocale();
    	ResourceBundle rs = ResourceBundle.getBundle("cn.itcast.resources.msg", locale);
     --%>
     <fmt:setBundle basename="cn.itcast.resources.msg" var="bundle" scope="page"/>
     <fmt:setLocale value="${pageContext.request.locale}"/>
    <title>
    	<fmt:message key="jsp.login.title" bundle="${bundle }" ></fmt:message>
    </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form>
	    <fmt:message key="jsp.login.username" bundle="${bundle }" ></fmt:message>:<input type="text" name="username"/><br/>
	    <fmt:message key="jsp.login.password" bundle="${bundle }" ></fmt:message>:<input type="password" name="password"/><br/>
	    <input type="submit" value='<fmt:message key="jsp.login.submit" bundle="${bundle }" ></fmt:message>'/>
    </form>
  </body>
</html>
