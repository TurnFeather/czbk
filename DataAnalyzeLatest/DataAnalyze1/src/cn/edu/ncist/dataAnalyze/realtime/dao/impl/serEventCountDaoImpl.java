package cn.edu.ncist.dataAnalyze.realtime.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerAccidentEbi;
import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerEventCountDao;
import cn.edu.ncist.dataAnalyze.realtime.vo.AccidentModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.ReasonToStandModel;

public class serEventCountDaoImpl extends HibernateDaoSupport implements SerEventCountDao {

	private List<AccidentModel> list1= null;
	private List<ReasonToStandModel> list= null;
	private Map<Object,Object> map;
	private SerAccidentEbi serAccientEbi;
	@SuppressWarnings("unchecked")
	public int[] serEventCount(int i) {
		
		int [] buffer = new int[25];
		map = new HashMap<Object,Object>();
		//list1=serAccientEbi.serAccident(5);		//参数为查询最近几年的事故。1-去年 3-近3年
		String hq2="From AccidentModel";
		String newyearStr = "select Max(acdYear) from AccidentModel";
		String newyearS =  getHibernateTemplate().find(newyearStr).toString();
		newyearS = newyearS.substring(1, 5);
		//System.out.println(newyearS);
		int newyearI = Integer.parseInt(newyearS);
		for (int j=0;j<i;j++)
		{
			String year = String.valueOf(newyearI - j);
			year = "'" + year + "'";
			
			//System.out.println(year);
			
			String acdStr = "from AccidentModel where acdYear like " + year;
			list1=getHibernateTemplate().find(acdStr);
			
			for (AccidentModel m : list1)
			{
				String acdId = m.getAcdId();
				acdId = "'" + acdId + "'";
				
				//System.out.println(acdId);
				
				String causeStr = "from ReasonToStandModel where acdId like " + acdId;
				list = this.getHibernateTemplate().find(causeStr);
				System.out.println(list.size());
				if(list.size()>=1){
				for (int k=0;k<25;k++)
				{	//if(list.size()>=1)
					if (!list.get(k).getDegree().equals("0"))
					{
 						//System.out.println("ID:" + list.get(k).getId() + "事故ID:" + list.get(k).getAcdId() + "值:" + list.get(k).getDegree());
						buffer[k]++;
					}
				}
			  }
			}
		}
		/*
		for(int l=0;l<25;l++)
		{
			System.out.println(buffer[l]);
		}
		*/
		
		//String hql="FROM SituationModel";
		
		return buffer;
	}

	@SuppressWarnings("unchecked")
	public List<ReasonToStandModel> serEventCount2() {
		String hq2="From AccidentModel";
		String str = "select Min(acdYear) from AccidentModel";

		String str2 = "from AccidentModel where acdYear like '2014'";
		System.out.println(getHibernateTemplate().find(str).toString());
		
		String hql="FROM SituationModel";
		
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * @return the serAccientEbi
	 */
	public SerAccidentEbi getSerAccientEbi() {
		return serAccientEbi;
	}

	/**
	 * @param serAccientEbi the serAccientEbi to set
	 */
	public void setSerAccientEbi(SerAccidentEbi serAccientEbi) {
		this.serAccientEbi = serAccientEbi;
	}

	

}
