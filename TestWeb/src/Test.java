import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Test extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/*
		Enumeration e = request.getHeaderNames();
		String protocolName = request.getProtocol();
		System.out.println(protocolName);
		System.out.println("Servlet's name is " + request.getServerName());
		response.getWriter().write("Ok I'm coming");
		response.sendError(404, "The page not exist");*/
		/*
		response.setContentType("application/msword;charset=gb2312");
		response.getWriter().write("平平淡淡才是真，快快乐乐才是福");
		request.getSession().setAttribute(arg0, arg1);
		*/
		Enumeration e = getServletContext().getInitParameterNames();
		while(e.hasMoreElements()){
			String name = (String)e.nextElement();
			String value = getServletContext().getInitParameter(name);
			System.out.println(name + "=" + value);
		}
		//response.getWriter();
	}

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
