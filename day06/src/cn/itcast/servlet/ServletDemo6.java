package cn.itcast.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo6 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Test2(response);
	}
	
	//中文文件下载
	private void Test2(HttpServletResponse response)
			throws FileNotFoundException, IOException {
		//得到要下载的文件
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/蓝底照片.jpg");
		System.out.println(path);
		String filename = path.substring(path.lastIndexOf("\\") + 1);
		System.out.println(filename);
		//构建输入流
		InputStream in = new FileInputStream(path);
		//通知客户端以下载的方式打开
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);//中文文件名此处要进行URL编码
		response.setHeader("Content-Type", "application/octet-stream");
		//得到输出流
		OutputStream out = response.getOutputStream();
		int len = -1;
		byte[] b = new byte[1024];
		while ((len = in.read(b)) != -1)
		{
			out.write(b, 0, len);
		}
		in.close();
		out.close();
	}
	
	//最简单的文件下载
	private void Test1(HttpServletResponse response)
			throws FileNotFoundException, IOException {
		//得到要下载的文件
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/11.jpg");
		System.out.println(path);
		//构建输入流
		InputStream in = new FileInputStream(path);
		//通知客户端以下载的方式打开
		response.setHeader("Content-Disposition", "attachment;filename=11.jpg");
		response.setHeader("Content-Type", "application/octet-stream");
		//得到输出流
		OutputStream out = response.getOutputStream();
		int len = -1;
		byte[] b = new byte[1024];
		while ((len = in.read(b)) != -1)
		{
			out.write(b, 0, len);
		}
		in.close();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
