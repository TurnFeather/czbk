package cn.itcast.hibernate.sh.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	public static SessionFactory sessionFactory;
	static{
		/**
		 * 创建configuration对象，准备加载配置文件
		 */
		Configuration configuration = new Configuration();
		/**
		 * 加载hibernate的配置文件
		 */
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}
}
