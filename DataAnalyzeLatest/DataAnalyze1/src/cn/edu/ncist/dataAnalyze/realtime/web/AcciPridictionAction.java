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
import cn.edu.ncist.dataAnalyze.realtime.vo.AcdPriModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.RuleModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.googlecode.jsonplugin.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class AcciPridictionAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SerAccidentEbi serAccidentEbi;
	private  List<AcciNumModel> lst =null;
	private String result;
	private String priresult;
	private int priacd_num;


	
	
	

	public int getPriacd_num() {
		return priacd_num;
	}

	public void setPriacd_num(int priacdNum) {
		priacd_num = priacdNum;
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

	
	

	public List<AcciNumModel> getLst() {
		return lst;
	}

	public void setLst(List<AcciNumModel> lst) {
		this.lst = lst;
	}
    
	public String getPriresult() {
		return priresult;
	}

	public void setPriresult(String priresult) {
		this.priresult = priresult;
	}

	public String execute() throws Exception {
		
	     
		  lst=serAccidentEbi.serAccident();
		  String recentYear = (Integer.parseInt(serAccidentEbi.getRetYear())+1)+"";
		  System.out.println("recentYear:"+recentYear);
//		  
		  List<Map<String,Object>> truelist=new ArrayList<Map<String,Object>>();
		  List<Map<String,Object>> prilist=new ArrayList<Map<String,Object>>();
	     
	      for(AcciNumModel record : lst){
	    	  Map<String, Object> e = new HashMap<String, Object>();
	    	  Map<String, Object> e1 = new HashMap<String, Object>();
	    	  e.put("acdYear",record.getAcdYear());
	    	  e.put("num",record.getNUM());
	    	  e1.put("acdYear",record.getAcdYear());
	    	  e1.put("num",0);
	    	  truelist.add(e);
	    	  prilist.add(e1);
	  	  }
	      priacd_num=serAccidentEbi.serAcdPridiction(12);
	      Map<String, Object> e = new HashMap<String, Object>();
	      
	      e.put("acdYear",recentYear);
	      e.put("num",priacd_num);
	      
	      prilist.add(e);
	      AcdPriModel ap=new AcdPriModel();
	      ap.setAcdYear(recentYear);
	      ap.setAcd_num(priacd_num);
	      serAccidentEbi.serSavePridiction(ap);
	      Map<String, Object> truemap = new HashMap<String, Object>();
	      Map<String, Object> primap = new HashMap<String, Object>();
	      truemap.put("truelist",truelist);
	      truemap.put("prilist",prilist);
	  	  primap.put("prilist",prilist);
		 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		 result = gson.toJson(truemap);
		 priresult = gson.toJson(primap);
		 System.out.println(result);
		// System.out.println(priresult);
		//System.out.println("result"+result);
		
		// System.out.println(result);
	//List<Map<String,Object>>
		return "success";
		}
		
	
	

}
