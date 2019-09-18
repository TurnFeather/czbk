<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>EL表达式</title>
    
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
  	<!-- 获取域中Javabean的属性的方式 -->
    <jsp:useBean id="p" class="cn.itcast.domain.Person"></jsp:useBean>
    <jsp:setProperty property="name" name="p" value="余荣城"/>
    <%=p.getName() %><br/>
    <jsp:getProperty property="name" name="p"/><br/>
    ${p.name}
    <hr/>
    <%=p.getGender() %><br/>
    <jsp:getProperty property="gender" name="p"/><br/>
    ${p.gender}
  </body>
</html>
