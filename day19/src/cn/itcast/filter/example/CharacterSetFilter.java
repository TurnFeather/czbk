package cn.itcast.filter.example;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterSetFilter implements Filter {
	private FilterConfig filterConfig;
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String encodingValue = filterConfig.getInitParameter("encoding");
		if (encodingValue==null){//如果没有配置该参数，给定默认值utf-8
			encodingValue = "UTF-8";
		}
		request.setCharacterEncoding(encodingValue);	//只对post请求方式有用
		response.setContentType("text/html;charset=" + encodingValue);
		chain.doFilter(request, response);		//将请求传给下一个Filter或者Servlet

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
