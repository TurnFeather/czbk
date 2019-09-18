<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cn.itcast.domain.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JSTL中的c:foreach</title>
    
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
    	String[] str = {"a","b","c"};
    	pageContext.setAttribute("str", str);
     %>
     <c:forEach items="${str }" var="s">
     	${s }<br/>
     </c:forEach>
     <hr/>
     <%
     	List list = new ArrayList();
     	list.add("aa");
     	list.add("bb");
     	list.add("cc");
     	list.add("dd");
     	pageContext.setAttribute("list", list);
      %>
      <c:forEach items="${list }" var="l">
      	${l }
      </c:forEach>
      <hr/>
      <%
      	Set set = new HashSet();
      	set.add("aaa");
      	set.add("bbb");
      	set.add("ccc");
      	pageContext.setAttribute("set", set);
       %>
       <c:forEach items="${set }" var="set">
       	${set }<!-- set中没有顺序 -->
       </c:forEach><hr/>
       <%
       	Map map = new LinkedHashMap();
       	map.put("a", "aaaa");
       	map.put("b", "bbbb");
       	map.put("c", "cccc");
       	map.put("d", "dddd");
       	pageContext.setAttribute("map", map);
        %>
        <c:forEach items="${map }" var="me">
        	${me.key } == ${me.value }<br/>
        </c:forEach><hr/>
        <%
    	String[] s1 = {"a","b","c","d","e","f"};
    	pageContext.setAttribute("s1", s1);
     	%>
     	<c:forEach items="${s1 }" var="s" begin="1" end="4" step="2">
     		${s }
     	</c:forEach><hr>
     	<c:forEach begin="1" end="100" var="s">
     		${s }
     	</c:forEach><br/>
     	<%
     		List<Person> ps = new ArrayList<Person>();
     		ps.add(new Person("个服役","1",true));
     		ps.add(new Person("于睿","1",false));
     		ps.add(new Person("朱巧玲","0",false));
     		ps.add(new Person("余荣城","1",false));
     		ps.add(new Person("自身","0",true));
     		pageContext.setAttribute("ps", ps);
     	 %>
     	 <c:forEach items="${ps }" var="p">
     	 	${p.name}:${p.gender=="1"?"男":"女" }:${p.married?"已婚":"未婚" }<br/>
     	 </c:forEach>
     	 <table border="1" width="60%">
     	 	<tr>
     	 		<th>索引</th>
     	 		<th>顺序</th>
     	 		<th>第一个</th>
     	 		<th>最后一个</th>
     	 		<th>姓名</th>
     	 		<th>性别</th>
     	 		<th>婚姻状况</th>
     	 	</tr>
     	 	<c:forEach items="${ps }" var="p" varStatus="vs">
	    	 	<tr>
	    	 		<td>${vs.index }</td>
	    	 		<td>${vs.count }</td>
	    	 		<td>${vs.first }</td>
	    	 		<td>${vs.last }</td>
	    	 		<td>${p.name }</td>
	    	 		<td>${p.gender=="1"?"男":"女" }</td>
	    	 		<td>${p.married?"已婚":"未婚"}</td>
	    	 	</tr>
	    	 </c:forEach>
     	 </table>
     	 <hr/>
     	 <table border="1" width="60%">
     	 	<tr>
     	 		<th>顺序</th>
     	 		<th>姓名</th>
     	 		<th>性别</th>
     	 		<th>婚姻状况</th>
     	 	</tr>
     	 	<c:forEach items="${ps }" var="p" varStatus="vs">
	    	 	<tr bgcolor="${vs.index%2==0?"#4C6870":"#BDBDBD" }">
	    	 		<td>${vs.count }</td>
	    	 		<td>${p.name }</td>
	    	 		<td>${p.gender=="1"?"男":"女" }</td>
	    	 		<td>${p.married?"已婚":"未婚"}</td>
	    	 	</tr>
	    	 </c:forEach>
     	 </table>
  </body>
</html>
