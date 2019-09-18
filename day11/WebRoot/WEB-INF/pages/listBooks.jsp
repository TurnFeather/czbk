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
    
    <title>所有书籍列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align:center">
    	<br/>
    	<h1>本站有以下好书</h1>
    	<table border="1" width="88%">
    		<tr>
	    		<th>序号</th>
	    		<th>ISBN</th>
	    		<th>书名</th>
	    		<th>作者</th>
	    		<th>单价</th>
	    		<th>描述</th>
	    		<th>购买</th>
    		</tr>
    		<c:forEach items="${books }" var="me" varStatus="vs">
    			<tr bgcolor="${vs.count%2==0?"#CCCCCC":"#6081A3" }">
    				<td>${vs.count }</td>
    				<td>${ me.value.isbn}</td>
    				<td>${ me.value.name}</td>
    				<td>${ me.value.author}</td>
    				<td>${ me.value.price}</td>
    				<td>${ me.value.description}</td>
    				<td style="text-align:right">[<a href="${ pageContext.request.contextPath}/servlet/BuyServlet?bookId=${me.key}">购买</a>]</td>
    			</tr>
    		</c:forEach>
    	</table>
    	<a href="${ pageContext.request.contextPath}/servlet/ShowCartServlet">查看购物车</a>
  </body>
</html>
