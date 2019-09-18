package cn.edu.ncist.dataAnalyze.realtime.bussiness.ebo;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerEconEbi;
import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerEconDao;

public class SerEconEbo implements SerEconEbi{
	
	private SerEconDao serEconDao;

	public SerEconDao getSerEconDao() {
		return serEconDao;
	}

	public void setSerEconDao(SerEconDao serEconDao) {
		this.serEconDao = serEconDao;
	}

	public String shuchu() {
		
		return serEconDao.shuchu();
	}
	
	

}
