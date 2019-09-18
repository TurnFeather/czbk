<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.itcast.domain.Person" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jstl标签库</title>
    
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
  		pageContext.setAttribute("data", "hello<hr/>");
  	 %>
  	 <br/>--------------------c:out输出内容到页面上-------------------<br/>
   	 <c:out value="${data }" escapeXml="true"></c:out><br/>
     <c:out value="${data }" default="木有值"></c:out><br/>
     <br/>--------------------c:set将某些对象绑定到域中-------------------<br/>
     <c:set var="s" value="hello itcast" scope="page"></c:set>
     ${s }
     <br/>--------------------c:set设置javaBean的属性值-------------------<br/>
     <jsp:useBean id="p1" class="cn.itcast.domain.Person" scope="page"></jsp:useBean>
     ${p1.name}
     <%--
    	 如果“target”表达式为null，容器会抛出一个异常。
		如果“target”表达式不是一个Map或bean，容器会抛出一个异常。
		如果“target”表达式是一个bean，但是这个bean没有与“property”匹配的成员字段，容器会抛出一个异常。
      --%>
     <c:set target="${p1 }" property="name" value="余荣城" ></c:set>
     <%--
     	相当于p1.setName("余荣城");
      --%>
     ${p1.name}
     <br/>--------------------c:set设置Map对象的key和value-------------------<br/>
     <%
     	pageContext.setAttribute("map", new HashMap());
      %>
      <c:set value="I am value" property="I am key" target="${map }"></c:set>
      <c:forEach items="${map}" var="me">
      	${me.key }=${me.value }
      </c:forEach><br/>
      <c:catch var="e">	<!-- e就是引用异常对象的名称 -->
      	<%=1/0 %>
      </c:catch>
      <%--
      <%
      	try{
      		System.out.println(1/0);
      	}catch(Exception e){
      		//相当于这里
      	}--%>
      	${e.message }
      	<hr/>
      	<c:set var="p1" value="abc" scope="page" property="name"></c:set>
      	${p1}
      	<br/>--------------------c:remove标签用于删除各种Web域中的属性-------------------<br/>
      	<c:remove var="p1"/>${p1 }
      	<br/>--------------------c:choose c:when c:otherwise标签用于删除各种Web域中的属性-------------------<br/>
      	<br/>--------------------c:choose无法单独使用，只是作为when和otherwise的父标签存在-------------------<br/>
      	<br/>--------------------c:when和c:otherwise必须出现在c:choose中-------------------<br/>
      	<br/>--------------------c:choose可以只有c:when但不可以只有c:otherwise-------------------<br/>
      	<br/>--------------------c:choose可以有多个c:when但只能有一个c:otherwise或者没有。有c:otherwise必须出现在c:when后边------------------<br/>
      	<br/>--------------------c:import动态包含，如同jsp:include-------------------<br/>
      	<br/>--------------------c:url组织url字符串，不指定var属性会把value的值直接打到页面上-------------------<br/>
      	<c:url value="/example/result.jsp" var="uu" scope="page">
      		<c:param name="content" value="hello"></c:param>
      	</c:url>
      	<a href="${uu }">萌点</a>
  </body>
</html>
