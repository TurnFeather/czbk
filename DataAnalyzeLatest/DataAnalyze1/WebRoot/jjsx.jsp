<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>事故经济损失</title>
    
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
 <div id="container"></div>
<div id="sliders">
    <table>
        <tr>
            <td>Alpha Angle</td>
            <td><input id="alpha" type="range" min="0" max="45" value="15"/> <span id="alpha-value" class="value"></span></td>
        </tr>
        <tr>
            <td>Beta Angle</td>
            <td><input id="beta" type="range" min="-45" max="45" value="15"/> <span id="beta-value" class="value"></span></td>
        </tr>
        <tr>
            <td>Depth</td>
            <td><input id="depth" type="range" min="20" max="100" value="50"/> <span id="depth-value" class="value"></span></td>
        </tr>
    </table>
</div>
    <script>
 $(function () {
  var x = [];//X轴
    var y = [];//Y轴
    var xtext = [];//X轴TEXT
    var xs=[];
    var color = ["gray","pink","red","blue","yellow","green","#fff"];

    $.ajax({
        type:'get',
        url:'FinLoss.action',//请求数据的地址
        success:function(data){
            var json = eval("("+data+")");
            var s = 1;
            for(var key in json.list){
            	
                json.list[key].y = json.list[key].jjsx;
            
                xs[key] = json.list[key].acdYear;//给X轴TEXT赋值
              	
              //  json.list[key].color= color[key];
            }
                chart.series[0].setData(json.list);//数据填充到highcharts上面
        },
        error:function(e){
        } 
    });
    // Set up the chart
    var chart = new Highcharts.Chart({
        chart: {
            renderTo: 'container',
            type: 'column',
            options3d: {
                enabled: true,
                alpha: 15,
                beta: 15,
                depth: 50,
                viewDistance: 25
            }
        },
        title: {
            text: '事故直接经济损失'
        },
          xAxis:{
            categories:xs
        },
         yAxis:{
            title:{
                text:'万元' //Y轴的名称
            },
        },
        subtitle: {
            
        },
        plotOptions: {
            column: {
                depth: 25
            }
        },
        series: [{
          tooltip: {
                valueSuffix: ' 万元'
         },
        name:'经济损失'
          
        }]
    });
    function showValues() {
        $('#alpha-value').html(chart.options.chart.options3d.alpha);
        $('#beta-value').html(chart.options.chart.options3d.beta);
        $('#depth-value').html(chart.options.chart.options3d.depth);
    }
    // Activate the sliders
    $('#sliders input').on('input change', function () {
        chart.options.chart.options3d[this.id] = this.value;
        showValues();
        chart.redraw(false);
    });
    showValues();
});
/* $(function(){
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
            for(var key in json.list){
            	
                json.list[key].y = json.list[key].num;
            
                xs[key] = json.list[key].acdYear;//给X轴TEXT赋值
              	
                json.list[key].color= color[key];
            }
                chart.series[0].setData(json.list);//数据填充到highcharts上面
        },
        error:function(e){
        } 
    });
    var chart = new Highcharts.Chart({
        chart:{
            renderTo:'container',
            type:'line' //显示类型 柱形
        
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
});*/
    </script>
    
  </body>
</html>
