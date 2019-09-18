<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'all_acd_detail.jsp' starting page</title>
    
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
 tr:nth-child(odd) {

     background: #ccc;

}
</style>

	 <script id="jquery_183" type="text/javascript" class="library" src="js/jquery-1.8.3.min.js"></script>
	<script src="js/HeightMap/highcharts.js"></script>
	<script src="js/HeightMap/modules/exporting.js"></script>
	<script src="js/HeightMap/modules/data.js"></script>
  </head>
  
  <body>
  <table width="80%" border="1" cellspacing="0" cellpadding="0" align="center">
  <tr>
  <td>
  <form action="AllAcciDetailAction.action?cityvalue=青岛" method="get">
  		<select name="province" >
		<option value="全部省份">全部省份</option>
		 <s:iterator value="plist">
		<option value=<s:property  value="province" />><s:property  value="province" /></option>

	    </s:iterator>
        </select>
        <select name="year" >
		<option value="全部年份">全部年份</option>
		 <s:iterator value="ylist">
		<option value=<s:property  value="year" />><s:property  value="year" /></option>

	    </s:iterator>
        </select>    
           <input name="" type="submit" value="搜索">  
  </form>
  </td>
  </tr>
  </table>
<table width="80%" border="1" cellspacing="0" cellpadding="0" align="center">
  <tr>
  		<td  align="center" colspan="4"> 事故详细数据表</td> 
  </tr>

  <tr>
    <td width="23%"  align="center"><b>年份</b></td>
    <td width="17%"  align="center"><b>省份</b></td>
    <td width="25%"  align="center"><b>事故次数</b></td>
    <td width="30%"  align="center"><b>死亡人数</b></td>
  </tr>
  <s:iterator value="lst">
  <tr>
    <td align="center"><s:property  value="Year" /></td>
    <td  align="center"><s:property  value="province" /></td>
    <td align="center"><s:property  value="acd_num" /></td>
    <td align="center" valign="middle"><s:property  value="die_num" /></td>
  </tr>
  </s:iterator>
   <tr>
   <td><b>总计</b></td>
    <s:iterator value="tolist">
    <td colspan="2"><b>事故总量:</b> 
      <s:property  value=" to_acd_num" /></td>
   
    <td colspan="2"><b>死亡人数:</b>
      <s:property  value=" to_die_num" />
      : </td>
    </s:iterator>
   </tr>
</table>
<br>
<table width="80%" border="1" cellspacing="0" cellpadding="0" align="center">
 <tr>
  		<td colspan="3" align="center">省份统计</td> 
  </tr>
  <tr>
    <td>省份</td>
    <td>事故数量</td>
    <td>死亡人数</td> 
  </tr>
   <s:iterator value="plist">
   <tr>
   <td><s:property  value="province" /></td>
    <td><s:property  value="acd_num" /></td>
    <td align="center" valign="middle">	
    <s:property  value="die_num" /></td>
    </tr>
   </s:iterator>
  
</table>
 <br>
<table width="80%" border="1" cellspacing="0" cellpadding="0" align="center">
 <tr>
  		<td colspan="3" align="center">年份统计</td> 
  </tr>
  <tr>
    <td>年份</td>
    <td>事故数量</td>
    <td>死亡人数</td> 
  </tr>
    <s:iterator value="ylist">
   <tr>
   <td><s:property  value="year" /></td>
    <td><s:property  value="acd_num" /></td>
    <td align="center" valign="middle">	
    <s:property  value="die_num" /></td>
    </tr>
   </s:iterator>

 
