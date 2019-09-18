package cn.edu.ncist.dataAnalyze.realtime.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.dao.dao.MapDao;
import cn.edu.ncist.dataAnalyze.realtime.dao.impl.serAccidentDaoImpl;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.CityAcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.ProAcciNumModel;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 一个简单的前后台交换 地图展示
 *
 */
public class MapAction extends ActionSupport{
	
	private static final long serialVersionUID = -5452039838295753607L;
	SerAccidentEbi serAccidentEbi;
   	List<ProAcciNumModel> provincelist = null;
   	List<CityAcciNumModel> citylist=null;
   	
   	private List<Map<String, Integer>> prolst ;
 	private List<Map<String, Integer>> citylst ;
   	
   	private String prodata;
	
	public SerAccidentEbi getSerAccidentEbi() {
		return serAccidentEbi;
	}
	public void setSerAccidentEbi(SerAccidentEbi serAccidentEbi) {
		this.serAccidentEbi = serAccidentEbi;
	}
	
	
	public List<ProAcciNumModel> getProvincelist() {
		return provincelist;
	}
	public void setProvincelist(List<ProAcciNumModel> provincelist) {
		this.provincelist = provincelist;
	}
	public MapDao getMap() {
		return map;
	}
	public void setMap(MapDao map) {
		this.map = map;
	}


	public List<Map<String, Integer>> getProlst() {
		return prolst;
	}
	public void setProlst(List<Map<String, Integer>> prolst) {
		this.prolst = prolst;
	}
	
	//置取各个省的事故数据
	public String getProdata() {
		return prodata;
	}
	public void setProdata(String prodata) {
		this.prodata = prodata;
	}


	public List<CityAcciNumModel> getCitylist() {
		return citylist;
	}
	public void setCitylist(List<CityAcciNumModel> citylist) {
		this.citylist = citylist;
	}
	public List<Map<String, Integer>> getCitylst() {
		return citylst;
	}
	public void setCitylst(List<Map<String, Integer>> citylst) {
		this.citylst = citylst;
	}


	MapDao map= new MapDao();
	
	public String  chinaMap(){
		
		provincelist=serAccidentEbi.serProAccident();
		citylist=serAccidentEbi.serCityAccident();
		prolst = new ArrayList<Map<String, Integer>>();
		citylst =new ArrayList<Map<String, Integer>>();
		
		for(ProAcciNumModel pm: provincelist){
			Map map = new HashMap();
			map.put("SHENG", pm.getAcdProvince());
			map.put("NUM", pm.getAci_pro());
			prolst.add(map);
		}
		for(CityAcciNumModel canm: citylist){
			Map citymap = new HashMap();
			citymap.put("CITY",canm.getAcdCity());
			citymap.put("NUM",canm.getAcci_num());
			citylst.add(citymap);
		}
	
		//}
		//System.out.println(provincelist.size());
		//prodata = map.mkData(serAccidentEbi.serProAccident());
		
		//System.out.println(data1);
		return "success";
	}
}