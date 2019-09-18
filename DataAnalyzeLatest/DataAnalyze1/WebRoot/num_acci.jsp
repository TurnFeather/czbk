<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'num_acci.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <script id="jquery_183" type="text/javascript" class="library" src="js/jquery-1.8.3.min.js"></script>
	<script src="js/HeightMap/highcharts.js"></script>
	<script src="js/HeightMap/modules/exporting.js"></script>
	<script src="js/HeightMap/modules/data.js"></script>

  </head>
  
  <body>
 
   <div id="container" style="min-width:400px;height:400px"></div>
 
  <script>
  $(function(){
    var x = [];//X轴
    var y = [];//Y轴
    var xtext = [];//X轴TEXT
    var xs=[];
    var color = ["gray","pink","red","blue","yellow","green","#fff"];

    $.ajax({
        type:'get',
        url:'DataAccidentAction.action',//请求数据的地址
        success:function(data){
            var json = eval("("+data+")");
            
            var s = 1;
            for(var key in json.truelist){
            	
               json.truelist[key].y = json.truelist[key].num;
            
                xs[key] = json.truelist[key].acdYear;//给X轴TEXT赋值
              	
             // json.truelist[json.truelist.length-1].color= color[2];
            }
                chart.series[0].setData(json.truelist);//数据填充到highcharts上面
        },
        error:function(e){
        } 
    });
    var chart = new Highcharts.Chart({
        chart:{
            renderTo:'container',
            type:'pie' //显示类型 柱形
          // type:'line' //显示类型 柱形
        },
        title:{
            text:'事故发生统计图' //图表的标题
        },
        xAxis:{
            categories:xs
        },
        yAxis:{
            title:{
                text:'次数' //Y轴的名称
            },
        },
      
        series:[{
            name:"事故次数"
        }]
    });
});
    </script>
  </body>
</html>
