<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.itcast.domain.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>EL的11大隐式对象</title>
    
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
    ${pageContext}<br/>
    <!-- 在EL中得到HttpServletRequest对象 -->
    ${pageContext.request }<br/>
    
    <!-- 在EL中获取当前应用的名称 -->
    ${pageContext.request.contextPath }<br/>
    
    <!-- 获取HttpServiceResponse采用的编码 -->
    ${pageContext.response.characterEncoding }
    
    <br/>*************************pageScope内置对象*************************<br/>
    <%
    	pageContext.setAttribute("pp", "ppp");
    	pageContext.setAttribute("p", new Person("余荣城","男",false),PageContext.REQUEST_SCOPE);
     %>
     ${pageScope.pp }<br/>
     ${requestScope.p.name }
     <hr/>
     <%
     	pageContext.setAttribute("user", "abc");
     	Person person = new Person("朱巧玲","女",true);
     	session.setAttribute("user", person);
      %>
      ${empty sessionScope.user?"请登录":"欢迎您"}${sessionScope.user.name }
      <hr/>
      ${param.username }==${param.password }<br/> <!-- http://localhost:8080/day10/4.jsp?username=abc&username=zhansan&password=123 -->
      ${paramValues }<br/>
      ${paramValues.username[0] }==${paramValues.username[1] }==${paramValues.password[0] }<br/>
      <hr/>
      ${headerValues.accept[0] }<br/>哈哈哈
      ${headerValues.accept[1] }
      <hr/>
      <!-- 取JSESSIONID这个cookie的名字 -->
      ${cookie['JSESSIONID'].name}<br/>
      ${cookie.JSESSIONID.value}
      <hr/>
      ${initParam.encoding }
  </body>
</html>
