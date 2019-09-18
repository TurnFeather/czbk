<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>XX论坛</title>
    
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
    <c:if test="${sessionScope.user==null}">
    	<a href="${pageContext.request.contextPath}/autologin/login.jsp">登录</a>
    </c:if>
    <c:if test="${sessionScope.user!=null}">
    	欢迎你${sessionScope.user.nick }
    </c:if>
    <hr/>
   	 网站主页<br/>
   	 <a href="${pageContext.request.contextPath}/autologin/1.jsp">其它页面</a>
  </body>
</html>
