package cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi;

import java.util.List;
import java.util.Map;


import cn.edu.ncist.dataAnalyze.realtime.vo.AllDetailModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllProAcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllToAcdModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllYearAcciNumModel;




public interface SerAllAccidentEbi {
	
	//全国各省份事故发生量及死亡人数
	List<AllProAcciNumModel> serProAccident();
	//全国每年发生的事故数及死亡人数
	List<AllYearAcciNumModel> serYearAccident();
	//事故详细数据
	List<AllDetailModel> serDetailAccident();
	//详细数据条件查询
	List<AllDetailModel> serDetailAccident(String province,String year);
	//事故总计
	List<AllToAcdModel> serToAccident();
	
}
