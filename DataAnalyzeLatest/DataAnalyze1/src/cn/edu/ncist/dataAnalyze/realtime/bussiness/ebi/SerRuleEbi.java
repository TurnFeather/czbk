package cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi;

import java.util.List;

import cn.edu.ncist.dataAnalyze.realtime.vo.RuleModel;

public interface SerRuleEbi {
	
	List<RuleModel> serRule(String hql);

	int serMaxRecordId();

	RuleModel SerRecordById(int serId);
	
	String shuchu();
}
