package cn.edu.ncist.dataAnalyze.realtime.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAllAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerRuleEbi;
import cn.edu.ncist.dataAnalyze.realtime.rules.Accident;
import cn.edu.ncist.dataAnalyze.realtime.rules.Rule;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AccidentModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcdPriModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllProAcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllYearAcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.RuleModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.googlecode.jsonplugin.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class AllAcciYearAnalyzeAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private SerAccidentEbi serAccidentEbi;
	private SerAllAccidentEbi serAllAccidentEbi;
	private  List<AllYearAcciNumModel> lst =null;
	//private List<>
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public SerAllAccidentEbi getSerAllAccidentEbi() {
		return serAllAccidentEbi;
	}

	public void setSerAllAccidentEbi(SerAllAccidentEbi serAllAccidentEbi) {
		this.serAllAccidentEbi = serAllAccidentEbi;
	}

	public String execute() throws Exception {
		
	     
		  lst=serAllAccidentEbi.serYearAccident();
			  
		  List<Map<String,Object>> yearlist=new ArrayList<Map<String,Object>>();
		  List<Map<String,Object>> dielist=new ArrayList<Map<String,Object>>();
	     
	      for(AllYearAcciNumModel record : lst){
	    	  Map<String, Object> e = new HashMap<String, Object>();
	    	  Map<String, Object> e1 = new HashMap<String, Object>();
	    	  e.put("year",record.getYear());
	    	  e.put("acdnum",Integer.parseInt(record.getAcd_num()));
	    	  e1.put("dienum",Integer.parseInt(record.getDie_num()));
	    	  yearlist.add(e);
	    	  dielist.add(e1);
	    	 // prilist.add(e);
	  	  }

	   //   Map<String, Object> truemap = new HashMap<String, Object>();
	      Map<String, Object> promap = new HashMap<String, Object>();
	      promap.put("yearlist",yearlist);
	      promap.put("dielist",dielist);
	  	  
		 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		 result = gson.toJson(promap);
	//	 priresult = gson.toJson()
		 System.out.println(result);
		//System.out.println("result"+result);
		
		// System.out.println(result);
	//List<Map<String,Object>>
		return "success";
		}
		
	
	

}
