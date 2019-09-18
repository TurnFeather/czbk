package cn.edu.ncist.dataAnalyze.realtime.web;

import java.util.ArrayList;
import java.util.List;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerRuleEbi;
import cn.edu.ncist.dataAnalyze.realtime.rules.Rule;
import cn.edu.ncist.dataAnalyze.realtime.vo.RuleModel;

import com.googlecode.jsonplugin.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class DataAnalyzeAction extends ActionSupport {
	
	
	private SerRuleEbi serRuleEbi;
	int recordId;
	int maxRecordId;
	String recordTime;
	private String Msg;
	private boolean status; 

	@JSON(name="STATUS")
	public boolean getStatus() {
		return DataAfterRule.getStatus();
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@JSON(serialize=false)
	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	@JSON(name="TIME")
	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}

	@JSON(name="MSG")
	public String getMsg() {
		return Msg;
	}

	@JSON(name="MAXID")
	public int getMaxRecordId() {
		return maxRecordId;
	}

	public void setMaxRecordId(int maxRecordId) {
		this.maxRecordId = maxRecordId;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	@JSON(serialize=false)
	public SerRuleEbi getSerRuleEbi() {
		return serRuleEbi;
	}

	public void setSerRuleEbi(SerRuleEbi serRuleEbi) {
		this.serRuleEbi = serRuleEbi;
	}
	
	@Override
	public String execute() throws Exception {
		
		setStatus(false);
		
		maxRecordId = serRuleEbi.serMaxRecordId();
		String success=serRuleEbi.shuchu();
		System.out.println(success);
		RuleModel record = serRuleEbi.SerRecordById(maxRecordId);
		setRecordTime(record.getRecordTime());
		System.out.println("maxRecordId~~~~~~~"+maxRecordId);
		if(maxRecordId!=recordId){
			Rule rule = new Rule();	
//			String hql = "from cn.edu.ncist.dataAnalyze.realtime.vo.RuleModel as r where r.recordId="+maxRecordId;
//
//			RuleModel ruleModel = new RuleModel();
//			List<RuleModel> rulelist = new ArrayList<RuleModel>();
//			rulelist = serRuleEbi.serRule(hql); 
//			for(RuleModel record : rulelist){
////				ruleModel = record;
//				setRecordTime(record.getRecordTime());
//				rule.check(record);	
//			}
			rule.check(record);
			
			Msg = DataAfterRule.getMsgSB().toString();
			
			DataAfterRule.getMsgSB().delete(0, DataAfterRule.getMsgSB().length());
		}
	
		return "data";
	}
	
	public static class DataAfterRule{
		public static StringBuilder MsgSB = new StringBuilder();
		public static boolean status;

		public static boolean getStatus() {
			return status;
		}

		public static void setStatus(boolean tempstatus) {
			status = tempstatus;
		}

		public static StringBuilder getMsgSB() {
			return MsgSB;
		}
		
		public static void setMsgSB(String msg) {
			MsgSB.append(msg);
		}
	}
	
}
