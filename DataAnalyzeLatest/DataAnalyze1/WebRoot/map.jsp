<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>事故地图</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script id="jquery_183"  Charset="UTF-8" type="text/javascript" class="library" src="js/jquery-1.8.3.min.js"></script>
	<script src="js/HeightMap/highcharts.js"></script>
	<script src="js/HeightMap/modules/map.js"></script>
	<!--<script src="http://code.highcharts.com/maps/highmaps.js"></script>-->
	<script src="js/HeightMap/modules/data.js"></script>
	<script src="js/HeightMap/modules/drilldown.js"></script>
	<script src="layer/layer.js"></script>
	
	<script type="text/javascript" src="js/HeightMap/cn-china-by-peng8.js"></script>
	
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="layer/skin/layer.css" rel="stylesheet">
	<link href="css/bootstrap.css" rel="stylesheet">

  </head>
  		
  <body>
  
	<div id="container" style="height: 640px; min-width: 310px; max-width: 900px; margin: 0 auto"></div>

  </body>
  
  <script type="text/javascript"><!--
  $(function () {
	  
	    Highcharts.setOptions({
	        lang:{
	            drillUpText:"返回 > {series.name}"
	        }
	    });
	    
	     var data = Highcharts.geojson(Highcharts.maps['countries/cn/custom/cn-all-china']),small = $('#container').width() < 400;

 	
	    // 给城市设置随机数据
	   $.each(data, function (i) {
	  this.drilldown = this.properties['drill-key'];
	 
	   	//this.value= function getProNum(this.properties['cn-name']);
			//alert(this.properties['cn-name']);
  this.value= getNumValue(this.properties['cn-name']);
	
	//this.value=i;
    });     
    
	  
	    //获取 point name
		function getPoint(e){
			//console.log(e.point.name);
		//	var cityName= encodeURI(e.point.name).val(),"UTF-8");
			$.ajax({
	            cache: false,
	            type: 'POST',
	            url:'getInfo.action?userName='+e.point.name,
	      //      data : {
	            	// userName: encodeURI(encodeURI('青岛市',"UTF-8")), 
	            //	userName: '青岛',
	         //   userName: encodeURI
	        //    },
	            dataType:'json',
	            success: function(data) {
	            	var member = eval("("+data+")");    //包数据解析为json 格式
	                var str="";
	               
	            	for(var key in member.list){
	            	str = str+ '<tr>';
	            	 str+='<td><font size="1"><a href="AcciDetail.action?acdId='+member.list[key].id+'">'+member.list[key].time+member.list[key].name+'</a></font></td>';
	            	 
	            //	 str+='<td><font size="1">'+member.list[key].name+'</font></td>';
	            	// str+='<td><font size="1"><a href="AcciDetail.action?acdId='+member.list[key].id+'">查看</font></a></td>'
	            	 str+='</tr>';
	            			      	   
		            }
               		layer.open({
               			type :1,
               			title:'',
					  	content: '<table class="table table-hover table-striped">'+
					  			
               						'<tbody>'+str+
	               					
		           					'</tbody>'+
               					 '</table>',
					  	shade:[0],
					    closeBtn:1,
					    shift: 'left',
					    btn:false,
					  	area: ['auto', 'auto']
					});
                },
                error: function(){
                	layer.open({
					  
					  	content: '<a href="#" >1231</a></br>',
					  //	closeBtn: 2,
					  	area: ['25px', 'auto']
					});
                }
            });

		}
		function getShow(e){
			alert(1);
		}
	    //初始化地图
	    $('#container').highcharts('Map', {

	        chart : {
				spacingBottom:30,
					 
	            events: {
	                drilldown: function (e) {

	                    if (!e.seriesOptions) {
	                        var chart = this;
	                              /*   mapKey = 'countries/china/' + e.point.drilldown + '-all',
	                              fail = setTimeout(function () {
	                                    if (!Highcharts.maps[mapKey]) {
	                                        chart.showLoading('<i class="icon-frown"></i> 加载失败 ' + e.point.name);

	                                        fail = setTimeout(function () {
	                                            chart.hideLoading();
	                                        }, 1000);
	                                    }
	                                }, 10000);*/
	                        var cname=e.point.properties["cn-name"];//cname =获取到的 “cn-name”
	                       // alert(cn-name);
	                        chart.showLoading('<i class="icon-spinner icon-spin icon-3x"></i>');
	                        // 加载城市数据
	                        $.ajax({
	                            type: "GET",
	                            url: "http://data.hcharts.cn/jsonp.php?filename=GeoMap/json/"+ e.point.drilldown+".geo.json",
	                            contentType: "application/json; charset=utf-8",
	                            dataType:'jsonp',
	                            crossDomain: true,
	                            success: function(json) {
	                                data = Highcharts.geojson(json);
							//		alert(e.point.drilldown);	 
	                                $.each(data, function (i) {
																		 
	                                    this.value = getCityNumValue(this.name);//随机值，进入省份以后城市的值
										this.events={};
									//	alert(this.name);
										this.events.click=getPoint;
										
																			
	                                });
	                                chart.hideLoading();

	                                chart.addSeriesAsDrilldown(e.point, {
	                                    name: e.point.name,
	                                    data: data,
										events:{
											show:function(){
												alert(1);
											}
										},
	                                    dataLabels: {
	                                        enabled: true,
	                                        format: '{point.name}'//设置显示形式，这里显示的是 各省的城市数据
	                                    }
	                                });
	                            },
	                            error: function (XMLHttpRequest, textStatus, errorThrown) {

	                            }
	                        });
	                    }


	                    this.setTitle(null, { text: cname });//这显示 图右侧 省份名称，可以回退
	                },
	                drillup: function () {
	                    this.setTitle(null, { text: '中国' }); //右侧 显示中国，进入省份则显示省份
	                }
	            }
	        },
			tooltip: { 
				formatter:function(){
					var htm="共发生事故";
					var str="";
					if(this.point.drilldown){
					    str=this.point.properties["cn-name"]+"</br>"+htm;
					}else{
						 str=this.point.name+"</br>"+htm;
					}
					str+=":"+this.point.value+"起";
					return str;
					 
				}
			},
	        credits:{
				href:"javascript:goHome()",
	            text:"煤矿安全事故"
	        },
	        //标题
	        title : {
	            text : '安全事故分布图'
	        },

	        subtitle: {
	            text: '中国',
	            floating: true,
	            align: 'right',
	            y: 50,
	            style: {
	                fontSize: '16px'
	            }
	        },

	        legend: small ? {} : {
				// enabled: false,
	            layout: 'vertical',
	            align: 'right',
	            verticalAlign: 'middle'
	        },
	        //tooltip:{
	        //pointFormat:"{point.properties.cn-name}:{point.value}"
	        //},
	        //省市程度色彩设置
	        colorAxis: {
	            min: 0,
	            minColor: '#EFEFFF',
	            maxColor: '#003875',
					labels:{
						style:{
								"color":"red","fontWeight":"bold"
						}
					}
	        },

	        mapNavigation: {
	            enabled: true,
	            buttonOptions: {
	                verticalAlign: 'bottom'
	            }
	        },

	        plotOptions: {
	            map: {
	                states: {
	                    hover: {
	                        color: '#BADA55'
	                    }
	                }
	            }
	        },
	        
			//默认状态下，地图图表均不显示数据标签。用户需要在数据列中启用才可以。这时，需要使用配置项enabled为true
	        series : [{
	            data : data,
	            name: '中国',
	            joinBy: 'hc-key',
	            states: {
	                hover: {
	                    color: '#BADA55'
	                }
	            },
	            dataLabels: {
	                enabled: true,
	                format: '{point.properties.cn-name}'//设置显示形式，这里显示的是 各城市名称
	            }
	        }],

	        drilldown: {
						
	            activeDataLabelStyle: {
	                color: '#FFFFFF',
	                textDecoration: 'none',
	                textShadow: '0 0 3px #000000'
	            },
	            drillUpButton: {
	                relativeTo: 'spacingBox',
	                position: {
	                    x: 0, //水平偏移距离
	                    y: 60
	                }
	            }
	        }
	    });
	});
	
	function getNumValue(pro){
	 var prolist = '${prolst}';
		var ret = splitX(prolist);
		
		var strs= new Array(); 
		
		var strPro= new Array();
		var strNum=new Array();
		var strProkey=new Array();
	    var strProValue=new Array();
	    var strNumValue=new Array();
		for (var i = 0; i < ret.length; i++)
		{
    	//	alert(ret[i]);
    		strs=ret[i].split(",");
    		strNum[i]=strs[0];
    		strPro[i]=strs[1];
		}
	//	alert(strPro);
		for(var j=0; j<strPro.length; j++){
		
			var s = new Array();
			s=strPro[j].split("=");
			strProValue[j]=s[1];	
		}
	//	alert(strProValue);
		for(var k=0; k<strNum.length; k++){
		
			var s1 = new Array();
			s1=strNum[k].split("=");
			strNumValue[k]=s1[1];	
		}
	//	alert(strNumValue);
		var accident_num=0;
		for(var h=0; h<strProValue.length; h++){
			
			if(strProValue[h] == pro){
			accident_num=strNumValue[h];
			}
			
		}
		return accident_num;
}
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

 function getCityNumValue(city){
     var citylist = '${citylst}';
 
 	  var cityArray = splitX(citylist);
	     
	       var Citystrs= new Array();
	       var strCity= new Array();
		   var strCityNum=new Array(); 
		   var strCityValue=new Array();
	       var strCityNumValue=new Array();
	      for (var i = 0; i < cityArray.length; i++)
		  {
			
    		//alert(ret[i]);
    		Citystrs=cityArray[i].split(",");
    		strCity[i]=Citystrs[0];
    		strCityNum[i]=Citystrs[1];
    		//strs[1];
		   }
		   for(var j=0; j<strCity.length; j++){
		
			var s = new Array();
			var s1 = new Array();
			s=strCity[j].split("=");
			s1=strCityNum[j].split("=");
			strCityValue[j]=s[1];	
			strCityNumValue[j] = s1[1];
		}
	
		var ci_acci_num=0;
		for(var h=0; h<strCityValue.length; h++){
			
			if(strCityValue[h] == city){
			ci_acci_num=strCityNumValue[h];
			}
			
		}
		return ci_acci_num; 
 
 }

  </script>
</html>
