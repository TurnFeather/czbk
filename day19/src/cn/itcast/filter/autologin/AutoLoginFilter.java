package cn.itcast.filter.autologin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Decoder;

public class AutoLoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// System.out.println("aaa");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		if (u == null) {					//û�е�½�ŵ�½��
			Cookie[] cs = req.getCookies();		
			Cookie loginInfoCookie = null;
			if (cs != null) {
				for (Cookie c : cs) {
					if ("logininfo".equals(c.getName())) {
						loginInfoCookie = c;
						break;
					}
				}
			}
			if (loginInfoCookie != null) {
				String username_password = loginInfoCookie.getValue();
				System.out.println(username_password);
				String username = username_password.split("\\_")[0];
				String password = username_password.split("\\_")[1];
				// �����ݿ��в�����Ƚ�
				// System.out.println(username + "=" + password);
				User user = UserDB.findUser(new String(new BASE64Decoder().decodeBuffer(username)));//ͨ���û����������user
				if (user != null) {
					if (password.equals(MD5Util.md5(user.getPassword()))) {							//����У��
						// �������ƥ��ɹ�
						req.getSession().setAttribute("user", user);								//У�Գɹ�
						// System.out.println("bbb");
					}// ����ʲô������
				}// ����ʲô������
			}// ����ʲô������
		}
		chain.doFilter(request, response);															//�ύ��һ������
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
