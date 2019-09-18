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
    
    <title>My JSP 'forEach2.jsp' starting page</title>
    
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
    	list.add("list1");
    	list.add("list2");
    	list.add("list3");
    	pageContext.setAttribute("list", list);
     %>
     <eitcast:forEach2 items="${list }" var="s">
     	${s }<br/>
     </eitcast:forEach2>
     <hr/>
     <%
    	Set set = new HashSet();
    	set.add("set1");
    	set.add("set2");
    	set.add("set3");
    	pageContext.setAttribute("set", set);
     %>
     <eitcast:forEach2 items="${set }" var="s">
     	${s }<br/>
     </eitcast:forEach2>
     <hr/>
     <%
    	Map map = new HashMap();
    	map.put("a", "map1");
    	map.put("b", "map2");
    	map.put("c", "map3");
    	pageContext.setAttribute("map", map);
     %>
     <eitcast:forEach2 items="${map }" var="me">
     	${me.key }=${me.value }<br/>
     </eitcast:forEach2>
     <hr/>
     <%
    	String strs[] = {"a","b","c"};
    	pageContext.setAttribute("strs", strs);
     %>
     <eitcast:forEach2 items="${strs }" var="s">
     	${s }<br/>
     </eitcast:forEach2>
     <hr/>
      <%
    	int ii[] = new int[]{1,2,3}; 
    	pageContext.setAttribute("ii", ii);
     %>
     <eitcast:forEach2 items="${ii }" var="s">
     	${s }<br/>
     </eitcast:forEach2>
     
  </body>
</html>
