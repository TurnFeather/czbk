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
    
    <title>显示购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body align="center">
  	<h1>您购买的商品如下</h1>
  	<c:if test="${empty sessionScope.cart.items }">
  		对不起！您还没有购买任何物品
  	</c:if>
  	<c:if test="${!empty sessionScope.cart.items }">
  		<table border="1" width="88%">
  			<tr>
  				<th>序号</th>
  				<th>书名</th>
  				<th>单价</th>
  				<th>数量</th>
  				<th>小计</th>
  				<th>操作</th>
  			</tr>
  			<c:forEach items="${sessionScope.cart.items}" var="me" varStatus="vs">
  				<tr>
  					<td>${vs.count}</td>
  					<td>${me.value.book.name}</td>
  					<td>${me.value.book.price}</td>
  					<td><input type="text" name="number" size="3" value="${me.value.num }" onchange="changeNum(this,'${me.key }','${me.value.num }')"/></td><!-- this代表text对象本身 -->
  					<td>${me.value.price }</td>
  					<td>
  						[<a href="javascript:DelOne('${me.key }')">删除</a>]
  					</td>
  				</tr>
  			</c:forEach>
  			<tr>
  				<td colspan="2">[<a href="javascript:DelAll()">清空购物车</a>]</td>
  				<td colspan="2" align="right">总计</td>
  				<td colspan="2">${sessionScope.cart.price }元</td>
  			</tr>
  		</table>
  	</c:if>
  	<a href="${pageContext.request.contextPath }">继续购物</a>
  	<script type="text/javascript">
  		function changeNum(inputObj,bookId,oldNum){
  			var newnum = inputObj.value;	//新的数量
  			var sure = window.confirm("确定要把数量改为" + newnum + "吗？");	//返回值
  			if (sure==true){
  				//alert("提交给服务器去处理");
  				window.location.href="${pageContext.request.contextPath}/servlet/ChangeNumServlet?bookId="+bookId+"&newnum=" + newnum;
  			}
  			else
  			{
  				//改回原来的值
  				inputObj.value = oldNum;
  			}
  		}
  		function DelOne(bookId)
  		{
  			var sure = window.confirm("确定要删除这一项吗？");	//返回值
  			if (sure)
  			{
  				window.location.href="${pageContext.request.contextPath}/servlet/DelOneServlet?bookId="+bookId;
  			}
  		}
  		function DelAll()
  		{
  			var sure = window.confirm("确定要删除所有吗？");	//返回值
  			if (sure)
  			{
  				window.location.href="${pageContext.request.contextPath}/servlet/DelAllServlet";
  			}
  		}
  	</script>
  	${message }
  </body>
</html>
