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
	<style type="text/css">
	table {

     border-collapse: collapse;

     font-family: Futura, Arial, sans-serif;

	}

	caption {

     	font-size: larger;

    	 margin: 1em auto;

		}

		th,td {

     padding: .65em;

		}

		th {

     background: #555 nonerepeat scroll 0 0;

   border: 1px solid #777;

   color: #fff;

}

td {

     border: 1px solid#777;

}
	</style>
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
    var y1= [];//
    var xtext = [];//X轴TEXT
    var xs=[];
    var color = ["gray","pink","red","blue","yellow","green","#fff"];
   
    $.ajax({
        type:'get',
        url:'AcdPreAction.action',//请求数据的地址
        success:function(data){
      //   var prilist = '${truelist}';
      //   alert(prilist);
            var json = eval("("+data+")");
           // alert(json.prilist.length);
            var s = 1;
            for(var key in json.truelist){
            	
               json.truelist[key].y = json.truelist[key].num;
              
              // json.prilist[key].y = json.prilist[key].num;
            //    xs[key] = json.prilist[key].acdYear;//给X轴TEXT赋值
              	
            //  json.truelist[key].color= color[3];
            }
            for(var key in json.prilist){
            	
           //    json.truelist[key].y = json.truelist[key].num;
               json.prilist[key].y = json.prilist[key].num;
                xs[key] = json.prilist[key].acdYear;//给X轴TEXT赋值
              	
             // json.prilist[key].color= color[2];
            }
                chart.series[0].setData(json.truelist);//数据填充到highcharts上面
                chart.series[1].setData(json.prilist);
        },
        error:function(e){
        } 
    });
    var chart = new Highcharts.Chart({
        chart:{
            renderTo:'container',
            type:'column' //显示类型 柱形
        
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
            name:"发生事故"
        },{name:"预测事故"}]
    });
});
    </script>
  </body>
</html>
