package cn.itcast.session.app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.cookie.app3.Book;
//��ʾ���ﳵ�е���Ʒ
public class ShowCartServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);	//�п�����null
		if (session == null)
		{
			out.write("�Բ�����û�й����κ���Ʒ");
			return;
		}
		List<Book> cart = (List<Book>)session.getAttribute("cart");
		if (cart == null || cart.size() < 1)
		{
			out.write("�Բ�����û�й����κ���Ʒ");
			return;
		}
		out.write("�㹺�����Ʒ����<br/>");
		for (Book b : cart)
		{
			out.write(b.getName() + "<br/>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}
}
