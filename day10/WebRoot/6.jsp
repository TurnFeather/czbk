<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '6.jsp' starting page</title>
    
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
    ${fn:contains("Tomcat","cat") }<br/>
    ${fn:substring("shit",3,100) }<br/>
    ${fn:split("www.itcast.cn",".")[0] }${fn:split("www.itcast.cn",".")[1] }${fn:split("www.itcast.cn",".")[2] }<br/>
    ${fn:split("2013-04/26","-/")[0] }<br/>
    ${fn:split("2013-04/26","-/")[1] }<br/>
    ${fn:split("2013-04/26","-/")[2] }<br/>
    
    <%
    	pageContext.setAttribute("h", "<h1>hahah</h1>");
     %>
     ${fn:escapeXml(h) }
  </body>
</html>
