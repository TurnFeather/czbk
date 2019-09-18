package cn.edu.ncist.dataAnalyze.realtime.vo;

public class AcdReaToStanModel {
	
	String id; //表格id号
	String acdId; //事故id
	int stdReasonId; //事故发生省份
	double degree;//权重
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAcdId() {
		return acdId;
	}
	public void setAcdId(String acdId) {
		this.acdId = acdId;
	}
	
	public int getStdReasonId() {
		return stdReasonId;
	}
	public void setStdReasonId(int stdReasonId) {
		this.stdReasonId = stdReasonId;
	}
	public double getDegree() {
		return degree;
	}
	public void setDegree(double degree) {
		this.degree = degree;
	}
	
	
	//String equipmentCondition;
	//String driverCondition;
	
	
	
	

	
	
	

}
