<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    </head>
  <body>
       入门的路径:<br>  
      <a href="${pageContext.request.contextPath}/primer/helloWorldAction.action">HelloWorld</a><br> 
      
    测试action名称的搜索顺序：<br/>
    <a href="${pageContext.request.contextPath}/primer/primer/primer/helloWorldAction.action">HelloWorld</a><br> 
    <a href="${pageContext.request.contextPath}/primer/primer/helloWorldAction.action">HelloWorld</a><br> 
    <a href="${pageContext.request.contextPath}/primer/helloWorldAction.action">HelloWorld</a><br> 
  没有为action指定class<br/>
   <a href="${pageContext.request.contextPath}/primer/ActionNoClass.action">HelloWorld</a><br> 
   没有指定的action<br/>
   <a href="${pageContext.request.contextPath}/primer/UserAction.action">HelloWorld</a><br> 
  无后缀名<br/>
   <a href="${pageContext.request.contextPath}/primer/helloWorldAction">HelloWorld</a><br> 
  不按要求后缀名<br/>
   <a href="${pageContext.request.contextPath}/primer/helloWorldAction.abc">HelloWorld</a><br> 
   添加新的后缀名<br/>
   <a href="${pageContext.request.contextPath}/primer/helloWorldAction.ddd">HelloWorld</a><br> 
  </body>
</html>
