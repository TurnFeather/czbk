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

public class AllAcdPridictionAction extends ActionSupport{
	
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
		  List<Map<String,Object>> prilist=new ArrayList<Map<String,Object>>();
	     
	      for(AllYearAcciNumModel record : lst){
	    	  Map<String, Object> e = new HashMap<String, Object>();
	    	 
	    	  e.put("year",record.getYear());
	    	  e.put("acdnum",Integer.parseInt(record.getAcd_num()));
	    	 yearlist.add(e);
	    	 // prilist.add(e);
	  	  }
	      for(int i=0;i<lst.size();i++){
	    	  Map<String, Object> e1 = new HashMap<String, Object>();
				double k = 3.0;
				double y = 0;
				
				//原来Gamma曲线的最大值点
				double basicPos = 1.0 / 3;
				//事故数曲线的对应最大值点与Gamma曲线最大点对应系数
				double coef = basicPos / 3.7;
				
				double x = k * k * i * coef / Math.exp(k * i * coef);
				
				//线性变换系数a和b
				double a = 2900;
				double b = 50;
//				y = x * a + b;
				y = Math.ceil(x * (2553.54) + 41.8);
				e1.put("year",lst.get(i).getYear());
				e1.put("acdnum",y);
				
				prilist.add(e1);
			
				System.out.println(i + "=  " + x + "=  " + y); 
			}

	   //   Map<String, Object> truemap = new HashMap<String, Object>();
	      Map<String, Object> promap = new HashMap<String, Object>();
	      promap.put("yearlist",yearlist);
	      promap.put("prilist",prilist);
	  	  
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
