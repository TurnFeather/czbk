package cn.itcast.service.impl;

import java.util.List;
import java.util.UUID;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.Impl.CustomerDaoImpl;
import cn.itcast.domain.Customer;
import cn.itcast.domain.Page;
import cn.itcast.exception.IdIsNullException;
import cn.itcast.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao dao = new CustomerDaoImpl();
	public void addCustomer(Customer c) {
		c.setId(UUID.randomUUID().toString());
		dao.addCustomer(c);
	}

	public void deleteCustomer(String customerId) {
		dao.deleteCustomer(customerId);
	}

	public void updateCustomer(Customer c) throws IdIsNullException {
		dao.updateCustomer(c);

	}

	public List<Customer> findAll() {
		
		return dao.findAll();
	}

	public Customer findCustomerById(String customerId) {
		
		return dao.findCustomerById(customerId);
	}

	public Page findPageRecoders(String pagenum) {
		int num = 1;
		if (pagenum!=null &&!"".equals(pagenum.trim()))
		{
			num = Integer.parseInt(pagenum);
		}
		int totalrecords = dao.getTotalrecords();
		Page page = new Page(num, totalrecords);
		List recorders = dao.findCustomerByPageNum(page.getStartIndex(), page.getPagesize());
		page.setRecorders(recorders);
		return page;
	}

}
