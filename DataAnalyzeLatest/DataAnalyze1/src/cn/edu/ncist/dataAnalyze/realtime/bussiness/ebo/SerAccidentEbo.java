package cn.edu.ncist.dataAnalyze.realtime.bussiness.ebo;

import java.util.List;
import java.util.Map;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerAccidentDao;
import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerRuleDao;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcciExperienceModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AccidentModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcdIdYearModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcdPriModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcdReaToStanModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.CasualtyModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.CityAcciBriModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.CityAcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.ComAcciModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.FinLossModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.MeaAdviceModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.ProAcciNumModel;

public class SerAccidentEbo implements SerAccidentEbi {
	
	private SerAccidentDao serAccidentDao;
	
	public SerAccidentDao getSerAccidentDao() {
		return serAccidentDao;
	}


	public void setSerAccidentDao(SerAccidentDao serAccidentDao) {
		this.serAccidentDao = serAccidentDao;
	}


	public List<AcciNumModel> serAccident() {
	
		return serAccidentDao.serAccident();
	}


	public String shuchu() {
		

	return	serAccidentDao.shuchu();
		
	}


	public List<ProAcciNumModel> serProAccident() {
		
		
		return serAccidentDao.serProAccident();
	}

	
	//获取每个城市事故发生个数

	public List<CityAcciNumModel> serCityAccident() {
		
		return serAccidentDao.serCityAccident();
	}

	//列举每个城市的事故
	public List<CityAcciBriModel> serCityAccidentBri(String CityName) {
		// TODO Auto-generated method stub
		return serAccidentDao.serCityAccidentBri(CityName);
	}


	public List<AccidentModel> serDetailAcd(String acdId) {
		
		return serAccidentDao.serDetailAcd(acdId);
	}


	public List<AcciExperienceModel> serExperience(String acdId) {
		// TODO Auto-generated method stub
		return serAccidentDao.serExperience(acdId);
	}


	public List<MeaAdviceModel> serMeadvice(String acdId) {
		// TODO Auto-generated method stub
		return serAccidentDao.serMeadvice(acdId);
	}


	public List<CasualtyModel> serCasualty() {
		// TODO Auto-generated method stub
		return serAccidentDao.serCasualty();
	}

    //经济损失
	public List<FinLossModel> serFinLoss() {
		// TODO Auto-generated method stub
		return serAccidentDao.serFinLoss();
	}

	//综合分析
	public List<ComAcciModel> serComAnalysis() {
		// TODO Auto-generated method stub
		return serAccidentDao.serComAnalysis();
	}


	public int serAcdPridiction(int num) {
		// 预测下一年数据
		return serAccidentDao.serAcdPridiction(num);
	}


	public String getRetYear() {
		// TODO Auto-generated method stub
		return serAccidentDao.getRetYear();
	}


	public String serSavePridiction(AcdPriModel apm) {
		// TODO Auto-generated method stub
		return serAccidentDao.serSavePridiction(apm);
	}


	public List<AcdIdYearModel> serAcdIdByYear(String acdYear) {
		// TODO Auto-generated method stub
		return serAccidentDao.serAcdIdByYear(acdYear);
	}


	public List<AcdReaToStanModel> serDegreeByAcdId(String acdId) {
		// TODO Auto-generated method stub
		return serAccidentDao.serDegreeByAcdId(acdId);
	}
	
	public List<AccidentModel> serAccident(int i) {
		// TODO Auto-generated method stub
		/*
		if (i==0)
			return serAccidentDao.serAccident0();
		else
			return serAccidentDao.serAccident1();
			*/
		//return serAccidentDao.serAccident(i);
		return serAccidentDao.serAccident(i);
	}
	public List<AccidentModel> serAccident(int cause, int year) {
		// TODO Auto-generated method stub
		return serAccidentDao.serAccident(cause, year);
	}


	public List<CityAcciBriModel> serAccidentName(String Year) {
		// TODO Auto-generated method stub
		return serAccidentDao.serAccidentName(Year);
	}

	
	
	

}
