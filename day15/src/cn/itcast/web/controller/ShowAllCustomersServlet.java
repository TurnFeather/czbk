package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Page;
import cn.itcast.service.CustomerService;
import cn.itcast.service.impl.CustomerServiceImpl;
//查询所有的客户信息
public class ShowAllCustomersServlet extends HttpServlet {
	private CustomerService service = new CustomerServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("text/html;charset=UTF-8");
		//List<Customer> cs = service.findAll();
		
		//request.setAttribute("cs", cs);
		String pagenum = request.getParameter("pagenum");
		Page page = service.findPageRecoders(pagenum);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/listCustomers2.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
