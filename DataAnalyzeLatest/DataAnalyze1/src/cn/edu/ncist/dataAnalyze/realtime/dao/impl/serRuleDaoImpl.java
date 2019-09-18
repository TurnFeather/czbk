package cn.edu.ncist.dataAnalyze.realtime.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerRuleDao;
import cn.edu.ncist.dataAnalyze.realtime.vo.RuleModel;

public class serRuleDaoImpl extends HibernateDaoSupport implements SerRuleDao {

	@SuppressWarnings("unchecked")
	public List<RuleModel> serRule(String hql) {
		
		return this.getHibernateTemplate().find(hql);
		
	}

	public int serMaxRecordId() {
		String hql = "SELECT MAX(recordId) AS recordId FROM RuleModel";
		Integer maxRecordId = (Integer) getHibernateTemplate().find(hql).get(0);
		return maxRecordId;
	}

	public RuleModel serRecordById(int serId) {
		String hql = "FROM RuleModel WHERE recordId="+serId;
		RuleModel record = (RuleModel) getHibernateTemplate().find(hql).get(0);
		return record;
	}

	public String shuchu() {
		
		String success="³É¹¦";
		
		return success;
		
	}
	
	
}
