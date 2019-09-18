package cn.edu.ncist.dataAnalyze.realtime.bussiness.ebo;

import java.util.List;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerRuleEbi;
import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerRuleDao;
import cn.edu.ncist.dataAnalyze.realtime.vo.RuleModel;

public class SerRuleEbo implements SerRuleEbi {

	private SerRuleDao serRuleDao;
	
	public SerRuleDao getSerRuleDao() {
		return serRuleDao;
	}

	public void setSerRuleDao(SerRuleDao serRuleDao) {
		this.serRuleDao = serRuleDao;
	}

	public List<RuleModel> serRule(String hql) {
		
		return serRuleDao.serRule(hql);
	}

	public int serMaxRecordId() {
		
		return serRuleDao.serMaxRecordId();
	}

	public RuleModel SerRecordById(int serId) {
	
		return serRuleDao.serRecordById(serId);
	}

	public String shuchu() {
	   return serRuleDao.shuchu();
	}
	
}
