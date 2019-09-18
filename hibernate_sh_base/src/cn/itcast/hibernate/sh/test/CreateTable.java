package cn.itcast.hibernate.sh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itcast.hibernate.sh.domain.Person;

public class CreateTable {
	@Test
	public void testCrerateTable()
	{
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Person p = new Person();
		p.setPname("余荣城");
		p.setPsex("男");
		/**
		 * 参数必须持久化对象
		 */
		session.save(p);
		
		
		transaction.commit();
		session.close();
	}
}
