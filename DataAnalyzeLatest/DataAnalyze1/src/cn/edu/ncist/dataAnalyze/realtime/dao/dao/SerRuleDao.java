package cn.edu.ncist.dataAnalyze.realtime.dao.dao;

import java.util.List;

import cn.edu.ncist.dataAnalyze.realtime.vo.RuleModel;

public interface SerRuleDao {

	List<RuleModel> serRule(String hql);

	int serMaxRecordId();

	RuleModel serRecordById(int serId);
	
	String shuchu();
}
