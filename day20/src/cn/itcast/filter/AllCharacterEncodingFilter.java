package cn.itcast.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class AllCharacterEncodingFilter implements Filter {
	private FilterConfig filterConfig;
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		String encodingValue = null;
		if ((encodingValue = filterConfig.getInitParameter("encoding"))!=null){
			encodingValue = "UTF-8";
		}
		//����post����ʽ��������������ı���
		request.setCharacterEncoding(encodingValue);	
		
		response.setCharacterEncoding(encodingValue);	//�ֽ������ʱ֪ͨ�ͻ��˵Ľ������
		response.setContentType("text/html;charset=" + encodingValue);//�ֽ������ʱ֪ͨ�ͻ��˵Ľ�������ַ������ַ������ʹ������Լ�֪ͨ�ͻ��˵Ľ������
		
		MyHttpServletRequest myreq = new MyHttpServletRequest(req);
		chain.doFilter(myreq, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
}

class MyHttpServletRequest extends HttpServletRequestWrapper{

	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if (value==null){
			return value;
		}
		
		if("get".equals(super.getMethod())){
			try {
				byte b[] = value.getBytes("iso-8859-1");
				value = new String(b, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}
	
}
