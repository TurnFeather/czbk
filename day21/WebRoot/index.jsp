<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文件上传</title>
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
  	<!--enctype="multipart/form-data" 决定了POST请求方式，请求正文的数据类型  -->
  	<form action="${pageContext.request.contextPath }/servlet/UploadServlet3" method="post" enctype="multipart/form-data">
  		用户名<input type="text" name="username"/><br/>
  		文件1<input type="file" name="f1"/><br/>
  		文件2<input type="file" name="f2"/><br/>
  		<input type="submit" value="登录"/>
  	</form>
  </body>
</html>
