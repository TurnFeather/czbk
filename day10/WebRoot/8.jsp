<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '8.jsp' starting page</title>
    
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
  		pageContext.setAttribute("result", true);
  	 %>
    <c:if test="${result }">
    	真的<br/>
    </c:if>
    <%
    	session.setAttribute("user", "玲玲姐");
     %>
     <c:if test="${sessionScope.user==null} }">
     	对不我，请登录
     </c:if>
     <c:if test="${sessionScope.user!=null }">
     	欢迎您,${sessionScope.user }<hr/>
     </c:if>
     <%
     	List list = new ArrayList();
     	session.setAttribute("cart", list);
      %>
     <c:if test="${empty sessionScope.cart }">
     	对不起，您还未曾购物<br/>
     </c:if>
     <c:if test="${not empty sessionScope.cart }">
     	您购买的东西如下<br/>
     </c:if>
     <c:if test="${empty sessionScope.cart}" var="result" scope="page"></c:if>
     ${pageScope.result }<hr/>
  </body>
</html>
