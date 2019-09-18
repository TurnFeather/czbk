<%@page import="java.io.InputStream"%><%@page import="java.io.OutputStream"%><%@page import="java.io.FileInputStream"%><%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%
    	System.out.println(application.getRealPath("/1.jpg"));
    	InputStream in = new FileInputStream(application.getRealPath("/1.jpg"));
    	
    	response.setHeader("Content-Disposition", "attachment;filename=1.jpg");
    	
    	OutputStream sout = response.getOutputStream();
    	byte[] b = new byte[1024];
    	int len = -1;
    	while ((len = in.read(b))!=-1)
    	{
    		sout.write(b, 0, len);
    	}
    	in.close();
     %>