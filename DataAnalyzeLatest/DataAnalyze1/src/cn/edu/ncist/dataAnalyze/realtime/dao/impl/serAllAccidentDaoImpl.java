package cn.edu.ncist.dataAnalyze.realtime.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;



import org.drools.process.audit.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import Jama.Matrix;

import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerAccidentDao;
import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerAllAccidentDao;
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
import cn.edu.ncist.dataAnalyze.realtime.vo.ReasonToStandModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.stdreasonidModel;

public class serAllAccidentDaoImpl extends HibernateDaoSupport implements SerAllAccidentDao{

	public List<AllProAcciNumModel> serProAccident() {
		List<AllProAcciNumModel> list=null;
		String hql="from AllProAcciNumModel apanm ";
	    list=this.getHibernateTemplate().find(hql);	
		return list;
	}

	public List<AllYearAcciNumModel> serYearAccident() {
		List<AllYearAcciNumModel> list=null;
		String hql="from AllYearAcciNumModel ayanm ";
	    list=this.getHibernateTemplate().find(hql);	
		return list;
	}

	public List<AllDetailModel> serDetailAccident() {
		List<AllDetailModel> list=null;
		String hql="from AllDetailModel adm";
		list=this.getHibernateTemplate().find(hql);	
		return list;
	}
	
	public List<AllDetailModel> serDetailAccident(String province, String year) {
		List<AllDetailModel> list=null;
		String hql="";
		if(province.equals("全部省份") && year.equals("全部年份")){
			hql="from AllDetailModel adm";
			list=this.getHibernateTemplate().find(hql);	
		}
		else if(!(province.equals("全部省份")) && !(year.equals("全部年份"))){
			//String s="province="+province+" and "+"year="+year;
		
			String s="year="+year+" and "+"province='"+province+"'";
			hql="from AllDetailModel adm where "+s;
			System.out.println(hql);
			list=this.getHibernateTemplate().find(hql);	
		}else if((province.equals("全部省份")) && !(year.equals("全部年份"))){
			//String s="province="+province+" and "+"year="+year;
			
			String s="year="+year+"";
			hql="from AllDetailModel adm where "+s;
			System.out.println(hql);
			list=this.getHibernateTemplate().find(hql);	
		}
		else if(!(province.equals("全部省份")) && (year.equals("全部年份"))){
			//String s="province="+province+" and "+"year="+year;
			
			String s="province='"+province+"'";
			hql="from AllDetailModel adm where "+s;
			System.out.println(hql);
			list=this.getHibernateTemplate().find(hql);	
		}
		return list;
	}
	public List<AllToAcdModel> serToAccident() {
		List<AllToAcdModel> list=null;
		String hql="from AllToAcdModel atam";
		list=this.getHibernateTemplate().find(hql);	
		return list;
	
	}

	
	
	

	

	

}
