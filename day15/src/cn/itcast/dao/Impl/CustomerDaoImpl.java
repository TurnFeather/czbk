package cn.itcast.dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dbassist.DBAssist;
import cn.itcast.dbassist.handler.BeanHandler;
import cn.itcast.dbassist.handler.ResultSetHandler;
import cn.itcast.domain.Customer;
import cn.itcast.domain.Page;
import cn.itcast.exception.DaoException;
import cn.itcast.exception.IdIsNullException;
import cn.itcast.util.DBCPUtil;
import cn.itcast.util.JdbcUtil;

public class CustomerDaoImpl implements CustomerDao {
	DBAssist ds = new DBAssist(DBCPUtil.getDataSource());
	public void addCustomer(Customer c) {
		String sql = "insert into customer(id,name,gender,birthday,cellphone,email,hobby,type,description) values(?,?,?,?,?,?,?,?,?)";
		ds.update(sql, new Object[]{c.getId(),c.getName(), c.getGender(), new Date(c.getBirthday().getTime()), c.getCellphone(), c.getEmail(), c.getHobby(), c.getType(), c.getDescription()});
	}

	public void deleteCustomer(String customerId) {
		String sql = "delete from customer where id=?";
		ds.update(sql, new Object[]{customerId});
	}

	public void updateCustomer(Customer c)  throws IdIsNullException{
		String sql = "update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,hobby=?,type=?,description=? where id=?";
		ds.update(sql, new Object[]{c.getName(), c.getGender(), new Date(c.getBirthday().getTime()), c.getCellphone(), c.getEmail(), c.getHobby(), c.getType(), c.getDescription(), c.getId()});
	}

	public List<Customer> findAll() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();
		Customer c = null;
		try
		{
			conn = JdbcUtil.getConnection();
			String sql = "select id,name,gender,birthday,cellphone,email,hobby,type,description from customer";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()){
				c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setEmail(rs.getString("email"));
				c.setHobby(rs.getString("hobby"));
				c.setType(rs.getString("type"));
				c.setDescription(rs.getString("description"));
				list.add(c);
			}
		}catch(Exception e)
		{
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, st, conn);
		}
		return list;
	}

	public Customer findCustomerById(String customerId) {
		if (customerId == null)
			throw new IllegalArgumentException();
		String sql = "select id,name,gender,birthday,cellphone,email,hobby,type,description from customer where id=?";	
		return (Customer)ds.query(sql, new Object[]{customerId},new BeanHandler(Customer.class));
	}
	
	public int getTotalrecords() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try
		{
			conn = JdbcUtil.getConnection();
			String sql = "select count(*) from customer";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			if (rs.next()){
				return rs.getInt(1);
			}else
				return 0;
		}catch(Exception e)
		{
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, st, conn);
		}
	}

	public List findCustomerByPageNum(int startIndex,int pagesize) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List recorders = new ArrayList();
		Customer c = null;
		try
		{
			conn = JdbcUtil.getConnection();
			//select * from customer LIMIT 0,2
			String sql = "select id,name,gender,birthday,cellphone,email,hobby,type,description from customer LIMIT ?,?";
			st = conn.prepareStatement(sql);
			st.setInt(1, startIndex);
			st.setInt(2, pagesize);
			rs = st.executeQuery();
			while (rs.next()){
				c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setEmail(rs.getString("email"));
				c.setHobby(rs.getString("hobby"));
				c.setType(rs.getString("type"));
				c.setDescription(rs.getString("description"));
				recorders.add(c);
			}
		}catch(Exception e)
		{
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, st, conn);
		}
		return recorders;
	}
}
