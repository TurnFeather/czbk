package cn.edu.ncist.dataAnalyze.realtime.vo;

public class MeaAdviceModel {
	
	String actionAndAdvice; //��ʩ����
	String acdId; //�¹�Id
	int actionOrder;//��ʩ����˳���
	String actionId; //��ʩid
	
	
	
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
