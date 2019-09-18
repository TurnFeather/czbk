package cn.itcast.filter.autologin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Encoder;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = UserDB.findUser(username, password);
		if (user!=null){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//判断是否永久登录
			String isautologin = request.getParameter("autologin");
			if(isautologin!=null){
				Cookie cookie = new Cookie("logininfo", new BASE64Encoder().encode(username.getBytes()) + "_" + MD5Util.md5(password));
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(Integer.MAX_VALUE);
				response.addCookie(cookie);
			}
			response.sendRedirect(request.getContextPath() + "/autologin/index.jsp");		//如果登录成功，则转到主页。
		}else{
			
		}
		
	}

}
