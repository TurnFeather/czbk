package cn.itcast.filter.example;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NeedCacheFilter implements Filter {
	private FilterConfig filterConfig;
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		int time = 0;
		String s = req.getRequestURI().substring(req.getRequestURI().lastIndexOf(".")+1);
		if ("html".equals(s)){
			String paramValue = filterConfig.getInitParameter("html");
			if (paramValue == null)
				time = 1;
			else
				time = Integer.parseInt(paramValue);
		}else if("css".equals(s)){
			String paramValue = filterConfig.getInitParameter("css");
			if (paramValue == null)
				time = 1;
			else
				time = Integer.parseInt(paramValue);
		}else if("js".equals(s)){
			String paramValue = filterConfig.getInitParameter("js");
			if (paramValue == null)
				time = 1;
			else
				time = Integer.parseInt(paramValue);
		}
		res.setDateHeader("Expires", System.currentTimeMillis() + time*60*60*1000);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
