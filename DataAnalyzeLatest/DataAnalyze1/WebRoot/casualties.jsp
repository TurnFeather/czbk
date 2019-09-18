<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>伤亡人数</title>
    
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
	<script src="js/highcharts-3d.js"></script>
	<script src="js/HeightMap/modules/exporting.js"></script>
	<script src="js/HeightMap/modules/data.js"></script>
	
  </head>
  
  <body>
  <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<script>
  $(function(){
    var x = [];//X轴
    var y = [];//Y轴
    var xtext = [];//X轴TEXT
    var xs=[];
    var color = ["gray","pink","red","blue","yellow","green","#fff"];

    $.ajax({
        type:'get',
        url:'Casualty.action',//请求数据的地址
        success:function(data){
            var json = eval("("+data+")");
            var s = 1;
            for(var key in json.list){
            	
                json.list[key].y = json.list[key].swrs;
            
                xs[key] = json.list[key].acdYear;//给X轴TEXT赋值
              	
              //  json.list[key].color= color[key];
            }
                chart.series[0].setData(json.list);//数据填充到highcharts上面
        },
        error:function(e){
        } 
    });
    var chart = new Highcharts.Chart({
        chart:{
            renderTo:'container',
           type: 'column',
     
        },
        title:{
            text:'事故伤亡人数统计图' //图表的标题
        },
        xAxis:{
            categories:xs
        },
        yAxis:{
            title:{
                text:'人数' //Y轴的名称
            },
        },
          plotOptions: {
            series: {
                colorByPoint: true /////////////////////////////////
            }
        },
        series:[{
            name:"伤亡人数"
        }]
    });
});
</script>
  </body>
</html>
