package cn.edu.ncist.dataAnalyze.realtime.web;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;
import org.apache.struts2.interceptor.ServletRequestAware;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.CityAcciBriModel;

import com.opensymphony.xwork2.ActionSupport;
public class GetInfoAction extends ActionSupport implements ServletRequestAware{
	
    private static final long serialVersionUID = 1L;
    private HttpServletRequest request;
    private String result;
    private SerAccidentEbi serAccidentEbi;
    private List<CityAcciBriModel> CityBrilist=null;
    
    public SerAccidentEbi getSerAccidentEbi() {
		return serAccidentEbi;
	}

	public void setSerAccidentEbi(SerAccidentEbi serAccidentEbi) {
		this.serAccidentEbi = serAccidentEbi;
	}

	public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
  

	public List<CityAcciBriModel> getCityBrilist() {
		return CityBrilist;
	}

	public void setCityBrilist(List<CityAcciBriModel> cityBrilist) {
		CityBrilist = cityBrilist;
	}

	/**
     * 
     * @return SUCCESS
     */
    public String execute(){
        try {
    
        	String name= request.getParameter("userName");
        	//System.out.println(name);
        	CityBrilist=serAccidentEbi.serCityAccidentBri(name);
        
    
        	 List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        		
    	     
   	      for(CityAcciBriModel record : CityBrilist){
   	    	  Map<String, Object> e = new HashMap<String, Object>();
   	    	
   	    	  e.put("time",record.getAcdDateTime().substring(0,10));
   	    	  e.put("name",record.getAcdName().substring(0,5));
   	    	  e.put("id", record.getAcdId());
   	    	  e.put("cityname",name);
   	  		  list.add(e);
   	  	  }
   	     // Map<String, Object> e_city = new HashMap<String, Object>();
   	     // e_city.put("cityname",name);
   	     // list.add(e_city);
   	      Map<String, Object> map = new HashMap<String, Object>();
   	      map.put("list",list);
           
 
            JSONObject json = JSONObject.fromObject(map);
            result = json.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return SUCCESS;

    }
}