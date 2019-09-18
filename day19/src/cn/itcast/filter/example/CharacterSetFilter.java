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
		if (encodingValue==null){//���û�����øò���������Ĭ��ֵutf-8
			encodingValue = "UTF-8";
		}
		request.setCharacterEncoding(encodingValue);	//ֻ��post����ʽ����
		response.setContentType("text/html;charset=" + encodingValue);
		chain.doFilter(request, response);		//�����󴫸���һ��Filter����Servlet

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}