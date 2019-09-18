package cn.edu.ncist.dataAnalyze.realtime.dao.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebo.SerAccidentEbo;
import cn.edu.ncist.dataAnalyze.realtime.dao.impl.serAccidentDaoImpl;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.ProAcciNumModel;

public class MapDao {
	
	
	/**
	 * @return  按照地图的设定，对这些省市进行设值
	 */
	public String  mkData(List<ProAcciNumModel> Prolist){
		
		StringBuffer sb = new StringBuffer("");
		String result;
		Map<String,String> myMap= new HashMap<String,String>(40);
		myMap.put("吉林省","cn-jl");        
		myMap.put("天津市","cn-tj");    
		myMap.put("安徽省","cn-ah");        
		myMap.put("山东省","cn-sd");        
		myMap.put("山西省","cn-sx");
		myMap.put("新疆维吾尔自治区","cn-xj");
		myMap.put("河北省","cn-hb");     
		myMap.put("河南省","cn-he");        
		myMap.put("湖南省","cn-hn");        
		myMap.put("甘肃省","cn-gs");        
		myMap.put("福建省","cn-fj");        
		myMap.put("贵州省","cn-gz");        
		myMap.put("重庆市","cn-cq");        
		myMap.put("江苏省","cn-js");        
		myMap.put("湖北省","cn-hu");        
		myMap.put("内蒙古自治区","cn-nm");  
		myMap.put("广西壮族自治区","cn-gx"); 
		myMap.put("黑龙江省","cn-hl");      
		myMap.put("云南省","cn-yn");        
		myMap.put("辽宁省","cn-ln");        
		myMap.put("香港特别行政区","cn-6668"); 
		myMap.put("浙江省","cn-zj");        
		myMap.put("上海市","cn-sh");        
		myMap.put("北京市","cn-bj");        
		myMap.put("广东省","cn-gd");        
		myMap.put("澳门特别行政区","cn-3681"); 
		myMap.put("西藏自治区","cn-xz");    
		myMap.put("陕西省","cn-sa");        
		myMap.put("四川省","cn-sc");        
		myMap.put("海南省","cn-ha");        
		myMap.put("宁夏回族自治区","cn-nx"); 
		myMap.put("青海省","cn-qh");        
		myMap.put("江西省","cn-jx");        
		myMap.put("台湾省","tw-tw"); 
		
		//取数据，list
		//serAccidentDaoImpl serAccidentEbi=new serAccidentDaoImpl();
		 List<ProAcciNumModel> list= Prolist;
		// list=serAccidentEbi.serAccident();
		//System.out.println(list.size());
		//  {"hc-key": "cn-sh","value": 0},
		Random random = new Random();
		String value="";
		/*for (Object o : myMap.keySet()) { 
			value= random.nextInt(100)+1+"" ;
			sb = sb.append("{'hc-key':'");
			sb = sb.append(myMap.get(o));
			sb = sb.append("','value':");
			for(ProAcciNumModel record : list){
		    	
		    	 String acdProvince= record.getAcdProvince();
		    	 System.out.println(acdProvince);
		    	 // e.put("num",record.getNUM());
		  		//  list.add(e);
		  	 }*/
			List<Map<String,Object>> pro_list=new ArrayList<Map<String,Object>>();
		  
			   for(Iterator iter = myMap.entrySet().iterator();iter.hasNext();){
				  Map<String, Object> e = new HashMap<String, Object>();
				Map.Entry element = (Map.Entry)iter.next();
				Object strKey = element.getKey();
				Object strObj = element.getValue();
			//	System.out.println(strKey);
				//sb = sb.append("{'hc-key':'");
				//sb = sb.append(element.getValue());
			//	sb = sb.append("','value':");
				e.put("province", strKey);
			//	System.out.println(e);
				//pro_list.add(e);
				boolean flag = true;
				for(ProAcciNumModel record : list){
			    	
			    	 String acdProvince= record.getAcdProvince();
			    	 int aci_num =record.getAci_pro();
			    	// System.out.println(acdProvince+aci_num);
			    	 
			    	 if(acdProvince.equals(strKey)){
			    		 e.put("num", aci_num);
			    		 flag = false;
			    	 }
			 
			  	 }
				if(flag){
					 e.put("num",0);
					
		    	 }
			
				 pro_list.add(e);
			   }
				Map<String, Object> map = new HashMap<String, Object>();
			    map.put("list",pro_list);
			    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				result = gson.toJson(map);
				System.out.println(result);
			   	
		
		return result;
		//return "success";
	}
	
	public static void main(String[] args) {
		MapDao map= new MapDao();
		//map.mkData( Prolist);
	}

}
