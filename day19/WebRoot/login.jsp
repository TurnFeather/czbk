<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%
    	Locale locale = request.getLocale();
    	ResourceBundle rs = ResourceBundle.getBundle("cn.itcast.resources.msg", locale);
     %>
    <title><%=rs.getString("jsp.login.title") %></title>
    
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
  <form>
	    <%=rs.getString("jsp.login.username")%>:<input type="text" name="username"/><br/>
	    <%=rs.getString("jsp.login.password")%>:<input type="password" name="password"/><br/>
	    <input type="submit" value='<%=rs.getString("jsp.login.submit")%>'/>
    </form>
  </body>
</html>
