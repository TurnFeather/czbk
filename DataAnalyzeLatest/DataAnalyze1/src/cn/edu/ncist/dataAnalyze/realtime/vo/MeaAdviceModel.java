package cn.edu.ncist.dataAnalyze.realtime.vo;

public class MeaAdviceModel {
	
	String actionAndAdvice; //措施建议
	String acdId; //事故Id
	int actionOrder;//措施建议顺序号
	String actionId; //措施id
	
	
	
	public String getActionAndAdvice() {
		return actionAndAdvice;
	}
	public void setActionAndAdvice(String actionAndAdvice) {
		this.actionAndAdvice = actionAndAdvice;
	}
	public int getActionOrder() {
		return actionOrder;
	}
	public void setActionOrder(int actionOrder) {
		this.actionOrder = actionOrder;
	}
	public String getActionId() {
		return actionId;
	}
	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
	public String getAcdId() {
		return acdId;
	}
	public void setAcdId(String acdId) {
		this.acdId = acdId;
	}
}
