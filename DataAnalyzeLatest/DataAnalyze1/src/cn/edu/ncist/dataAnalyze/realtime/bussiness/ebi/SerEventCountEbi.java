package cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi;

import java.util.List;

import cn.edu.ncist.dataAnalyze.realtime.vo.ReasonToStandModel;

public interface SerEventCountEbi {
	
	//List<ReasonToStandModel> serEventCount(int i);	//��ȡ��ͬ������¹���������Ϊ0ѡȡ���У�������˵
	int[] serEventCount(int i);

}
