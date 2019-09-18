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
    
    <title>在线用户</title>
    
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
    <h1>在线用户</h1>
    <c:if test="${empty applicationScope.users }">
    	对不起，还没有在线用户
    </c:if>
    <c:if test="${!empty applicationScope.users}"> <!--  && applicationScope.users.size>0 -->
    	<table border="1">
    		<tr>
    			<th>序号</th>
    			<th>用户名</th>
    			<th>操作</th>
    		</tr>
	    	<c:forEach items="${applicationScope.users }" var="me" varStatus="vs" >
	    		<tr>
	    			<td>${vs.count }</td>
	    			<td>${me.key }</td>
	    			<td><a href="${pageContext.request.contextPath }/servlet/KickServlet?name=${me.key}">踢掉</a></td>
	    		</tr>
	    	</c:forEach>
    	</table>
    </c:if> 
    
  </body>
</html>
