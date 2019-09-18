
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>事故详细报告</title>
<style type="text/css">
<!--
body,table{
    font-size:15px;
}
table{
    table-layout:fixed;
    empty-cells:show; 
    border-collapse: collapse;
    margin:0 auto;
}
td{
    height:20px;
}
h1,h2,h3{
    font-size:18px;
    margin:0;
    padding:0;
}

.title { background: #FFF; border: 1px solid #9DB3C5; padding: 1px; width:90%;margin:20px auto; }
    .title h1 { line-height: 31px; text-align:center;  background: #2F589C url(th_bg2.gif); background-repeat: repeat-x; background-position: 0 0; color: #FFF; }
        .title th, .title td { border: 1px solid #CAD9EA; padding: 5px; }


/*这个是借鉴一个论坛的样式*/
table.t1{
    border:1px solid #cad9ea;
    color:#666;
}
table.t1 th {
    background-image: url(th_bg1.gif);
    background-repeat::repeat-x;
    height:30px;
    color:#FF0000;
}
table.t1 td,table.t1 th{
    border:1px solid #cad9ea;
    padding:0 1em 0;
 
}
table.t1 tr.a1{
    background-color:#f5fafe;
}



table.t2{
    border:1px solid #9db3c5;
    color:#666;
}
table.t2 th {
    background-image: url(th_bg2.gif);
    background-repeat::repeat-x;
    height:30px;
    color:#fff;
}
table.t2 td{
    border:1px dotted #cad9ea;
    padding:0 2px 0;
}
table.t2 th{
    border:1px solid #a7d1fd;
    padding:0 2px 0;
}
table.t2 tr.a1{
    background-color:#e8f3fd;
}




-->
</style>

</head>

<body>

<table border="1" class="t1" width="800">
 <s:iterator value="acdDetailList">
  <thead>
  
     <th colspan="4"><s:property  value="acdName" /></th>
  
     </thead>
  <tr class="a1">

    <td ><b>发生时间：</b><s:property  value="acdDateTime" /></td>
    <td ><b>发生地点：</b><s:property  value="acdLocale" /></td>
    <td colspan="2"><b>事故单位：</b><s:property  value="acdCompany" /></td>
  </tr>
  <tr>
    <td colspan="4"><b>事故单位概况:</b>  <p style="line-height:28px; text-indent:2em; letter-spacing:2px； face=楷体"><s:property  value="acdCompanyOverview" /></p>
   </td>
   
  </tr>
  <tr  style="background-color:#f5fafe">
    <td><b>死亡人数:</b><s:property  value="deathNum" /></td>
    <td><b>重伤人数:</b><s:property  value="badlyInjuryNum" /><br /><b>轻伤人数:</b><s:property  value="minorInjuryNum" /></td>
    <td><b>直接经济损失(万元):</b><s:property  value="directEconomicLoss" /></td>
     <td width="25%"><b>事故类型:</b> <s:property  value="acdType" /></td>
  </tr>
  <tr>
    <td colspan="4"><b>应急救援处理:</b> <p style="line-height:28px; text-indent:2em;letter-spacing:1px"><s:property  value="emergencyDisposal" /></p></td>
  </tr>
 
   
  <tr style="background-color:#f5fafe">
     <td colspan="4"><b>事故原因:</b><p style="line-height:28px; text-indent:2em;letter-spacing:1px"><s:property  value="acdReason" /></p></td>
  </tr>
   
  <tr> <td colspan="4"><b>气象情况</b><p><b>风速:</b><s:property  value="WindSpeed" /> &nbsp; <b>湿度:</b><s:property  value="Humidity" />&nbsp;<b>空气质量:</b><s:property  value="AirQuality" />&nbsp;<b>温度:</b><s:property  value="Temperature" />摄氏度</p><br/></td></tr>
  
   </s:iterator>
  <tr style="background-color:#f5fafe">
  <s:iterator value="authority_list" id="s"> <td colspan="4"><b>事故教训:</b><p style="line-height:28px; text-indent:2em; letter-spacing:1px"><s:property value="s" /></p></td></s:iterator>
  </tr>
  <tr>
   <s:iterator value="advice_list" id="s_mea">  <td colspan="4"><b>措施与建议:</b><p style="line-height:28px; text-indent:2em; letter-spacing:1px"><s:property value="s_mea" /></p> </td></s:iterator>
  </tr>
  <tr style="background-color:#f5fafe">
   <td colspan="4">事故调查报告</td>
  </tr>
  <tr>
   <td colspan="4"><a href="http://localhost:8088/DataAnalyze/doc/<s:property value="acdId" />_law.docx">事故相关法规</a></td>
  </tr>
  <tr style="background-color:#f5fafe">
   <td colspan="4"><s:iterator value="acdDetailList"><a href="http://www.baidu.com/s?wd=<s:property  value="acdDataIndex" />" target="_blank">事故相关报道</a></s:iterator></td>
  </tr>
</table>

</body>
</html>