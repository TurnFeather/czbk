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
  
  <body style="text-align: center;">
    <h1>所有客户信息列表</h1>
    <form id="f" action="${pageContext.request.contextPath}/servlet/DeleteMultiServlet" method="get">
    <table width="88%" border="0">
    	<tr>
    		<td>
    			<a href="${pageContext.request.contextPath}/addCustomer.jsp">添加</a>&nbsp;
  				<a href="javascript:DeleteMulti()">删除</a>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<c:if test="${empty page.recorders }">
    				对不起！没有任何客户信息
    			</c:if>
    			<c:if test="${not empty page.recorders }">
	    			<table width="100%" border="1">
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
	    				<c:forEach items="${page.recorders}" var="c" varStatus="vs">
	    					<tr>
	    						<td>
	    							<input type="checkbox" name="ids" value="${c.id }"/>
	    						</td>
	    						<td>${c.name }</td>
	    						<td>${c.gender=="1"?"男":"女" }</td>
	    						<td>${c.birthday}</td>
	    						<td>${c.cellphone }</td>
	    						<td>${c.email }</td>
	    						<td>${c.hobby }</td>
	    						<td>${c.type }</td>
	    						<td>${c.description }</td>
	    						<td>
	    							<a href="${pageContext.request.contextPath}/servlet/EditCustomerServlet?customerId=${c.id}">修改</a>&nbsp;&nbsp;
  									<a href="javascript:onDelete('${c.id }')">删除</a>
	    						</td>
	    					</tr>
	    				</c:forEach>
	    				<tr>
	    					<td colspan="10" align="center">
	    						第${page.pagenum }页/共${page.totalpage }页&nbsp;
	    						<a href="${pageContext.request.contextPath}/servlet/ShowAllCustomersServlet?pagenum=1">首页</a>&nbsp;
	    						<a href="${pageContext.request.contextPath}/servlet/ShowAllCustomersServlet?pagenum=${(page.pagenum-1) < 1?1:(page.pagenum-1)}">上一页</a>&nbsp;
	    						<a href="${pageContext.request.contextPath}/servlet/ShowAllCustomersServlet?pagenum=${(page.pagenum+1) > page.totalpage?page.totalpage:(page.pagenum+1)}">下一页</a>&nbsp;
	    						<a href="${pageContext.request.contextPath}/servlet/ShowAllCustomersServlet?pagenum=${page.totalpage }">末页</a>&nbsp;&nbsp;
	    					</td>
	    				</tr>
	    			</table>
    			</c:if>
    		</td>
    	</tr>
    </table>
    </form>
    <script type="text/javascript">
    	function onDelete(id)
    	{
    		var sure = window.confirm("确定删除？");
    		if (sure)
    		{
    			alert(id);
    			window.location.href = "${pageContext.request.contextPath}/servlet/DeleteServlet?customerId=" + id;
    		}
    	}
    	function DeleteMulti()
    	{
    		var idsObject = document.getElementsByName("ids");
    		var isSelected = false;
    		for (var i=0;i<idsObject.length;i++)
    		{
    			if(idsObject[i].checked)
    			{
    				isSelected = true;
    				break;
    			}
    		}
    		if (isSelected)
    		{
    			//window.location.href = "${pageContext.request.contextPath}/servlet/DeleteServlet?customerId=" + id;
    			document.getElementById("f").submit();
    		}
    		else
    		{
    			alert("请选择要删除的项");
    		}
    	}
    </script>
  </body>
</html>
