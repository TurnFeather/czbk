package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Customer;
import cn.itcast.domain.Page;
import cn.itcast.exception.IdIsNullException;

public interface CustomerDao {
	public void addCustomer(Customer c);
	
	public void deleteCustomer(String customerId);
	
	public void updateCustomer(Customer c) throws IdIsNullException;
	
	@Deprecated
	public List<Customer> findAll();
	
	public Customer findCustomerById(String customerId);
	
	//分页所需要的方法
	public int getTotalrecords();
	
	public List findCustomerByPageNum(int startIndex,int pagesize);
}
