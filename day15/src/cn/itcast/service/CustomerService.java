package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Customer;
import cn.itcast.domain.Page;
import cn.itcast.exception.IdIsNullException;

public interface CustomerService {
	public void addCustomer(Customer c);
	public void deleteCustomer(String customerId);
	public void updateCustomer(Customer c) throws IdIsNullException;
	public List<Customer> findAll();
	public Customer findCustomerById(String customerId);
	public Page findPageRecoders(String pagenum);
}
