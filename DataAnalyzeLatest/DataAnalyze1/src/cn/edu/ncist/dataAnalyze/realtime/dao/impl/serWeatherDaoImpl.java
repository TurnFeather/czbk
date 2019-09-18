package cn.edu.ncist.dataAnalyze.realtime.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerWeatherDao;
import cn.edu.ncist.dataAnalyze.realtime.vo.SituationModel;

public class serWeatherDaoImpl extends HibernateDaoSupport implements SerWeatherDao {

	@SuppressWarnings("unchecked")
	public List<SituationModel> serWeather1() {


		String hql="FROM SituationModel";
		
		return this.getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	public List<SituationModel> serWeather2() {

		String hql="from SituationModel by id desc limit 1";
		System.out.println("是不是来到了访问2这里");
		
		return this.getHibernateTemplate().find(hql);
	}

}