</table>
 <!--
 <div id="table1" style="min-width:400px;height:400px"></div>
  
  <script>
  $(function(){
    var x = [];//X轴
    var y = [];//Y轴
    var y1= []; //y1轴
    var xtext = [];//X轴TEXT
    var xs=[];
    var color = ["gray","pink","red","blue","yellow","green","#fff"];

    $.ajax({
        type:'get',
     //   url:'AllAcciProAction.action',//请求数据的地址
         url:'AllAcciDetailAction.action',//请求数据的地址
        success:function(data){
            var json = eval("("+data+")");
         //   alert(json.prolist.length);
            var s = 1;
            var data = '';
            
    data += '<table border=1><tbody>';
       for (var i = 0; i<1; i++) {
        
        data += '<tr>';
        for (var j = 0; j<33; j++) {
         	if(i==0){
         		if(j==0){
      
         	//data += '<td>' + i + ',' + j + '</td>';}
         	data += '<td>'+'</td>';}
         	else if(j!=0){
         		
         		data += '<td colspan="2">' + json.prolist[j-1].province + '</td>';
         		}
         	}
         	
         /*	else{
         	data += '<td>' + i + ',' + j + '</td>';
         	}*/
         	
        }
        
      
        data += '</tr>';
       }
        for (var i = 1; i<2; i++) {
        
        data += '<tr>';
        for (var j = 0; j<65; j++) {
         if(j==0){
         	data += '<td>'+'</td>';
         	}
         	else {
         	if(j%2==0){
         		data += '<td>' +'死亡人数'+ '</td>';
         	}else{
         		data += '<td>' +'事故次数'+ '</td>';
         	}
         	
         /*	else{
         	data += '<td>' + i + ',' + j + '</td>';
         	}*/
         	}
        }
        
      
        data += '</tr>';
       }
        //for (var i = 2; i<json.yearlist.length+2; i++) {
     /*   for (var i = 2; i<4; i++) {
       // alert(json.yearlist.length+2);
        data += '<tr>';
        for (var j = 0; j<65; j++) {
         	if(j==0){
         	data += '<td >' +json.yearlist[i-2].year+ '</td>';
         	}
         	else{
         	if(j%2!=0){
       				var acdnum = 0;
       				var pro = new Array();
       				var acd = new Array();
       				var total=0;
					var i=1;
       				/*do{
    				total+=i;
    					i++;
				}while(i<=100);
				
				alert(total);*/
       			
         			
         			data += '<td >'+2+'</td>';
         			
         			}
         		
         	 else{
         			data += '<td >'+ json.Detlist[0].dienum+'</td>';
         	 	}
         	
         	}
         		
  			
        }
        data += '</tr>';
       }*/
       data += '</tbody><table>';
       
       document.getElementById('table1').innerHTML = data;
            /*  for (var i = 0; i < 5; i++) {
                $("<p>表" + i + "</p>").appendTo("body");
                $("<table border='1' cellpadding='1' cellspacing='1' title='表" + i + " '><tr><td>" + i + "</td><td>" + i + "</td></tr><tr><td>" + i + "</td><td>" + i + "</td></tr></table>").appendTo("body");
            }*/
          /*  var t = document.createElement('table');
       var b = document.createElement('tbody');
       for (var i = 0; i <7; i++) {
        var r = document.createElement('tr');
        for (var j = 0; j < json.prolist.length; j++) {
         var c = document.createElement('td');
         var m = document.createTextNode(json.prolist[j].province);
         c.appendChild(m);
         r.appendChild(c);
        }
        b.appendChild(r);
       }
       
       t.appendChild(b);
       document.getElementById('table1').appendChild(t);
      t.setAttribute('border', '1');*/
          /*  for(var key in json.prolist){
            	
               json.prolist[key].y = json.prolist[key].acdnum;
           //    json.prolist[key].y1 = json.prolist[key].dienum;
               xs[key] = json.prolist[key].province;//给X轴TEXT赋值
              	
             // json.truelist[json.truelist.length-1].color= color[2];
            }
             for(var key in json.dielist){
              json.dielist[key].y = json.dielist[key].dienum;
             }
            	
                chart.series[0].setData(json.prolist);//数据填充到highcharts上面
                chart.series[1].setData(json.dielist);*/
        },
        error:function(e){
        } 
    });
   
});


     
    </script>
    -->
  </body>
</html>
