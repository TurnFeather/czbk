<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>所有客户信息列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align : center;">
  	<h1>客户信息列表</h1>
  	<table width="100%" border="0">
  		<tr>
  			<td>
  				<a href="${pageContext.request.contextPath}/addCustomer.jsp">添加</a>&nbsp;
  				<a href="#">删除</a>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<c:if test="${empty requestScope.cs }">
  					对不起！没有任何客户信息
  				</c:if>
  				<c:if test="${!empty requestScope.cs }">
  					<table border="100%" width="1">
  						<tr>
  							<th>选择</th>
  							<th>姓名</th>
  							<th>性别</th>
  							<th>生日</th>
  							<th>电话</th>
  							<th>邮箱</th>
  							<th>爱好</th>
  							<th>类型</th>
  							<th>描述</th>
  							<th>操作</th>
  						</tr>
  						<c:forEach items="${requestScope.cs}" var="c" varStatus="vs">
  						<tr>
  							<td>
  								<input type="checkbox" name="ids" value="${c.id }"/>
							</td>
  							<td>${c.name }</td>
  							<td>${c.gender }</td>
  							<td>${c.birthday }</td>
  							<td>${c.cellphone }</td>
  							<td>${c.email }</td>
  							<td>${c.hobby }</td>
  							<td>${c.type }</td>
  							<td>${c.description  }</td>
  							<td>
  								<a href="#">修改</a>&nbsp;&nbsp;
  								<a href="#">删除</a>
  							</td>
  						</tr>
  						</c:forEach>
  					</table>
  				</c:if>
  			</td>
  		</tr>
  	</table>
  </body>
</html>
