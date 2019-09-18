package cn.edu.ncist.dataAnalyze.realtime.web;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerRuleEbi;
import cn.edu.ncist.dataAnalyze.realtime.vo.RuleModel;

import com.googlecode.jsonplugin.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class SerRecordByIdAction extends ActionSupport {

	SerRuleEbi serRuleEbi;
	int serId;
	String recordTime;
	double temperature;
	double gas;
	double coaldust;
	
	@JSON(serialize=false)
	public SerRuleEbi getSerRuleEbi() {
		return serRuleEbi;
	}
	public void setSerRuleEbi(SerRuleEbi serRuleEbi) {
		this.serRuleEbi = serRuleEbi;
	}
	@JSON(serialize=false)
	public int getSerId() {
		return serId;
	}
	public void setSerId(int serId) {
		this.serId = serId;
	}
	@JSON(name="RTIME")
	public String getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	@JSON(name="RTEMP")
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	@JSON(name="RGAS")
	public double getGas() {
		return gas;
	}
	public void setGas(double gas) {
		this.gas = gas;
	}
	@JSON(name="RCDUST")
	public double getCoaldust() {
		return coaldust;
	}
	public void setCoaldust(double coaldust) {
		this.coaldust = coaldust;
	}
	@Override
	public String execute() throws Exception {
		
		RuleModel record = serRuleEbi.SerRecordById(serId);
		setRecordTime(record.getRecordTime());
		setTemperature(record.getTemperature());
		setGas(record.getGas());
		setCoaldust(record.getCoaldust());
		return "recordById";
	}
	
	
}
