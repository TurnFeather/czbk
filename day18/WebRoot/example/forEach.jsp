<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.itcast.cn/jsp/tag/example" prefix="eitcast" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>简单模拟forEach，简单版本</title>
    
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
    <%
    	List list = new ArrayList();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	pageContext.setAttribute("list", list);
     %>
     <eitcast:forEach1 items="${list }" var="s">
     	${s }<br/>
     </eitcast:forEach1>
     ${list }
  </body>
</html>