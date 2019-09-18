package cn.itcast.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.service.impl.CustomerServiceImpl;
import cn.itcast.util.FormBeanUtil;
import cn.itcast.web.formbean.CustomerFormBean;

//保存用户信息
public class AddCustomerServlet extends HttpServlet {
	private CustomerService s = new CustomerServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			//填充数据，验证数据，数据回显，错误提示：
			CustomerFormBean formBean = FormBeanUtil.fillFormBean(
					CustomerFormBean.class, request);
			if (!formBean.validate()) {
				request.setAttribute("formBean", formBean); //用于数据回显
				request.getRequestDispatcher("/addCustomer.jsp").forward(
						request, response);
			}
			//填充模型：FormBean -->>JavaBean
			Customer c = new Customer();
			ConvertUtils.register((Converter) new DateLocaleConverter(),
					Date.class);
			BeanUtils.copyProperties(c, formBean);
			//对爱好进行特殊处理
			if (formBean.getHobbies()!=null&&formBean.getHobbies().length>0)
			{
				StringBuffer buffer = new StringBuffer();
				for (int i=0;i<formBean.getHobbies().length;i++)
				{
					if (i > 0)
						buffer.append("c");
					buffer.append(formBean.getHobbies()[i]);
				}
				c.setHobby(buffer.toString());
			}
			
			//保存数据到数据库中
			s.addCustomer(c);
			request.setAttribute("message", "添加成功");
			request.getRequestDispatcher("/message.jsp").forward(
					request, response);
		} catch (Exception e) {
			request.setAttribute("message", "对不起！服务器忙");
			request.getRequestDispatcher("/message.jsp").forward(
					request, response);
			e.printStackTrace();
		}
	}

}
