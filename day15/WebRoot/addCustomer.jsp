<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.itcast.cn/myfn" prefix="myfn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加客户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <!-- 数据回显 -->
  <body style="text-align: center">
    <form action="/day15/servlet/AddCustomerServlet" method="post">
    	<table width="88%" border="1">
    		<tr>
    			<td>姓名</td>
    			<td>
    				<input type="text" name="name" value="${requestScope.formBean.name }"/>
    			</td>
    		</tr>
    		<tr>
    			<td>性别</td>
    			<td>
    				<!-- 
	    				<input type="radio" name="gender" value="1" checked="checked"/>男
	    				<input type="radio" name="gender" value="0"/>女 
    				-->
    				<input type="radio" name="gender" value="1" ${requestScope.formBean.gender=="1"?"checked='checked'":"" }/>男
	    			<input type="radio" name="gender" value="0" ${requestScope.formBean.gender=="0"?"checked='checked'":"" }/>女 
    			</td>
    		</tr>
    		<tr>
    			<td>生日(yyyy-MM-dd)</td>
    			<td>
    				<input type="text" name="birthday" value="${formBean.birthday }"/> ${formBean.erros.birthday }
    			</td>
    		</tr>
    		<tr>
    			<td>电话</td>
    			<td>
    				<input type="text" name="cellphone" value="${formBean.cellphone }"/>
    			</td>
    		</tr>
    		<tr>
    			<td>邮箱</td>
    			<td>
    				<input type="text" name="email" value="${formBean.email }"/>
    			</td>
    		</tr>
    		<tr>
    			<td>爱好</td>
    			<td>
    				<input type="checkbox" name="hobbies" value="吃饭" ${myfn:contains(formBean.hobbies,'吃饭')?'checked=checked':'' }/>吃饭
    				<input type="checkbox" name="hobbies" value="睡觉" ${myfn:contains(formBean.hobbies,'睡觉')?'checked=checked':'' }/>睡觉
    				<input type="checkbox" name="hobbies" value="打豆豆" ${myfn:contains(formBean.hobbies,'打豆豆')?'checked=checked':''} />打豆豆
    			</td>
    		</tr>
    		<tr>
    			<td>类型</td>
    			<td>
    				<input type="radio" name="type" value="普通客户"/>普通客户
    				<input type="radio" name="type" value="VIP"/>VIP
    			</td>
    		</tr>
    		<tr>
    			<td>描述</td>
    			<td>
    				<textarea rows="3" cols="48" name="description">${formBean.description }</textarea>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
    				<input type="submit" value="提交"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
