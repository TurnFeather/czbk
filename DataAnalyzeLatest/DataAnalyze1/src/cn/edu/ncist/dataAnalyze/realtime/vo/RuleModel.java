package cn.edu.ncist.dataAnalyze.realtime.vo;

import cn.edu.ncist.dataAnalyze.realtime.web.DataAnalyzeAction.DataAfterRule;

public class RuleModel {
	
	int recordId;
	String recordTime;
	double temperature;
	double gas;
	double coaldust;

	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public String getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getGas() {
		return gas;
	}
	public void setGas(double gas) {
		this.gas = gas;
	}
	public double getCoaldust() {
		return coaldust;
	}
	public void setCoaldust(double coaldust) {
		this.coaldust = coaldust;
	}
	
	
	
}
