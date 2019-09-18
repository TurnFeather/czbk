package cn.edu.ncist.dataAnalyze.realtime.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerRuleEbi;
import cn.edu.ncist.dataAnalyze.realtime.rules.Accident;
import cn.edu.ncist.dataAnalyze.realtime.rules.Rule;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AccidentModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.FinLossModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.RuleModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.googlecode.jsonplugin.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class AcdFinLossAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SerAccidentEbi serAccidentEbi;
	private  List<FinLossModel> lst =null;
	private String result;

	public List<FinLossModel> getLst() {
		return lst;
	}

	public void setLst(List<FinLossModel> lst) {
		this.lst = lst;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	@JSON(serialize=false)
	public SerAccidentEbi getSerAccidentEbi() {
		return serAccidentEbi;
	}

	public void setSerAccidentEbi(SerAccidentEbi serAccidentEbi) {
		this.serAccidentEbi = serAccidentEbi;
	}



	public String execute() throws Exception {
		
	    
		  lst=serAccidentEbi.serFinLoss();
//		
		  List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
	
	     
	      for(FinLossModel record : lst){
	    	  Map<String, Object> e = new HashMap<String, Object>();
	    	
	    	  e.put("acdYear",record.getAcdYear());
	    	  e.put("jjsx",record.getDirectEconomicLoss());
	  		  list.add(e);
	  	  }
	      Map<String, Object> map = new HashMap<String, Object>();
	      map.put("list",list);
	  		
		 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		 result = gson.toJson(map);
	//	 System.out.println(result);
		//System.out.println("result"+result);
		
		 System.out.println(result);
	//List<Map<String,Object>>
		return "success";
		}
		
	
	

}
