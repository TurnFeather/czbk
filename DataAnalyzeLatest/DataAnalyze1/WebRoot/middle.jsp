<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>ÎÞ±êÌâÎÄµµ</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<style> 
.navPoint { 
COLOR: white; CURSOR: hand; FONT-FAMILY: Webdings; FONT-SIZE: 9pt 
} 
</style> 
<script>
var nowWindowIsLearn=false;
function window.onbeforeunload(){
	var iframeHref=window.frames["I2"].document.location.href ;
	//alert(iframeHref);
	var start=iframeHref.lastIndexOf("\/")+1;
	//alert(iframeHref.lastIndexOf("\/")+1);
	var end=iframeHref.indexOf("&");
	//alert(end);
	var length="StudyAction.action?wm.sf=startstudy".length;
	//var href=iframeHref.substring(iframeHref.lastIndexOf("\/")+1,iframeHref.indexOf("&"));
	var href=iframeHref.substring(start,end)
	//alert(href);
	//alert(iframeHref.substring(iframeHref.lastIndexOf("\/"),iframeHref.indexOf("&")));
	if(href=="StudyAction.action?wm.sf=startStudy"){
		nowWindowIsLearn=true;
		var waring = "È·¶¨¹Ø±Õä¯ÀÀÆ÷?"; 
		return waring;
	}
}
function window.onunload(){ 
	//alert(nowWindowIsLearn); 
	if(nowWindowIsLearn) {
   		window.frames["I2"].document.getElementById("form1").submit();
    }
} 
function toList(){
	window.frames["iframe"].document.put_form.submit();

}
function switchSysBar(){ 
var locate=location.href.replace('middle.html','');
var ssrc=document.all("img1").src.replace(locate,'');
if (ssrc=="images/kaiguan01.jpg")
{ 
document.all("img1").src="images/kaiguan_1.jpg";
document.all("frmTitle").style.display="none" 
} 
else
{ 
document.all("img1").src="images/kaiguan01.jpg";
document.all("frmTitle").style.display="" 
} 
} 
</script>

</head>

<body >
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
  <form  action="CouAction.action?wm.sf=toList" method="post"></form>
    <td width="197" bgcolor="#daeef3" id=frmTitle noWrap name="frmTitle" align="center" valign="top">
	<iframe name="I1" height="100%" width="197" src="left.jsp" border="0" frameborder="0" scrolling="yes" >
	</iframe>	</td>
    <td width="8" valign="middle" background="images/kaiguan_bg.jpg" onclick=switchSysBar()>
    <SPAN class=navPoint id=switchPoint title=¹Ø±Õ/´ò¿ª×óÀ¸><img src="images/kaiguan01.jpg" name="img1" width=8 height=60 id=img1></SPAN></td> 
    <td align="center" valign="top">
    <iframe id="iframe" name="I2" height="100%" width="99.9%" border="0" frameborder="0" scrolling="yes" src="MyJsp.jsp"> 
    </iframe></td>
  </tr>
</table>
</body>
</html>
