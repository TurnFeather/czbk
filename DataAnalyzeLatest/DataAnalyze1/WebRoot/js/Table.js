

var lasthour;	//用于保存上次获取的值，判断与上次获取的值是否相等，如果相等，则不刷新
var val = 11;	//动态第一次加载获取索引为11的情况值

$(function () {
    		$(document).ready(function () {
        	Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
        	
        	
        $('#container').highcharts({
            chart: {
                type: 'spline',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {
                    	

                        var series = this.series[0];
                        
                        setInterval(function () {
                        	
                        	
                        	var temperature,time;
                        	$.ajaxSetup({   
                                async : false  
                            });
                            $.post("DataWeatherAction.action?i="+val , null,function(data){
                        		
                        		if(data.situation !="")
                        		{
                        			var strus = data.situation;
                        			temperature = strus.temperature;
                        			//time = /*(strus.day)*/(strus.hour - 8)*60*60*1000;
                        			time = (new Date(strus.year,strus.month,strus.day,strus.hour,0,0,0)).getTime();
                        		}
                        		else
                        			alert("为空");
                        });	
                            
                        	
                            var x = time, // current time
                                y = temperature;
                            
                            if (lasthour != time)		//第一次的lasthour存在
                        	{
                            	lasthour = time;		//保存上一次的lasthour
                            	val++;
                            	series.addPoint([x, y], true, true);
                        	}
                            else
                        	{
                            	//因为这次获取的时间和上一次的一样，所以什么都不用做
                        	}
                        }, 1000);
                    }
                }
            },
            title: {
                text: '北京天气'
            },
            xAxis: {
                type: 'datetime',
                tickInterval: 3600*1000,
                minTickInterval:3600*1000,
                maxTickInterval:3600*1000,
                tickAmount:12,
                dataTimeLabelFormates:{
                	day:'%e. %b'
                }
            },
            yAxis: {
              labels: {
                format: '{value} °C',
            },
                title: {
                    text: '温度  (°C)'
                },
                
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                formatter: function () {
                    return '<b>' + this.series.name + '</b><br/>' +
                        Highcharts.dateFormat('%Y-%m-%d %H:%M', this.x) + '<br/>' +
                        Highcharts.numberFormat(this.y, 1);
                }
            },
            legend: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
            series: [{
                name: '温度',		
                data: (function () {
                
                    var data = [],
                    	time = [12],
                        i;
               
                    var count = 0;
                    var temp = [12];
                    
                    $.ajaxSetup({   
                        async : false  
                    });
                    //从数据库取出11条数据
                    $.post("DataWeatherAction.action?i=0" , null,function(data){
                		
                		if(data.situation0 !="")
                		{
                			if(data.situation0 !="")
                    		{
                    			for(var a in data)
                    			{
                		        	temp[count] = data[a].temperature;
                		        	//time[count] = /*(data[a].day)*/(data[a].hour - 8)*60*60*1000;
                		        	time[count] = (new Date(data[a].year,data[a].month,data[a].day,data[a].hour,0,0,0)).getTime();
                		        	//alert(data[a].year + ":" + data[a].month + ":" + data[a].day + ":" + data[a].hour);
                		        	lasthour = time[count];	//用于初始化hour的值
                		            count++;   
                    		    }
                    		}
                    		else
                    			alert("为空");
                		}
                		else
                			alert("为空");
                });	
   
                    for (i = -19; i <  -19+count; i += 1) {
                        data.push({
                            x: time[19+i],
                            y:temp[19+i]
                        });
                       
                    }
                    return data;
                }()),
                pointInterval:3600*1000
            }]
            //
            
            //
        });
    });
});