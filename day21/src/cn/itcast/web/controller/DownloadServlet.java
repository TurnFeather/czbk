package cn.itcast.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("aaaa");
		response.setContentType("text/html;charset=UTF-8");
		ServletOutputStream out =  response.getOutputStream();
		String fileName = request.getParameter("fileName");
		
		fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		
		System.out.println("fileName:" + fileName);
		//String fileName = null;
		
		//根据文件名从服务器获取该文件的绝对路径
		String path = getPath(getServletContext().getRealPath("/WEB-INF/files"),fileName);
		System.out.println("路径名：" + path);
		InputStream in = new FileInputStream(path);
		//判断文件是否存在
		File file = new File(path);
		if(!file.exists()){
			out.write("对不起！您下载的文件按可能已经不存在了".getBytes("UTF-8"));
			return;
		}
		
		//设置客户端打开文件方式为下载方式
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName.substring(fileName.indexOf("_") + 1));
		
		byte b[] = new byte[1024];
		int len = -1;
		while((len=in.read(b))!=-1){
			out.write(b, 0, len);
		}
		in.close();
	}

	private String getPath(String realPath,String fileName) {
		int hashCode = fileName.hashCode();
		int dir1 = hashCode&0xf;
		int dir2 = (hashCode&0xf0)>>4;
		
		return realPath + "//" + dir1 + "//" + dir2 + "//" + fileName;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
