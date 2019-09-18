package cn.edu.ncist.dataAnalyze.realtime.bussiness.ebo;

import java.util.List;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerWeatherEbi;
import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerWeatherDao;
import cn.edu.ncist.dataAnalyze.realtime.vo.SituationModel;

public class SerWeatherEbo implements SerWeatherEbi {
	
	private SerWeatherDao serWeatherDao;
	public List<SituationModel> serWeather(int i) {
		// TODO Auto-generated method stub
		if (i==0)
			return serWeatherDao.serWeather1();
		else
			return serWeatherDao.serWeather2();
	}
	/**
	 * @return the serWeatherDao
	 */
	public SerWeatherDao getSerWeatherDao() {
		return serWeatherDao;
	}
	/**
	 * @param serWeatherDao the serWeatherDao to set
	 */
	public void setSerWeatherDao(SerWeatherDao serWeatherDao) {
		this.serWeatherDao = serWeatherDao;
	}
	
	

}
