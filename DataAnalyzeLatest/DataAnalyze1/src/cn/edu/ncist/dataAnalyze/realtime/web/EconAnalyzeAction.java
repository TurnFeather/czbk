package cn.edu.ncist.dataAnalyze.realtime.web;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerEconEbi;


import com.opensymphony.xwork2.ActionSupport;

public class EconAnalyzeAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SerEconEbi serEconEbi;
	
	
	public SerEconEbi getSerEconEbi() {
		return serEconEbi;
	}


	public void setSerEconEbi(SerEconEbi serEconEbi) {
		this.serEconEbi = serEconEbi;
	}


	public String execute() throws Exception {
		
		String success= serEconEbi.shuchu();
		
		System.out.println(success);
		
		return success;
		
		
	}
	
	

}
