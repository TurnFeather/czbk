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
import cn.edu.ncist.dataAnalyze.realtime.vo.RuleModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.googlecode.jsonplugin.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class AcciAnalyzeAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SerAccidentEbi serAccidentEbi;
	private SerAllAccidentEbi serAllAccidentEbi;
	private  List<AcciNumModel> lst =null;
	//private List<>
	private String result;
	private String priresult;


	
	
	public SerAllAccidentEbi getSerAllAccidentEbi() {
		return serAllAccidentEbi;
	}

	public void setSerAllAccidentEbi(SerAllAccidentEbi serAllAccidentEbi) {
		this.serAllAccidentEbi = serAllAccidentEbi;
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
		  System.out.println("serAllAccidentEbi"+serAllAccidentEbi.serProAccident().size());
		  String recentYear = (Integer.parseInt(serAccidentEbi.getRetYear())+1)+"";
		  
		  System.out.println("recentYear:"+recentYear);
//		  
		  List<Map<String,Object>> truelist=new ArrayList<Map<String,Object>>();
		//  List<Map<String,Object>> prilist=new ArrayList<Map<String,Object>>();
	     
	      for(AcciNumModel record : lst){
	    	  Map<String, Object> e = new HashMap<String, Object>();
	    	
	    	  e.put("acdYear",record.getAcdYear());
	    	  e.put("num",record.getNUM());
	    	  truelist.add(e);
	    	 // prilist.add(e);
	  	  }
	    //  Map<String, Object> e = new HashMap<String, Object>();
	 //     e.put("acdYear",recentYear);
	  //    e.put("num",serAccidentEbi.serAcdPridiction(5));
	      
	  //    prilist.add(e);
	   //   AcdPriModel ap=new AcdPriModel();
	     // ap.setAcdYear(recentYear);
	    //  ap.setAcd_num(serAccidentEbi.serAcdPridiction());
	    //  serAccidentEbi.serSavePridiction(ap);
	      Map<String, Object> truemap = new HashMap<String, Object>();
	      Map<String, Object> primap = new HashMap<String, Object>();
	      truemap.put("truelist",truelist);
	  	  
		 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		 result = gson.toJson(truemap);
	//	 priresult = gson.toJson()
		 System.out.println(result);
		//System.out.println("result"+result);
		
		// System.out.println(result);
	//List<Map<String,Object>>
		return "success";
		}
		
	
	

}
