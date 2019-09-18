package cn.edu.ncist.dataAnalyze.realtime.vo;

public class ReasonToStandModel 
{
	private String id;
	private String acdId;
	private int stdReasonId;
	private String degree;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the acdId
	 */
	public String getAcdId() {
		return acdId;
	}
	/**
	 * @param acdId the acdId to set
	 */
	public void setAcdId(String acdId) {
		this.acdId = acdId;
	}

	public int getStdReasonId() {
		return stdReasonId;
	}
	public void setStdReasonId(int stdReasonId) {
		this.stdReasonId = stdReasonId;
	}
	public String getDegree() {
		return degree;
	}
	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	
}
