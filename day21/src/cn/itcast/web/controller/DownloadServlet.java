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
		
		//�����ļ����ӷ�������ȡ���ļ��ľ���·��
		String path = getPath(getServletContext().getRealPath("/WEB-INF/files"),fileName);
		System.out.println("·������" + path);
		InputStream in = new FileInputStream(path);
		//�ж��ļ��Ƿ����
		File file = new File(path);
		if(!file.exists()){
			out.write("�Բ��������ص��ļ��������Ѿ���������".getBytes("UTF-8"));
			return;
		}
		
		//���ÿͻ��˴��ļ���ʽΪ���ط�ʽ
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
