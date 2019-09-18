package cn.edu.ncist.dataAnalyze.realtime.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcciExperienceModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AccidentModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.MeaAdviceModel;

import com.opensymphony.xwork2.ActionSupport;

public class AcciDetailAction extends ActionSupport{
	
	private SerAccidentEbi serAccidentEbi;
	private List<AccidentModel> acdDetailList;
	private List<AcciExperienceModel> acdExpList;
	private List<MeaAdviceModel> meaList;
	private String acdId;
	private HttpServletRequest request;
	private List<String> authority_list = new ArrayList<String>();
	private List<String> advice_list = new ArrayList<String>();
	//经验字符串
	String expsb ="无"; //事故经验字符串
	String meast ="无"; //事故措施和建议字符串
	
	public String getAcdId() {
		return acdId;
	}

	public void setAcdId(String acdId) {
		this.acdId = acdId;
	}

	public SerAccidentEbi getSerAccidentEbi() {
		return serAccidentEbi;
	}

	public void setSerAccidentEbi(SerAccidentEbi serAccidentEbi) {
		this.serAccidentEbi = serAccidentEbi;
	}

	public List<AccidentModel> getAcdDetailList() {
		return acdDetailList;
	}

	public void setAcdDetailList(List<AccidentModel> acdDetailList) {
		this.acdDetailList = acdDetailList;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	
	
	public List<AcciExperienceModel> getAcdExpList() {
		return acdExpList;
	}

	public void setAcdExpList(List<AcciExperienceModel> acdExpList) {
		this.acdExpList = acdExpList;
	}
	

	public List<String> getAuthority_list() {
		return authority_list;
	}

	public void setAuthority_list(List<String> authorityList) {
		authority_list = authorityList;
	}

	public List<MeaAdviceModel> getMeaList() {
		return meaList;
	}

	public void setMeaList(List<MeaAdviceModel> meaList) {
		this.meaList = meaList;
	}

	public List<String> getAdvice_list() {
		return advice_list;
	}

	public void setAdvice_list(List<String> adviceList) {
		advice_list = adviceList;
	}

	public String getExpsb() {
		return expsb;
	}

	public void setExpsb(String expsb) {
		this.expsb = expsb;
	}

	public String getMeast() {
		return meast;
	}

	public void setMeast(String meast) {
		this.meast = meast;
	}

	public String execute(){
	
		 acdDetailList=serAccidentEbi.serDetailAcd(acdId);
		 acdExpList=serAccidentEbi.serExperience(acdId);
		 meaList=serAccidentEbi.serMeadvice(acdId);
	
		 if(acdExpList.size()>=1){
			 expsb="";
		 }
		 if( meaList.size()>=1){
			 meast="";
			 
		 }
		 for(AcciExperienceModel exrecord : acdExpList)
		 {  // String s=exrecord.getAcdLesson();
			 expsb=expsb+exrecord.getAcdLesson();
			// System.out.println(exrecord.getAcdLesson());
		 }
		 for(MeaAdviceModel mrecord :  meaList){
			 meast=meast+mrecord.getActionAndAdvice();
		 }
	//	System.out.println( expsb);
		authority_list.add(expsb);
		advice_list.add(meast);
		if(acdDetailList==null)
		{
			System.out.println("null");
			return "fail";
		}
		else if(acdDetailList.size()==0){
			System.out.println("empty");
			return "fali";
		}
		else{
			//System.out.println("list的size为"+acdDetailList.size());
		return "success";
		}
		
		
	}
	
	

}
