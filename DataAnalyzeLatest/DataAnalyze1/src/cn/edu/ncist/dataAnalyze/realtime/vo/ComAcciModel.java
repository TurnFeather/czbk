package cn.edu.ncist.dataAnalyze.realtime.vo;

public class ComAcciModel {
	
	//int NUM; //�¹ʷ�������
	String acdYear; //�¹ʷ������
	int swrs;
	int acci_num;
	float directEconomicLoss;
	
	
	public int getSwrs() {
		return swrs;
	}
	public void setSwrs(int swrs) {
		this.swrs = swrs;
	}
	public int getAcci_num() {
		return acci_num;
	}
	public void setAcci_num(int acciNum) {
		acci_num = acciNum;
	}
	public float getDirectEconomicLoss() {
		return directEconomicLoss;
	}
	public void setDirectEconomicLoss(float directEconomicLoss) {
		this.directEconomicLoss = directEconomicLoss;
	}
	public String getAcdYear() {
		return acdYear;
	}
	public void setAcdYear(String acdYear) {
		this.acdYear = acdYear;
	}
	
}
