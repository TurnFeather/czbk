$(function () {
	/*
	layer.open({
		  type: 1 //Page层类型
		  ,area: ['500px', '300px']
		  ,title: '你好，layer。'
		  ,shade: 0.6 //遮罩透明度
		  ,maxmin: true //允许全屏最小化
		  ,anim:  //0-6的动画形式，-1不开启
		  ,content: '<div style="padding:50px;">这是一个非常普通的页面层，传入了自定义的html</div>'
		});
	*/
	var year = prompt("请输入你想展示的迄今为止的年数","5");
	var data = ['致因1','致因2','致因3','致因4','致因5','致因6','致因7','致因8','致因9','致因10',
                '致因11','致因12','致因13','致因14','致因15','致因16','致因17','致因18','致因19',
                '致因20','致因21','致因22','致因23','致因24','致因25'];
	$.ajaxSetup({   
        async : false  
    });
    $.post("EventCountAction.action?i="+year , null,function(ndata){
    	for (var a in ndata)
		{
    		data[a] = ndata[a];
		}
    });	
	
    $('#container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '事故致因统计分析图'
        },
        subtitle: {
            text: '来源: <a href="http://www.chinasafety.gov.cn/newpage/" target="_blank">安全总局</a>'
        },
        
        plotOptions: {
            series: {
                cursor: 'pointer',
                events: {
                    click: function (event) {
                    	
                    	//同步获取超链接，然后显示出来。
                    	//将致因和年数都发过去。
                    	var str1 = '<div style="padding:10px;line-height:18px;">';
                    	
                    	$.ajaxSetup({   
                            async : false  
                        });
                        $.post("SerAccidentAction.action?i="+event.point.x+"&year="+year , null,function(adata){
                        	for (var a in adata)
                    		{
                        		str1 = str1 + '<a href = "AcciDetail.action?acdId=' + a + '"style="text-decoration:none;font-size:13px;font-family:Verdana, sans-serif">' + adata[a] + '</a>';
                        		
                        		str1 = str1 + "<br/>";
                    		}
                        });	
                    	
                        
                    	str1 = str1 + '</div>';
                    	
                    	var data = event.point.x;
                    	var titleContent;
                    	switch(data)
                    	{
                    		case 0:titleContent = '致因1-防护、保险、信号等装置缺乏或有缺陷';break;
                    		case 1:titleContent = '致因2-设备、设施、工具、附件有缺陷';break;
                    		case 2:titleContent = '致因3-个人防护用品（包括防护服、手套、护目镜及面罩、安全带、安全帽、安全鞋等）缺少或有缺陷。';break;
                    		case 3:titleContent = '致因4-施工场地环境不良';break;
                    		case 4:titleContent = '致因5-操作错误、忽视安全、忽视警告';break;
                    		case 5:titleContent = '致因6-造成安全装置失效';break;
                    		case 6:titleContent = '致因7-使用不安全设备';break;
                    		case 7:titleContent = '致因8-用手代替手动工具操作';break;
                    		case 8:titleContent = '致因9-物体（指材料、工具、切屑和生产用品等）存放不当（工完场清）。';break;
                    		case 9:titleContent = '致因10-冒险进入危险场所';break;
                    		case 10:titleContent = '致因11-攀坐不安全位置（如平台护栏、汽车挡板、吊车吊钩）';break;
                    		case 11:titleContent = '致因12-在起吊物下作业、停留';break;
                    		case 12:titleContent = '致因13-机器运转时加油、修理、检查、调整、焊接、清扫等工作';break;
                    		case 13:titleContent = '致因14-有分散注意力的行为（边工作边聊天，工作时抽烟）';break;
                    		case 14:titleContent = '致因15-在必须使用个人防护用品、用具的作业或场合中，忽视其使用';break;
                    		case 15:titleContent = '致因16-不安全装束';break;
                    		case 16:titleContent = '致因17-对易燃、易爆等危险物品处理错误';break;
                    		case 17:titleContent = '致因18-施工单位安全投入不足，管理体制不健全，安全管理工作不到位。';break;
                    		case 18:titleContent = '致因19-设计单位、勘察单位的技术成果有缺陷，以及技术和设计上有缺陷。例如构件的承载力不足、勘察结果不准、机械设备和仪器仪表不能正常工作、施工材料使用存在质量问题、工艺过程和操作方法存在问题。';break;
                    		case 19:titleContent = '致因20-教育培训不够。例如：未经培训，缺乏或不懂安全操作技术知识。';break;
                    		case 20:titleContent = '致因21-劳动组织不合理，对现场工作缺乏检查或指导错误。';break;
                    		case 21:titleContent = '致因22-没有安全操作规程或规程内容不具体、不可行。';break;
                    		case 22:titleContent = '致因23-没有或不认真实施事故防范措施，对事故隐患整改不力。';break;
                    		case 23:titleContent = '致因24-建设单位不合理的压缩合同工期，建设单位要求垫资、压价，造成安全施工措施费用不到位。';break;
                    		case 24:titleContent = '致因25-安全监管机构不完善，施工企业发生安全事故受罚不重，监管机构效能有局限，等等。';break;
                    	}
                    	
                        layer.open({
  								type: 1 //Page层类型
								,area: ['500px', '300px']
								,title: titleContent
								,shade: 0.4 //遮罩透明度
								,maxmin: true //允许全屏最小化
								,anim: 5 //0-6的动画形式，-1不开启
								,content: str1
						});  
                    }
                }
            },
            column:{
            	dataLabels:{
            		allowOverlap:true,
            		overflow:"justify",
            		y:-20,
            		style: {
            			fontSize: '14px',
            			fontFamily: 'Verdana, sans-serif'
            		}
            	}
            }
        },
        
        xAxis: {
            type: 'category',
            categories:['致因1','致因2','致因3','致因4','致因5','致因6','致因7','致因8','致因9','致因10',
                        '致因11','致因12','致因13','致因14','致因15','致因16','致因17','致因18','致因19',
                        '致因20','致因21','致因22','致因23','致因24','致因25'],
            labels: {
                rotation: -45,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: '事故数(个)'
            }
        },
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: '事件数: <b>{point.y} </b>'
        },
        
        //从数据库获取数据，发送请求
        //第一次初始先获取迄今为止所有事故个数。
        
        series: [{
            name: 'Event',
            data: data,
            dataLabels: {
            	useHTML:true,
                enabled: true,
                rotation: 0,
                color: '#FFFFFF',
                align: 'center',
                format: '{point.y}',
                y: 3,
                style: {
                    fontSize: '14px',
                    fontFamily: '宋体',
                    textShadow:null
                }
            }
        }]
    });
});