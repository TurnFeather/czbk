	var refreshtime = 2000;
	var lunbotime = 2000;
	var recordId = 0;
	var num = 3;
	var num2 = 3;
	var child = 1;
	var delchild = 1;
	var schild = 1;
	var delschild = 1;
	var interval;
	$(document).ready(function(){
		interval = setInterval(refresh, refreshtime);
		interval = setInterval(lunbo, lunbotime);
		
	});
	function refresh(){
		$.post("DataAnalyzeAction.action?recordId="+recordId , null,  function(data){
			if(data.MSG!=""){
				
				if(data.MAXID!=recordId){
					if($("#"+(delchild+4)).length!=0){
						$("#result").children().last().remove();
						delchild++;	
					}
					var childDiv=$('<div></div>');        
					childDiv.prependTo($("#result"));    
	   				childDiv.attr('id','container');  
	   			    childdiv.addclass('min-width:400px;height:400px');
				
	   			}
			}
			if($("#status"+(delschild+17)).length!=0){
				$("#monitor").children().last().remove();
				delschild++;
			}			       
			var schildDiv=$('<div></div>');       			
			schildDiv.prependTo($("#monitor"));       
			schildDiv.attr('id',"status"+schild);   
			if(data.STATUS==true){				  
   				$("#status"+schild).html(data.TIME+" 数据监测正常!");	 			
   			}else{   
  				$("#status"+schild).html(data.TIME+" 数据监测异常!");
   			}
   			schild++;

		},'json');

	}
	
	function lunbo(){
		if(num>2){num=0;}
		$('ul li').eq(num).css('left','500px');	
		num2++;
		$('ul li').eq(num).css('z-index',num2);
		$('ul li').eq(num).animate({left:'0'},1000);
		num++;
	}
	$(function(){
		$('ul li').click(function(){
			$('ul li').show();		
		});	
	})
	