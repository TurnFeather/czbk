<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>EL的表达式的逻辑运算</title>
    
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
  	<jsp:useBean id="p" class="cn.itcast.domain.Person"></jsp:useBean>
    ${empty p }<br/>
    ${empty "" }
    <hr/>
    <%
    	List list = new ArrayList();
    	list.add("aaa");
    	pageContext.setAttribute("list", list);
     %>
     ${empty list }
     <hr/>
     <%
     	//session.setAttribute("user", "yrc");
      %>
      ${empty user?"请登录":"欢迎你" }${user }
      <hr/>
      <%
      	//0 女 1 男
      	pageContext.setAttribute("gender", "1");
       %>
       ${gender=="0"?"女":"男" }
  </body>
</html>
