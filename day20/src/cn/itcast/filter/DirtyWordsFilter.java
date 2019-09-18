package cn.itcast.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class DirtyWordsFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		DirtyWordsHttpServletRequest dhsr = new DirtyWordsHttpServletRequest(req);
		chain.doFilter(dhsr, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
}

class DirtyWordsHttpServletRequest extends HttpServletRequestWrapper{
	private String words[] = {"傻B","畜生","禽兽"};
	public DirtyWordsHttpServletRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);	//先从字符过滤器获取到值
		if (value == null){
			return "什么都没有";
		}
		
		for(String word : words){
			if (value.contains(word)){
				value = value.replaceAll(word, "**");
			}
		}
		
		return value;
	}
	
}
