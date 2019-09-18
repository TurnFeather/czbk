package cn.itcast.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//其它读取资源文件的方式
public class ServletDemo7 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Test7();
	}
	
	//利用类加载器读取a3.properties配置文件
			private void Test7() throws FileNotFoundException, IOException 
			{
				ClassLoader cl = ServletDemo7.class.getClassLoader();	//得到ServlerDemo7的类加载器
				InputStream in = cl.getResourceAsStream("cn/itcast/resources/a3.properties");
				Properties ps = new Properties();
				ps.load(in);
				String username = ps.getProperty("username");
				System.out.println(username);
			}
			
	
	//利用类加载器读取a2.properties配置文件
		private void Test6() throws FileNotFoundException, IOException 
		{
			ClassLoader cl = ServletDemo7.class.getClassLoader();	//得到ServlerDemo7的类加载器
			InputStream in = cl.getResourceAsStream("a2.properties");
			Properties ps = new Properties();
			ps.load(in);
			String username = ps.getProperty("username");
			System.out.println(username);
		}
		
	
	//利用ResourceBundle读取配置文件
		private void Test5() throws FileNotFoundException, IOException {
			//利用ServletContext读取a3.properties
			ResourceBundle rb = ResourceBundle.getBundle("cn.itcast.resources.a3");	//基名
			String username = rb.getString("username");
			System.out.println(username);
		}
	
	//利用ResourceBundle读取配置文件
	private void Test4() throws FileNotFoundException, IOException {
		//利用ServletContext读取a3.properties
		ResourceBundle rb = ResourceBundle.getBundle("a2");	//基名
		String username = rb.getString("username");
		System.out.println(username);
	}
	
	private void Test3() throws FileNotFoundException, IOException {
		//利用ServletContext读取a1.properties
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/WEB-INF/a2.properties");
		System.out.println(path);
		InputStream in = new FileInputStream(path);
		Properties ps =  new Properties();
		ps.load(in);
		String username = (String)ps.getProperty("username");
		System.out.println(username);
	}
	
	private void Test2() throws FileNotFoundException, IOException {
		//利用ServletContext读取a1.properties
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/WEB-INF/classes/a2.properties");
		System.out.println(path);
		InputStream in = new FileInputStream(path);
		Properties ps =  new Properties();
		ps.load(in);
		String username = (String)ps.getProperty("username");
		System.out.println(username);
	}

	private void Test1() throws FileNotFoundException, IOException {
		//利用ServletContext读取a1.properties
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/WEB-INF/a1.properties");
		System.out.println(path);
		InputStream in = new FileInputStream(path);
		Properties ps =  new Properties();
		ps.load(in);
		String username = (String)ps.getProperty("username");
		System.out.println(username);
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
