package cn.itcast.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//在内存中只有一份，驻留内存
public class FilterDemo1 implements Filter {
	/*
	 * web程序关闭时调用此方法，用于销毁一些资源
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {

	}
	/*
	 @param chain 滤镜链，通过chain.doFilter(request,response)将请求交给下个Filter或Servlet
	 */
	//对于每一次的用户访问都会经过该方法
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("FilterDemo1拦截前");
		arg2.doFilter(arg0, arg1);		//放行
		System.out.println("FilterDemo1拦截后");
	}
	/*
	 * web程序启动时调用此方法，用于初始化该Filter(应用被加载的时候初始化)
	 * @param config可以从该参数中获取初始化参数以及ServletContext信息等
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("FilterDemo1被初始化了");
	}

}
