<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '1.jsp' starting page</title>
    
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
  <jsp:useBean id="p" class="cn.itcast.domain.Person" scope="page"></jsp:useBean>
  <!-- 设置javabean的各种属性 -->
  <%-- 
  	<%String s = "fuck";%>
    
    <jsp:setProperty property="name" name="p" value="<%=s %>"/>
    <jsp:setProperty property="gender" name="p" value="male"/>
    <jsp:setProperty property="married" name="p" value="true"/>
    <jsp:setProperty property="birthday" name="p" value="<%=new Date() %>"/>
    <%=p.getName() %><br/>
    <%=p.getGender() %><br/>
    <%=p.isMarried() %><br/>
    <%=p.getBirthday() %><br/>
   --%>
    <!--------------- 利用请求参数名设置javabean的各种属性 -------------->
    <hr/>--------------- 利用请求参数名设置javabean的各种属性 --------------
    <%-- 
    <jsp:setProperty property="name" name="p" param="name"/>
    <jsp:setProperty property="gender" name="p" param="gender"/><br/>
    <%=p.getName() %><br/>
    <%=p.getGender() %><br/>--%>
    <!-- http://localhost:8080/day10/1.jsp?name=yurongcheng&gender=male     请求参数名和属性名一样，就可以使用通配符* -->
    <jsp:setProperty property="*" name="p"/><br/>
    获取属性<br/>
    <jsp:getProperty property="name" name="p"/>
    <jsp:getProperty property="gender" name="p"/>
    <jsp:getProperty property="married" name="p"/>
  </body>
</html>
