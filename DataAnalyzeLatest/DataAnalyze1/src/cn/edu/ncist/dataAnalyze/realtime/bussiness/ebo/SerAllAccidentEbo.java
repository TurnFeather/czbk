package cn.edu.ncist.dataAnalyze.realtime.bussiness.ebo;

import java.util.List;
import java.util.Map;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAllAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerAccidentDao;
import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerAllAccidentDao;
import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerRuleDao;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcciExperienceModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AccidentModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcdIdYearModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcdPriModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AcdReaToStanModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllDetailModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllProAcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllToAcdModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllYearAcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.CasualtyModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.CityAcciBriModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.CityAcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.ComAcciModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.FinLossModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.MeaAdviceModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.ProAcciNumModel;

public class SerAllAccidentEbo implements SerAllAccidentEbi {
	
	private SerAllAccidentDao serAllAccidentDao;
	
	public SerAllAccidentDao getSerAllAccidentDao() {
		return serAllAccidentDao;
	}

	public void setSerAllAccidentDao(SerAllAccidentDao serAllAccidentDao) {
		this.serAllAccidentDao = serAllAccidentDao;
	}
	public List<AllProAcciNumModel> serProAccident() {
		// TODO Auto-generated method stub
		return serAllAccidentDao.serProAccident();
	}

	

	public List<AllYearAcciNumModel> serYearAccident() {
		// TODO Auto-generated method stub
		return serAllAccidentDao.serYearAccident();
	}

	public List<AllDetailModel> serDetailAccident() {
		// TODO Auto-generated method stub
		return serAllAccidentDao.serDetailAccident();
	}

	public List<AllToAcdModel> serToAccident() {
		// TODO Auto-generated method stub
		return serAllAccidentDao.serToAccident();
	}

	public List<AllDetailModel> serDetailAccident(String province, String year) {
		// TODO Auto-generated method stub
		return serAllAccidentDao.serDetailAccident(province, year);
	}

}
