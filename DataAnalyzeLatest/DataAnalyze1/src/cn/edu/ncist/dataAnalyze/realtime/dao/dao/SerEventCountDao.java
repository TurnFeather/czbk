package cn.edu.ncist.dataAnalyze.realtime.dao.dao;

import java.util.List;

import cn.edu.ncist.dataAnalyze.realtime.vo.ReasonToStandModel;

public interface SerEventCountDao {
	/*
	List<ReasonToStandModel> serEventCount1();
	List<ReasonToStandModel> serEventCount2();
	*/
	//List<ReasonToStandModel> serEventCount(int i);	¸Ä
	int[] serEventCount(int i);
}
