package cn.edu.ncist.dataAnalyze.realtime.bussiness.ebo;

import java.util.List;

import cn.edu.ncist.dataAnalyze.realtime.bussiness.ebi.SerEventCountEbi;
import cn.edu.ncist.dataAnalyze.realtime.dao.dao.SerEventCountDao;
import cn.edu.ncist.dataAnalyze.realtime.vo.ReasonToStandModel;

public class SerEventCountEbo implements SerEventCountEbi {
	
	private SerEventCountDao serEventCountDao;
	public int[] serEventCount(int i) {
		// TODO Auto-generated method stub
		//if (i==0)
		//	return serEventCountDao.serEventCount1();
		//else
			return serEventCountDao.serEventCount(i);
	}
	/**
	 * @return the serEventCountDao
	 */
	public SerEventCountDao getSerEventCountDao() {
		return serEventCountDao;
	}
	/**
	 * @param serEventCountDao the serEventCountDao to set
	 */
	public void setSerEventCountDao(SerEventCountDao serEventCountDao) {
		this.serEventCountDao = serEventCountDao;
	}

	

}
