package cn.edu.ncist.dataAnalyze.realtime.web;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerEventCountEbi;
import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerWeatherEbi;
import cn.edu.ncist.dataAnalyze.realtime.vo.AccidentModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.ReasonToStandModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.SituationModel;

import com.opensymphony.xwork2.ActionSupport;

public class EventCountAction extends ActionSupport{
	
	private SerEventCountEbi serEventCountEbi;
	private SerAccidentEbi serAccientEbi;
	private SerWeatherEbi serWeatherEbi;
	String result;
	int i;
	Map<String,Object> map;
	int[] buffer;
	private List<ReasonToStandModel> list= null;
	private List<AccidentModel> list2= null;
	private List<SituationModel> list3 = null;
	
	public SerEventCountEbi getSerEventCountEbi() {
		return serEventCountEbi;
	}

	
	public void setSerEventCountEbi(SerEventCountEbi serEventCountEbi) {
		this.serEventCountEbi = serEventCountEbi;
	}

	
	public String getResult() {
		return result;
	}

	
	public void setResult(String result) {
		this.result = result;
	}

	
	public int getI() {
		return i;
	}

	
	public void setI(int i) {
		this.i = i;
	}

	
	public Map<String, Object> getMap() {
		return map;
	}

	
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	
	public int[] getBuffer() {
		return buffer;
	}

	public void setBuffer(int[] buffer) {
		this.buffer = buffer;
	}


	public List<ReasonToStandModel> getList() {
		return list;
	}

	
	public void setList(List<ReasonToStandModel> list) {
		this.list = list;
	}
	
	public List<AccidentModel> getList2() {
		return list2;
	}

	public void setList2(List<AccidentModel> list2) {
		this.list2 = list2;
	}
	
	public List<SituationModel> getList3() {
		return list3;
	}

	public void setList3(List<SituationModel> list3) {
		this.list3 = list3;
	}


	public SerAccidentEbi getSerAccientEbi() {
		return serAccientEbi;
	}

	public void setSerAccientEbi(SerAccidentEbi serAccientEbi) {
		this.serAccientEbi = serAccientEbi;
	}
	
	public SerWeatherEbi getSerWeatherEbi() {
		return serWeatherEbi;
	}

	public void setSerWeatherEbi(SerWeatherEbi serWeatherEbi) {
		this.serWeatherEbi = serWeatherEbi;
	}


	public String execute() throws Exception {
		//System.out.println("∑√Œ µΩEventCountAction" + i);
		int[] buffer = serEventCountEbi.serEventCount(i);
		map = new LinkedHashMap<String,Object>();
		//System.out.println("action Result");
		for (int j=0;j<25;j++)
		{
			map.put(String.valueOf(j), buffer[j]);
		}
		return "Count";
	}

}
