<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/public.css" rel="stylesheet" type="text/css" />
<title>煤炭安全管理</title>
<!-- é¼ æ ç¹å»åºç°ä¸æèå -->
<script type="text/javascript">
 <!--
 function ExChgClsName(Obj,NameA,NameB){
  var Obj=document.getElementById(Obj)?document.getElementById(Obj):Obj;
  Obj.className=Obj.className==NameA?NameB:NameA;
 }
 
 function showmenu_zzjs(iNo){
 ExChgClsName("zzjs_"+iNo,"menu_zzjs_1","menu_zzjs_2");
 }
 
 function showmenu_zxlx(iNo){
 ExChgClsName("zxlx_"+iNo,"menu_zxlx_1","menu_zxlx_2");
 }
 
-->
</script>
<!-- é¼ æ ç¹å»åºç°ä¸æèå -->
</head>

<body>
<!--left start-->

<div class="content"> 
<div class="left">
<img src="images/left_top.jpg" width="180" height="13" />
<div class="wwwzzjsnet">
<div class="menu_zzjs_1" id="zzjs_0">
<div class="tit_zzjs_net"><h3 class="Fst"><a href="javascript:showmenu_zzjs(0);">事故监测&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       >></a></h3></div>
<div class="txt_zzjs_net">
 <ul>
  <li><a href="index2.jsp" target="I2">煤矿监测</a></li>
  <li class="Lst"><a href="chinaMap.action" target="I2">事故地图</a></li>
  <li class="Lst"><a href="Table.jsp" target="I2">天气情况</a></li>
 </ul>
</div>
</div><!--menu_zzjs_1-->
<!--menu_zzjs_1-->


<div class="menu_zzjs_2" id="zzjs_4">
<div class="tit_zzjs_net"><h3 class="Fst"><a href="javascript:showmenu_zzjs(4);">事故统计&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       >></a></h3></div>
<div class="txt_zzjs_net">
 <ul>
  <li><a href="jjsx.jsp" target="I2">经济损失</a></li>
  <li class="Lst"><a href="bingxingtu.jsp" target="I2">事故数量</a></li>
  <li class="Lst"><a href="casualties.jsp" target="I2">人员伤亡</a></li>
  <li class="Lst"><a href="ComAnalys.action" target="I2">综合分析</a></li>

 </ul>
</div>
</div>


<div class="menu_zzjs_2" id="zzjs_5">
<div class="tit_zzjs_net"><h3 class="Fst"><a href="javascript:showmenu_zzjs(5);">预测分析&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       >></a></h3></div>
<div class="txt_zzjs_net">
 <ul>
  <li class="Lst"><a href="Prediction.jsp" target="I2">事故预测</a></li>
  <li class="Lst"><a href="Induction.jsp" target="I2">致因分析</a></li>
 </ul>
</div>
</div>

<div class="menu_zzjs_2" id="zzjs_6">
<div class="tit_zzjs_net"><h3 class="Fst"><a href="javascript:showmenu_zzjs(6);">全部事故统计&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       >></a></h3></div>
<div class="txt_zzjs_net">
 <ul>
  <li class="Lst"><a href="to_pro_acci.jsp" target="I2">省份统计</a></li>
  <li class="Lst"><a href="to_year_acci.jsp" target="I2">年份统计</a></li>
  <li class="Lst"><a href="AllAcciDetailAction.action" target="I2">详细数据</a></li>
  <li class="Lst"><a href="all_acd_pridiction.jsp" target="I2">事故预测</a></li>
 </ul>
</div>
</div>
</div>

</div>  
   <!--left end-->
<div class="right"></div>



</body>
</html>
