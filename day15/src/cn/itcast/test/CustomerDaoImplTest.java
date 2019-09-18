package cn.itcast.test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import junit.framework.Assert;

import org.junit.Test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.Impl.CustomerDaoImpl;
import cn.itcast.domain.Customer;
import cn.itcast.exception.IdIsNullException;

public class CustomerDaoImplTest {
	private CustomerDao dao = new CustomerDaoImpl();
	@Test
	public void testAddCustomer() {
		Customer c = new Customer(UUID.randomUUID().toString(),"yuron","1",new Date(),"15732684537","1406542607@qq.com","movies","VIP","haha");
		dao.addCustomer(c);
	}

	@Test
	public void testDeleteCustomer() {
		dao.deleteCustomer("657130b5-31d1-4dc0-a63f-6711013f1054");
	}

	@Test
	public void testUpdateCustomer() throws IdIsNullException {
		Customer c = new Customer("0597d1b9-d2ee-4c35-91d6-2c5c1dbd338e","yuron","1",new Date(),"12306","aaaddd607@qq.com","sport","VIP","haha");
		dao.updateCustomer(c);
	}

	@Test
	public void testFindAll() {
		List<Customer> list = dao.findAll();
		Assert.assertEquals(1, list.size());
	}
	@Test
	public void testFindCustomerById() {
		Customer c = null;
		c = dao.findCustomerById("657130b5-31d1-4dc0-a63f-6711013f1054");
		Assert.assertNotNull(c);
		c = dao.findCustomerById("054");
		Assert.assertNull(c);
	}

}
