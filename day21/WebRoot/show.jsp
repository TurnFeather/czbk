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
    
    <title>所有资源</title>
    
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
    	<center><h1>本站有以下资源</h1></center>
    	<table align="center" border="1" width="80%">
    		<tr>
    			<th>序号</th>
    			<th>文件名</th>
    			<th>点击下载</th>
    		</tr>
    		<c:forEach items="${resource}" var="entry" varStatus="vs">
    			<c:url value="/servlet/DownloadServlet" var="url">
    				<c:param name="fileName" value="${entry.key }"></c:param>
    			</c:url>
    			<tr>
    				<td>${vs.count }</td>
    				<td>${entry.value }</td>
    				<td><a href="${url}">下载</a></td>
    			</tr>
    		</c:forEach>
    	</table>
  </body>
</html>
