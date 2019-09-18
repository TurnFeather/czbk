<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'weather.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script id="jquery_183" type="text/javascript" class="library" src="js/jquery-1.8.3.min.js"></script>
	<script src="js/HeightMap/highcharts.js"></script>
	<script src="js/HeightMap/modules/exporting.js"></script>

	</head>  
	<body style="text-align:center;">  
		<div id="container" style="width: 100%;height: 400px" align="center"></div> 
		<script type="text/javascript">  
		$(document).ready(function() {  
		    Highcharts.setOptions({  
		        global: {  
		            useUTC: false  
		        }  
		    });  
		    var chart;  
		    chart = new Highcharts.Chart({  
		        chart: {  
		            renderTo: 'container',  
		            type: 'spline',  
		            marginRight: 10,  
		            events: {  
		                load: function() {  
		                    // set up the updating of the chart each second  
		                    var series = this.series[0];  
		                    setInterval(function() {  
		                        var x = (new Date()).getTime(), // current time  
		                            y = Math.random();  
		                        series.addPoint([x, y], true, true);  
		                    }, 5000);  
		                }  
		            }  
		        },  
		        title: {  
		            text: '<b>气温曲线图</b>'  
		        },  
		        xAxis: {  
		            type: 'datetime',  
		            tickPixelInterval: 150  
		        },  
		        yAxis: {  
		            title: {  
		                text: '单位：℃'  
		            },  
		            plotLines: [{  
		                value: 0,  
		                width: 1,  
		                color: '#808080'  
		            }]  
		        },  
		        tooltip: {  
		            formatter: function() {  
		                    return '<b>'+ this.series.name +'</b><br/>'+  
		                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+  
		                    Highcharts.numberFormat(this.y, 2);  
		            }  
		        },  
		        legend: {  
		            enabled: false  
		        },  
		        exporting: {  
		            enabled: false  
		        },  
		        series: [{  
		            name: 'Random data',  
		            data: (function() {  
		                // generate an array of random data  
		                var data = [],  
		                    time = (new Date()).getTime(),  
		                    i;  
		  
		                for (i = -19; i <= 0; i++) {  
		                    data.push({  
		                        x: time + i * 5000,  
		                        y: Math.random()  
		                    });  
		                }  
		                return data;  
		            })()  
		        }]  
		    });  
		});  
	</script>     
	</body>
	
</html>
