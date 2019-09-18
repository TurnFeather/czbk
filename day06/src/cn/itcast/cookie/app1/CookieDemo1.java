package cn.itcast.cookie.app1;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����Cookie��������ס�û������һ�εķ���ʱ��
public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//��ʾ�ϴμ�¼��ʱ��
		Cookie cookies[] = request.getCookies();
		response.getWriter().write("��ӭ������վ");
		for (int i=0;cookies!=null && i<cookies.length;i++)
		{
			if (cookies[i].getName().equals("lastAccessTime"));
			{
				String value = cookies[i].getValue();		//����ֵ
				long time = Long.parseLong(value);
				//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				//response.getWriter().write("���ϴη��ʵ�ʱ��Ϊ:" + df.format(new Date(time)));
				response.getWriter().write("���ϴη��ʵ�ʱ��Ϊ:" + (new Date(time)).toLocaleString() + "<a href='/day06/servlet/DeleteServlet'>���ɾ��</a>");
			}
		}
		
		//��ͻ���һ�������Cookie��ȡֵΪ��ǰ�ķ���ʱ��
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		cookie.setMaxAge(Integer.MAX_VALUE);
		System.out.println(request.getContextPath());
		cookie.setPath(request.getContextPath());	//request.getContextPath()��ù�������Ŀ¼����
		response.addCookie(cookie);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
