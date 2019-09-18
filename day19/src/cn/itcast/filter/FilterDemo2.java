package cn.itcast.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//���ڴ���ֻ��һ�ݣ�פ���ڴ�
public class FilterDemo2 implements Filter {
	/*
	 * web����ر�ʱ���ô˷�������������һЩ��Դ
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {

	}
	/*
	 @param chain �˾�����ͨ��chain.doFilter(request,response)�����󽻸��¸�Filter��Servlet
	 */
	//����ÿһ�ε��û����ʶ��ᾭ���÷���
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("FilterDemo2����ǰ");
		arg2.doFilter(arg0, arg1);		//����
		System.out.println("FilterDemo2���غ�");
	}
	/*
	 * web��������ʱ���ô˷��������ڳ�ʼ����Filter
	 * @param config���ԴӸò����л�ȡ��ʼ�������Լ�ServletContext��Ϣ��
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {

	}

}
