package cn.edu.ncist.dataAnalyze.realtime.web;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.vo.AccidentModel;

import com.opensymphony.xwork2.ActionSupport;

public class SerAccidentAction  extends ActionSupport{
	//private SerAccidentEbi serAccientEbi;
	private SerAccidentEbi serAccidentEbi;
	Map<String,String> map;
	private List<AccidentModel> list2= null;
	int i;
	int year;
	/**
	 * @return the serAccientEbi
	 */

	/**
	 * @return the map
	 */
	public Map<String, String> getMap() {
		return map;
	}
	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	/**
	 * @return the list2
	 */
	public List<AccidentModel> getList2() {
		return list2;
	}
	/**
	 * @param list2 the list2 to set
	 */
	public void setList2(List<AccidentModel> list2) {
		this.list2 = list2;
	}
	/**
	 * @return the i
	 */
	public int getI() {
		return i;
	}
	/**
	 * @param i the i to set
	 */
	public void setI(int i) {
		this.i = i;
	}
	
	
	public SerAccidentEbi getSerAccidentEbi() {
		return serAccidentEbi;
	}
	public void setSerAccidentEbi(SerAccidentEbi serAccidentEbi) {
		this.serAccidentEbi = serAccidentEbi;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	public String execute() throws Exception {
		//System.out.println("START");
		
	//	System.out.println("i = " + i + " year = " + year);
		//serAccidentEbi.getRetYear();
		list2=serAccidentEbi.serAccident(i,year);		//参数分别是致因和年数。------根据致因值和和年数查事件。
		map = new LinkedHashMap<String,String>();
		
		for(AccidentModel m : list2)
		{
			//System.out.println(m.getAcdId() + " " + m.getAcdName());
			map.put(m.getAcdId(),m.getAcdDateTime() + m.getAcdName());	//返回的应高包含事故名称和链接。
		}
			
		
		return "accidentIndex";
	}
}
