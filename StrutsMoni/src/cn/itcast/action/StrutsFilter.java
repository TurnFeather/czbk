package cn.itcast.action;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StrutsFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		//ǿת
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse reps = (HttpServletResponse)arg1;
		
		String s = req.getServletPath();
		System.out.println(s);
		if (s.equals("/test.jsp"))
		{
			System.out.println("????");
			arg2.doFilter(arg0, arg1);
		}
		else
		{
			UserAction userAction = new UserAction();
			userAction.execute();
			req.getRequestDispatcher("/success.jsp").forward(req, reps);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
