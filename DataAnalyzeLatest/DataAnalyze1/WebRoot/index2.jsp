<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">-->
	
	<style type="text/css">
	 *{padding: 0;margin: 0;list-style：none;border: 0;}
	 .all{ width: 500px; height: 300px; margin:100px;overflow: hidden;}
	 .all ul{ position: relative;  z-index: 1; }
	 .all ul li{ position: absolute;left: 0;top: 0;}
	 .all ul div{position: absolute;left: 0;top: 0;z-index: 0}
	 .monitorclass{position: absolute;left:620px;top:100px;z-index: 2 }
	 .resultclass{position: absolute;top:420px;left:100px;}

	</style>
	
	<!-- 	<link href="css/index.css" rel="stylesheet" type="text/css">--> 
		<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
	
	</head>

	<body>
	<div class="all" id="divall" style="float:left">
		<ul>
			<div id="msg"></div>
			<li><img src="images/1.jpg" width="500" height="300"></li>
			<li><img src="images/2.jpg" width="500" height="300"></li>
			<li><img src="images/3.jpg" width="500" height="300"></li>		
		</ul>
	</div>
	
	<div class="monitorclass" id="monitor" >
	
	</div>
	
	<div class="resultclass" id="result"></div>
		
	</body>
</html>
