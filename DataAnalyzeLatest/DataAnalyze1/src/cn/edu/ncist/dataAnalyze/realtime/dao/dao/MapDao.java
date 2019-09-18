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
	 * @return  ���յ�ͼ���趨������Щʡ�н�����ֵ
	 */
	public String  mkData(List<ProAcciNumModel> Prolist){
		
		StringBuffer sb = new StringBuffer("");
		String result;
		Map<String,String> myMap= new HashMap<String,String>(40);
		myMap.put("����ʡ","cn-jl");        
		myMap.put("�����","cn-tj");    
		myMap.put("����ʡ","cn-ah");        
		myMap.put("ɽ��ʡ","cn-sd");        
		myMap.put("ɽ��ʡ","cn-sx");
		myMap.put("�½�ά���������","cn-xj");
		myMap.put("�ӱ�ʡ","cn-hb");     
		myMap.put("����ʡ","cn-he");        
		myMap.put("����ʡ","cn-hn");        
		myMap.put("����ʡ","cn-gs");        
		myMap.put("����ʡ","cn-fj");        
		myMap.put("����ʡ","cn-gz");        
		myMap.put("������","cn-cq");        
		myMap.put("����ʡ","cn-js");        
		myMap.put("����ʡ","cn-hu");        
		myMap.put("���ɹ�������","cn-nm");  
		myMap.put("����׳��������","cn-gx"); 
		myMap.put("������ʡ","cn-hl");      
		myMap.put("����ʡ","cn-yn");        
		myMap.put("����ʡ","cn-ln");        
		myMap.put("����ر�������","cn-6668"); 
		myMap.put("�㽭ʡ","cn-zj");        
		myMap.put("�Ϻ���","cn-sh");        
		myMap.put("������","cn-bj");        
		myMap.put("�㶫ʡ","cn-gd");        
		myMap.put("�����ر�������","cn-3681"); 
		myMap.put("����������","cn-xz");    
		myMap.put("����ʡ","cn-sa");        
		myMap.put("�Ĵ�ʡ","cn-sc");        
		myMap.put("����ʡ","cn-ha");        
		myMap.put("���Ļ���������","cn-nx"); 
		myMap.put("�ຣʡ","cn-qh");        
		myMap.put("����ʡ","cn-jx");        
		myMap.put("̨��ʡ","tw-tw"); 
		
		//ȡ���ݣ�list
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
