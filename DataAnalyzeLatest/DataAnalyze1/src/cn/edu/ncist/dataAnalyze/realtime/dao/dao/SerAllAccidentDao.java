package cn.edu.ncist.dataAnalyze.realtime.dao.dao;

import java.util.List;
import java.util.Map;

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

	public interface SerAllAccidentDao {
		//全国各省份事故发生量及死亡人数
		List<AllProAcciNumModel> serProAccident();
		//全国每年发生的事故数及死亡人数
		List<AllYearAcciNumModel> serYearAccident();
		//事故详细数据
		List<AllDetailModel> serDetailAccident();
		//事故详细数据条件查询
		List<AllDetailModel> serDetailAccident(String province,String year);
		
		//事故总计
		List<AllToAcdModel> serToAccident();

}
