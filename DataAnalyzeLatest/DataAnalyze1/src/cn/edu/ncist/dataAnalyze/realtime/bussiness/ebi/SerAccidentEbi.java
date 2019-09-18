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
	
	//ȫ��ÿ���¹ʷ�����
	List<AcciNumModel> serAccident();
	//ÿ��ʡ�ݷ������¹�����
	List<ProAcciNumModel> serProAccident();
	//ÿ�����з������¹�����
	List<CityAcciNumModel> serCityAccident();
	//
	List<CityAcciBriModel> serCityAccidentBri(String CityName);
	//��ѯ�¹�����
	List<CityAcciBriModel> serAccidentName(String Year);
	//��ѯ�¹���ϸ
	List<AccidentModel> serDetailAcd(String acdId);
	//�¹ʾ���
	List<AcciExperienceModel> serExperience(String acdId);
	//��ʩ�ͽ���
	List<MeaAdviceModel> serMeadvice(String acdId);
	//��������
	List<CasualtyModel> serCasualty();
	//ֱ�Ӿ�����ʧ
	List<FinLossModel> serFinLoss();
	// �ۺϷ���
	List<ComAcciModel> serComAnalysis();
	//�¹�Ԥ��
	int serAcdPridiction(int num);
	//����Ԥ����Ϣ
	String serSavePridiction(AcdPriModel apm);
	//��ȡ�������
	String getRetYear();
	//ͨ����ݲ�ѯ�¹�id
	List<AcdIdYearModel> serAcdIdByYear(String acdYear);
	//ͨ���¹�id��ѯȨ��
	List<AcdReaToStanModel> serDegreeByAcdId(String acdId);
	//
	List<AccidentModel> serAccident(int i);	//��ȡ��ͬ��ݵ��¹�
	List<AccidentModel> serAccident(int cause,int year);
}
