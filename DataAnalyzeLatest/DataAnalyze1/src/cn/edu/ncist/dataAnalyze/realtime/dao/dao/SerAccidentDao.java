package cn.edu.ncist.dataAnalyze.realtime.dao.dao;

import java.util.List;
import java.util.Map;

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

	public interface SerAccidentDao {
	
	List<AcciNumModel> serAccident();
	
	List<ProAcciNumModel> serProAccident();
	
	List<CityAcciNumModel> serCityAccident();
	
	List<CityAcciBriModel> serCityAccidentBri(String CityName);
	List<CityAcciBriModel> serAccidentName(String Year);
	List<AccidentModel> serDetailAcd(String acdId);
	//事故经验
	List<AcciExperienceModel> serExperience(String acdId);
	//事故措施和建议
	List<MeaAdviceModel> serMeadvice(String acdId);
	//伤亡人数
	List<CasualtyModel> serCasualty();
	//直接经济损失
	List<FinLossModel> serFinLoss();
	//综合分析
	List<ComAcciModel> serComAnalysis();
	//预测事故数量
	int serAcdPridiction(int num);
	//获取最近年份
	String getRetYear();
	//保存预测信息
	String serSavePridiction(AcdPriModel apm);
	//
	String shuchu();
	//通过年份查询事故id
	List<AcdIdYearModel> serAcdIdByYear(String acdYear);
	//通过事故id查询权重
	List<AcdReaToStanModel> serDegreeByAcdId(String acdId);
	
	List<AccidentModel> serAccident(int i);
	List<AccidentModel> serAccident(int cause,int year);

	

}
