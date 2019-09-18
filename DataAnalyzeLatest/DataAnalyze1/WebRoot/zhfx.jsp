<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>综合分析</title>
    
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
  </head>
  
  <body>
   <div id="container" style="min-width:400px;height:400px"></div>
   <script>
   

  
 
  //alert(ret);
  //alert(a);
  var a= '${list}';
  
//  alert(b);
  var strfin= new Array(); 
  var stracinum=new Array();
  var strCas= new Array();
  var strYear = new Array();
  
  var ret = splitX(a);
  var YearValue= new Array();
  var CasValue=new Array();
  var acinumValue= new Array();
  var finValue= new Array();
  //alert(ret);
    for (var i = 0; i < ret.length; i++)
    {
    	//	alert(ret[i]);
    	strs=ret[i].split(",");
    	strfin[i]=strs[0];
    	stracinum[i]=strs[1];
    	strCas[i]=strs[2];
    	strYear[i]=strs[3];
	}

	var c=strCas;

	for(var j=0; j<strfin.length; j++){
		
			var sfin = new Array();
			var sacinum= new Array();
			var scas= new Array();
			var syear= new Array();
			sfin=strfin[j].split("=");
			//alert(sfin);
			sacinum=stracinum[j].split("=");
			//alert(sacinum);
			scas=strCas[j].split("=");
			//alert(scas);
			syear=strYear[j].split("=");
		//	alert(syear);
			finValue[j]=parseInt(sfin[1]);
			acinumValue[j]=parseInt(sacinum[1]);
			//alert(acinumValue[j]);
			CasValue[j]=parseInt(scas[1]);
			YearValue[j]=syear[1];	
			
		}
		
	

  
// var b=[1,6,8,9,7]
  //  alert(b);
 $(function () {
   
    $('#container').highcharts({
    
    
        chart: {
            zoomType: 'xy'
        },
        title: {
            text: '事故综合分析混合图'
        },
        subtitle: {
           
        },
        xAxis: [{
            categories:YearValue,
            crosshair: true
        }],
        yAxis: [{ // Primary yAxis
            labels: {
                format: '{value}万元',
                style: {
                    color: Highcharts.getOptions().colors[2]
                }
            },
            title: {
                text: '直接经济损失',
                style: {
                    color: Highcharts.getOptions().colors[2]
                }
            },
            opposite: true
        }, { // Secondary yAxis
            gridLineWidth: 0,
            title: {
                text: '伤亡人数',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            },
            labels: {
                format: '{value} 人',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            }
        }, { // Tertiary yAxis
            gridLineWidth: 0,
            title: {
                text: '事故发生次数',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            },
            labels: {
                format: '{value} 次',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            },
            opposite: true
        }],
        tooltip: {
            shared: true
        },
        legend: {
            layout: 'vertical',
            align: 'left',
            x: 80,
            verticalAlign: 'top',
            y: 55,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
        },
        series: [{
            name: '伤亡人数',
            type: 'column',
            yAxis: 1,
            data:CasValue,
            tooltip: {
                valueSuffix: ' 人'
            }
        }, {
            name: '事故发生次数',
            type: 'spline',
            yAxis: 2,
            // categories:
           data:acinumValue,
           // data:[1016, 1016, 1015.9, 1015.5, 1012.3],
            marker: {
                enabled: false
            },
            dashStyle: 'shortdot',
            tooltip: {
                valueSuffix: ' 次'
            }
        }, {
            name: '经济损失',
            type: 'spline',
            data: finValue ,
            tooltip: {
                valueSuffix: ' 万元'
            }
        }]
    });
});      
function splitX(s) {
    var ret = new Array();
    if (s == null || s == "")
    {
        return ret;
    }
    var idx1, idx2, i = 0;
    while ((idx1 = s.indexOf("{")) > -1 && idx1 != s.length - 1)
    {
        idx2 = s.indexOf("}");
        if (idx2 > idx1)
        {
            ret[i] = s.substring(idx1 + 1, idx2);
            i++;
            s = s.substring(idx2);
        } else {
            s = s.substring(idx1);
        }
    }
    return ret;
}

</script>
  </body>
</html>