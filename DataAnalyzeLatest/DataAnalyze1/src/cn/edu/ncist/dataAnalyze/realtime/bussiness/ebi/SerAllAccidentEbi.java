package cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi;

import java.util.List;
import java.util.Map;


import cn.edu.ncist.dataAnalyze.realtime.vo.AllDetailModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllProAcciNumModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllToAcdModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.AllYearAcciNumModel;




public interface SerAllAccidentEbi {
	
	//ȫ����ʡ���¹ʷ���������������
	List<AllProAcciNumModel> serProAccident();
	//ȫ��ÿ�귢�����¹�������������
	List<AllYearAcciNumModel> serYearAccident();
	//�¹���ϸ����
	List<AllDetailModel> serDetailAccident();
	//��ϸ����������ѯ
	List<AllDetailModel> serDetailAccident(String province,String year);
	//�¹��ܼ�
	List<AllToAcdModel> serToAccident();
	
}
