package cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi;

import java.util.List;

import cn.edu.ncist.dataAnalyze.realtime.vo.ReasonToStandModel;

public interface SerEventCountEbi {
	
	//List<ReasonToStandModel> serEventCount(int i);	//获取不同致因的事故数，参数为0选取所有，其它再说
	int[] serEventCount(int i);

}
