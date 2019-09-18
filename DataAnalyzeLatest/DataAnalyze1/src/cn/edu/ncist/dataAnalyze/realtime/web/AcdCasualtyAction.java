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
import cn.edu.ncist.dataAnalyze.realtime.vo.CasualtyModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.RuleModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.googlecode.jsonplugin.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class AcdCasualtyAction extends ActionSupport{
	
	/**
	 *
	 *
	 */
	private static final long serialVersionUID = 1L;
	private SerAccidentEbi serAccidentEbi;
	private  List<CasualtyModel> lst =null;
	private String result;

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

	
	
	public List<CasualtyModel> getLst() {
		return lst;
	}

	public void setLst(List<CasualtyModel> lst) {
		this.lst = lst;
	}

	public String execute() throws Exception {
		
	    
		  lst=serAccidentEbi.serCasualty();
	
		  List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
	
	     
	      for(CasualtyModel record : lst){
	    	  Map<String, Object> e = new HashMap<String, Object>();
	    	
	    	  e.put("acdYear",record.getAcdYear());
	    	  e.put("swrs",record.getSwrs());
	  		  list.add(e);
	  	  }
	      Map<String, Object> map = new HashMap<String, Object>();
	      map.put("list",list);
	  		
		 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		 result = gson.toJson(map);
		// System.out.println(result);
		return "success";
		}
		
	
	

}
