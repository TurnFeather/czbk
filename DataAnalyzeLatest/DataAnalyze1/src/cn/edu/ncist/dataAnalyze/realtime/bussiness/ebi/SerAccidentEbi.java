package cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi;

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



public interface SerAccidentEbi {
	
	//全国每年事故发生量
	List<AcciNumModel> serAccident();
	//每个省份发生的事故总数
	List<ProAcciNumModel> serProAccident();
	//每个城市发生的事故数量
	List<CityAcciNumModel> serCityAccident();
	//
	List<CityAcciBriModel> serCityAccidentBri(String CityName);
	//查询事故名称
	List<CityAcciBriModel> serAccidentName(String Year);
	//查询事故详细
	List<AccidentModel> serDetailAcd(String acdId);
	//事故经验
	List<AcciExperienceModel> serExperience(String acdId);
	//措施和建议
	List<MeaAdviceModel> serMeadvice(String acdId);
	//伤亡人数
	List<CasualtyModel> serCasualty();
	//直接经济损失
	List<FinLossModel> serFinLoss();
	// 综合分析
	List<ComAcciModel> serComAnalysis();
	//事故预测
	int serAcdPridiction(int num);
	//保存预测信息
	String serSavePridiction(AcdPriModel apm);
	//获取最新年份
	String getRetYear();
	//通过年份查询事故id
	List<AcdIdYearModel> serAcdIdByYear(String acdYear);
	//通过事故id查询权重
	List<AcdReaToStanModel> serDegreeByAcdId(String acdId);
	//
	List<AccidentModel> serAccident(int i);	//获取不同年份的事故
	List<AccidentModel> serAccident(int cause,int year);
}
