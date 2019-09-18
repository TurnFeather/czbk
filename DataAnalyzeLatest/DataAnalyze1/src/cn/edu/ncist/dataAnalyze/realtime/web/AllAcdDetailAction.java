package cn.edu.ncist.dataAnalyze.realtime.web;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.mina.filter.reqres.Request;
import org.apache.struts2.interceptor.ServletRequestAware;

import net.sf.json.JSONObject;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAllAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerRuleEbi;
import cn.edu.ncist.dataAnalyze.realtime.rules.Accident;
import cn.edu.ncist.dataAnalyze.realtime.rules.Rule;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AccidentModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcdPriModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllDetailModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllProAcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllToAcdModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllYearAcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.RuleModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.googlecode.jsonplugin.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class AllAcdDetailAction extends ActionSupport implements ServletRequestAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private SerAccidentEbi serAccidentEbi;
	private SerAllAccidentEbi serAllAccidentEbi;
	private  List<AllDetailModel> lst =null;
	private List<AllProAcciNumModel> plist= null;
	private List<AllYearAcciNumModel> ylist=null;
	private List<AllToAcdModel> tolist=null;
	private HttpServletRequest request;
	//private List<>
	
	
	private String result;
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

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

	public List<AllDetailModel> getLst() {
		return lst;
	}

	public void setLst(List<AllDetailModel> lst) {
		this.lst = lst;
	}
	
	public List<AllProAcciNumModel> getPlist() {
		return plist;
	}

	public void setPlist(List<AllProAcciNumModel> plist) {
		this.plist = plist;
	}

	public List<AllYearAcciNumModel> getYlist() {
		return ylist;
	}

	public void setYlist(List<AllYearAcciNumModel> ylist) {
		this.ylist = ylist;
	}
	
	
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}


	public List<AllToAcdModel> getTolist() {
		return tolist;
	}

	public void setTolist(List<AllToAcdModel> tolist) {
		this.tolist = tolist;
	}

	public String execute() throws Exception {
		request.setCharacterEncoding("UTF-8");
	   //if(request.getParameter("city")==null){
		String year =request.getParameter("year");
		String province = request.getParameter("province");

		  if(year == null && province==null){
		  lst=serAllAccidentEbi.serDetailAccident();
		  }else{
			  System.out.println(province);
			  lst=serAllAccidentEbi.serDetailAccident(province, year);
		  }
//		  System.out.println(city);
		//  System.out.println("lst"+lst.get(200).getAllAcdView().);
		  plist=serAllAccidentEbi.serProAccident();
		  ylist=serAllAccidentEbi.serYearAccident();
		  tolist=serAllAccidentEbi.serToAccident();
		  List<Map<String,Object>> Detlist=new ArrayList<Map<String,Object>>();
		  List<Map<String,Object>> prolist=new ArrayList<Map<String,Object>>();
		  List<Map<String,Object>> yearlist=new ArrayList<Map<String,Object>>();
	     
		/*  for(AllDetailModel record : lst){
			 // if(record.getProvince().equals("上海")){
	    	  Map<String, Object> e = new HashMap<String, Object>();
	    	  Map<String, Object> e1 = new HashMap<String, Object>();
	    	  e.put("dprovince",record.getProvince());
	    	  e.put("dyear",record.getYear());
	    	  e.put("acdnum",Integer.parseInt(record.getAcd_num()));
	    	  e.put("dienum",Integer.parseInt(record.getDie_num()));
	    	  Detlist.add(e);
	   
			//  }
			  
	    	 // prilist.add(e);
	  	  }
		/*  for(AllDetailModel record : lst){
			  if(!record.getProvince().equals("上海")){
				  if(!record.getProvince().equals("其他")){
				  
	    	  Map<String, Object> e = new HashMap<String, Object>();
	    	  Map<String, Object> e1 = new HashMap<String, Object>();
	    	  e.put("dprovince",record.getProvince());
	    	  e.put("dyear",record.getYear());
	    	  e.put("acdnum",Integer.parseInt(record.getAcd_num()));
	    	  e.put("dienum",Integer.parseInt(record.getDie_num()));
	    	  Detlist.add(e);
	    
				  }
			  }
			  
			  
	    	 // prilist.add(e);
	  	  }
		  for(AllDetailModel record : lst){
			  if(record.getProvince().equals("其他")){
	    	  Map<String, Object> e = new HashMap<String, Object>();
	    	  Map<String, Object> e1 = new HashMap<String, Object>();
	    	  e.put("dprovince",record.getProvince());
	    	  e.put("dyear",record.getYear());
	    	  e.put("acdnum",Integer.parseInt(record.getAcd_num()));
	    	  e.put("dienum",Integer.parseInt(record.getDie_num()));
	    	  Detlist.add(e);
	    	
			  }
			  
	    	 // prilist.add(e);
	  	  }*/
		  
	   /*   for(AllProAcciNumModel precord : plist){
	    	  if(!precord.getProvince().equals("其他")){
	    	  Map<String, Object> e = new HashMap<String, Object>();
	    	  e.put("province",precord.getProvince());
	    	  System.out.println(precord.getProvince());
	    	  prolist.add(e);
	    	  }
	      }
	     for(AllProAcciNumModel precord : plist){
	    	  if(precord.getProvince().equals("其他")){
	    	  Map<String, Object> e = new HashMap<String, Object>();
	    	  e.put("province",precord.getProvince());
	    	  prolist.add(e);}
	      }
	      for(AllYearAcciNumModel precord : ylist){
	    	  Map<String, Object> e = new HashMap<String, Object>();
	    	  e.put("year",precord.getYear());
	    	  yearlist.add(e);
	      }

	   //   Map<String, Object> truemap = new HashMap<String, Object>();
	      Map<String, Object> detmap = new HashMap<String, Object>();
	      detmap.put("prolist",prolist);
	      detmap.put("Detlist",Detlist);
	      detmap.put("yearlist",yearlist);
	  	  
		 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		 result = gson.toJson(detmap);
	//	 priresult = gson.toJson()
		 System.out.println(result);
		//System.out.println("result"+result);
		
		// System.out.println(result);
	//List<Map<String,Object>>*/
		 
		return "success";
		}


		
	
	

}
