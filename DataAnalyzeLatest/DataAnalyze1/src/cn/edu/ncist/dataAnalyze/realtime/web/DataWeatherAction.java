package cn.edu.ncist.dataAnalyze.realtime.web;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerWeatherEbi;
import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerWeatherDao;
import cn.edu.ncist.dataAnalyze.realtime.vo.SituationModel;

import com.googlecode.jsonplugin.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class DataWeatherAction extends ActionSupport{
	
	private SerWeatherEbi serWeatherEbi ;
	String result;
	int i;
	Map<String,Object> map;
	private List<SituationModel> list= null;
	
	/**
	 * @return the i
	 */
	
	@JSON(serialize=false)
	public int getI() {
		return i;
	}

	/**
	 * @param i the i to set
	 */
	public void setI(int i) {
		this.i = i;
	}

	/**
	 * @return the list
	 */
	public List<SituationModel> getList() {
		return list;
	}

	/**
	 * @return the serWeatherEbi
	 */
	public SerWeatherEbi getSerWeatherEbi() {
		return serWeatherEbi;
	}

	/**
	 * @param serWeatherEbi the serWeatherEbi to set
	 */
	public void setSerWeatherEbi(SerWeatherEbi serWeatherEbi) {
		this.serWeatherEbi = serWeatherEbi;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<SituationModel> list) {
		this.list = list;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	
	
	/**
	 * @return the map
	 */
	public Map<String, Object> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String execute() throws Exception {
		System.out.println("START");
		list=serWeatherEbi.serWeather(0);
		
		System.out.println("客户端请求：" + i);
		map = new LinkedHashMap<String,Object>();
		
		if (i==0)
		{
			//只获取开始11条记录
			for (int t=0;t < (list.size() <= 11 ? list.size():11);t++)
			{
				SituationModel m = list.get(t);
				
				map.put("situation" + t, m);
			//	System.out.println(m.getHour());
			}
		}
		else
		{
			SituationModel m;
			if (i >= list.size())
				m = list.get(list.size() - 1);
			else
				m = list.get(i);
		//	System.out.println("获取时间" + m.getHour());
			map.put("situation", m);
		}
		return "Situation";
	}

}
