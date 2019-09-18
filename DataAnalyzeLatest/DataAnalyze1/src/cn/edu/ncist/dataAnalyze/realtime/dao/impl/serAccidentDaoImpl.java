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
import cn.edu.ncist.dataAnalyze.realtime.vo.ReasonToStandModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.stdreasonidModel;

public class serAccidentDaoImpl extends HibernateDaoSupport implements SerAccidentDao{

	@SuppressWarnings("unchecked")
	//ͳ��ÿ���¹ʷ�����
	public List<AcciNumModel> serAccident() {
		
			List<AcciNumModel> list = null;
			// select wqm from WokerQueryModel
            
			String hql="from AcciNumModel anm ";
		    list=this.getHibernateTemplate().find(hql);	
		   // Query q=this.createQuery(""); 
			return list;
			
	
	}
	
	public String shuchu() {
		
		String success="�ɹ�";
		
		return success;
		
	}

	public List<ProAcciNumModel> serProAccident() {
	
		List<ProAcciNumModel> list=null;
		String hql="from ProAcciNumModel panm ";
		
		//System.out.println(hql);

	   list=this.getHibernateTemplate().find(hql);
	   
	   
	//   System.out.println(list.size());
	      
	   return list;
	}

	//��ȡÿ�������¹�����
	
	public List<CityAcciNumModel> serCityAccident() {

		List<CityAcciNumModel> list= null;
		String hql= "from CityAcciNumModel canm";
		
		list=this.getHibernateTemplate().find(hql);
		
		return  list;
	}

	public List<CityAcciBriModel> serCityAccidentBri(String CityName) {
		
		List<CityAcciBriModel> list=null;
		
		String hql="from CityAcciBriModel cabm where acdCity ='"+CityName+"'";
	//	System.out.println(hql);
		list=this.getHibernateTemplate().find(hql);
		
		return list;
	}
	public List<CityAcciBriModel> serAccidentName(String Year) {
		List<CityAcciBriModel> list=null;
		
		String hql="from CityAcciBriModel cabm where acdDateTime like '"+Year+"%'";
	//	System.out.println(hql);
		list=this.getHibernateTemplate().find(hql);
		
		return list;
	}
	public List<AccidentModel> serDetailAcd(String acdId) {
		
		List<AccidentModel> list=null;
		
		String hql="from AccidentModel am where acdId='"+acdId+"'";
		list=this.getHibernateTemplate().find(hql);
		
		return list;
	}

	public List<AcciExperienceModel> serExperience(String acdId) {
		
		List<AcciExperienceModel> list = null;
		String hql="from AcciExperienceModel aem where acdId='"+acdId+"'";
		list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public List<MeaAdviceModel> serMeadvice(String acdId) {

		 List<MeaAdviceModel> list=null;
		 String hql="from MeaAdviceModel mam where acdId='"+acdId+"'";
		 list=this.getHibernateTemplate().find(hql);
		return list;
		
	}
	//ÿ���¹���������

	public List<CasualtyModel> serCasualty() {
		
		 List<CasualtyModel> list=null;
		 String hql="from CasualtyModel cm";
		 list=this.getHibernateTemplate().find(hql);
		 
		return list;
	}
   //ÿ�꾭����ʧ
	public List<FinLossModel> serFinLoss() {
		List<FinLossModel> list=null;
		String  hql="from FinLossModel flm";
		list=this.getHibernateTemplate().find(hql);
		return list;
	}
	//�ۺϷ���
	public List<ComAcciModel> serComAnalysis() {
		List<ComAcciModel> list=null;
		String  hql="from ComAcciModel cam";
		list=this.getHibernateTemplate().find(hql);
		return list;
	}
	//�¹�Ԥ��

	@SuppressWarnings("null")
	public int serAcdPridiction(int num) {
		List<AcciNumModel> acdnumlist=null;
		List<AcdIdYearModel> aylist = null;
	//	List<stdreasonidModel> stdlist=null;

		String[] stdlist=serStdreasonid(num).clone();
		int num_std=stdlist.length;
		for(int i=0;i<stdlist.length;i++){
			System.out.println(i+":"+stdlist[i]);
		}
		
		//Ȩ��list
		List<AcdReaToStanModel> deglist = null;
	
		//����ԭ��id
		//stdlist=serStdreasonid();
		
		//��ȡÿ���¹ʷ���������ݡ�
		acdnumlist=serAccident();
		
		//aylist = serAcdIdByYear("2004");
		//System.out.println("aylist ��һ�����¹�idΪ: "+aylist.get(4).getAcdId());
		//System.out.println("acdnumlist: "+acdnumlist.get(0).getNUM());
	         
	    //aylist=this.getHibernateTemplate().find("from AcdIdYearModel");
		int[] std_arr =  new int[stdlist.length];
	    double[][] Y_1 = new double[num][1];
	    double[][] X_1 = new double[num][stdlist.length];
	    double[][] X_11 = new double[acdnumlist.size()][25];
	    //��ʼ��X_1
	  //  System.out.println("stdlist.size:"+stdlist.size());
	    for(int i_stdlist=0;i_stdlist<stdlist.length;i_stdlist++){
	    	std_arr[i_stdlist]=Integer.valueOf(stdlist[i_stdlist]);
	    	System.out.println("std_arr���ݣ�"+std_arr[i_stdlist]);
	    }
	  //  System.out.println("����ĳ���Ϊ"+std_arr.length);
	    Matrix B = new Matrix(X_1);
	  //  B.print(5,5);
	   // System.out.println("shigu: "+acdnumlist.size());
	 //   for(int i_acdnumlist=0;i_acdnumlist<acdnumlist.size();i_acdnumlist++){
	    for(int i_acdnumlist=0;i_acdnumlist<num;i_acdnumlist++){
	    	aylist=serAcdIdByYear(acdnumlist.get(i_acdnumlist).getAcdYear());
	    	System.out.println("nian: "+aylist.size());
	    	for(int i_aylist=0;i_aylist<aylist.size();i_aylist++){
	    	//	System.out.println(aylist.get(i_aylist).getAcdId());
	    		deglist=serDegreeByAcdId(aylist.get(i_aylist).getAcdId());
	    		System.out.println("deglist size: "+deglist.size());
	    		if(deglist.size()>0){
	    		
	    		for(int i_deglist=0;i_deglist<deglist.size();i_deglist++){
	    			int stdReasonId = (deglist.get(i_deglist).getStdReasonId());
	    			System.out.println("stdReasonId: "+deglist.get(i_deglist).getStdReasonId());
	    			//if(i_deglist==stdReasonId-1){
	    			for(int i_std_arr=0;i_std_arr<num_std;i_std_arr++){
	    				if(std_arr[i_std_arr]==stdReasonId){
	    					X_1[i_acdnumlist][i_std_arr]=X_1[i_acdnumlist][i_std_arr]+deglist.get(i_deglist).getDegree();
	    					System.out.println("X_1[i_acdnumlist][i_std_arr]"+X_1[i_acdnumlist][i_std_arr]);
	    	    			
	    				}/*else{
	    					System.out.println("error");
	    					}*/
	    			}
	    			//X_1[i_acdnumlist][stdReasonId-1]=X_1[i_acdnumlist][stdReasonId-1]+deglist.get(i_deglist).getDegree();
	    			//X_11[i_acdnumlist][stdReasonId-1]=X_1[i_acdnumlist][stdReasonId-1]+deglist.get(i_deglist).getDegree();
	    		//	System.out.println(deglist.get(i_deglist).getDegree());//}
	    		
	    		}
	    		
	    		
	    		}
	    		else{
	    			System.out.println("��Ȩ��");
	    		}
	    	}
	    	
	    }
	  /* for(int i=0;i<acdnumlist.size();i++){
	    	for(int j=0;j<25;j++){
	    		if(X_1[i][j]==0){
	    		X_1[i][j]=(double)(r.nextInt(9)+1)/1000000;
	    		}
	    	}
	    }*/

	    //��ֵ��Y����
	    //for(int ii=0;ii<acdnumlist.size();ii++){
	    for(int ii=0;ii<num;ii++){
	    //	System.out.println(acdnumlist.get(ii).getAcdYear()+acdnumlist.get(ii).getNUM());
	    		Y_1[ii][0]=(double)acdnumlist.get(ii).getNUM();
	    		//System.out.println(Y_1[ii][0]);
	    }
	   // System.out.println("y_1:"+Y_1);
		double[][] X={{9,1,1},{5,4,1},{6,1,2},{3,4,5}};
		double[][] Y={{5},{2},{8},{3}};
	
		Matrix X_matrix=new Matrix(X_1);
		Matrix Y_matrix=new Matrix(Y_1);
		System.out.println("X����Ϊ: ");
		X_matrix.print(2,2);
		System.out.println("X_matrix���������Ϊ��"	+X_matrix.getRowDimension());
		System.out.println("X_matrix���������Ϊ��"	+X_matrix.getColumnDimension());
		Y_matrix.print(2,2);
		//Ԥ��ģ��
		Matrix F= ((X_matrix.transpose()).times(X_matrix));
		F.print(8,3);
		System.out.println("h����Ϊ:");
	//	(F.inverse()).times((X_matrix.transpose())).print(2,2);
	//	X_matrix.transpose().times(Y_matrix).print(2,2);
		Matrix H=(F.inverse()).times(X_matrix.transpose().times(Y_matrix));
		
	
	    H.print(4,8);
	  //��ȡ���������
		int row_value=H.getRowDimension();
		//int col_value=X_1.getColumnDimension();
		System.out.println("Column:"+row_value);
		H.get(0,0);
		double[] h_value= new double[row_value];
		
		double[] a_value=new double[num_std]; //��Ԥ������
		double sum=0.0;
		for(int k=0;k<num_std;k++){
			for(int i_row=0;i_row<X_matrix.getRowDimension();i_row++){
			a_value[k]=a_value[k]+X_matrix.get(i_row,k);}
			//System.out.println(a_value[k]);}
			
		}
		for(int i_a_value=0;i_a_value<a_value.length;i_a_value++){
		System.out.println("����"+i_a_value+":"+a_value[i_a_value]);
		a_value[i_a_value]=a_value[i_a_value]/X_matrix.getRowDimension();
		System.out.println("��ƽ����ı���"+i_a_value+":"+a_value[i_a_value]);
		}
		
		for(int i=0;i<row_value;i++){
			h_value[i]=H.get(i, 0);
		//	System.out.println(h_value[i]);
		}
		for(int j=0;j<row_value;j++){
			sum=sum+h_value[j]*a_value[j];	
			//System.out.println(sum);
		}
		//������
		int int_sum =(int)Math.ceil(sum);
		//int intd_sum =new BigDecimal(sum).setScale(0, BigDecimal.ROUND_HALF_UP);
		System.out.println("Ԥ���¹�����Ϊ "+int_sum);
		if(int_sum>=15){
			int_sum=15;
		}else if(int_sum<0){
			int_sum=0;
		}
		// TODO Auto-generated method stub
		return int_sum;
	}

	public String getRetYear() {
		String reYear = null;
		List<AcciNumModel> list = null;
		String hql="from AcciNumModel ";
		
	    list=this.getHibernateTemplate().find(hql);	
	   reYear=list.get(list.size()-1).getAcdYear();
	   List<stdreasonidModel> stdlist = null;
	   stdlist=this.getHibernateTemplate().find("from stdreasonidModel");
	   System.out.println( "std��С: "+stdlist.size());
		return reYear;
	}
	public String[] serStdreasonid(int num_year){
			int std_num=0;
		   //List<stdreasonidModel> stdlist = null;
		   List<AcciNumModel> acdnumlist=null;
		   List<AcdIdYearModel> aiylist=null;
		   acdnumlist=serAccident();
		   String[] str_y = new String[num_year];
		   String[] s ;
		   String[] str_acdId= new String[getHibernateTemplate().find("from AcdIdYearModel").size()];
		   String hql="";
		   int acd_num = 0;
		   for(int i=0;i<num_year;i++){
			   
			   str_y[i]=acdnumlist.get(i).getAcdYear();
			   System.out.println(str_y[i]);
			   aiylist=serAcdIdByYear(str_y[i]);
			   for(int j=0;j<aiylist.size();j++){
				   str_acdId[acd_num] = aiylist.get(j).getAcdId();
				   System.out.println(str_acdId[acd_num]);
				   acd_num++;
				   System.out.println(aiylist.get(j).getAcdId());
			   }
			   
		   }
		   hql=str_acdId[0];
		   System.out.println(" str_acdId"+str_acdId[0]);
		   for(int j=1;j<acd_num;j++){
			   hql=hql+" or acdId="+Integer.valueOf(str_acdId[j]);
		   }
		   System.out.println(hql);
		   System.out.println("���鳤��:"+acd_num);
		   std_num =   this.getHibernateTemplate().find("select distinct(stdReasonId) from AcdReaToStanModel where degree>0 and acdId="+hql).size();
		   //String ss="select distinct(stdReasonId) from cn.edu.ncist.dataAnalyze.realtime.vo.AcdReaToStanModel where acdId=56 or acdId=57 or acdId=58 or acdId=59 or acdId=60 or acdId=41 or acdId=42 or acdId=43 or acdId=44 or acdId=45 or acdId=46 or acdId=47 or acdId=48 or acdId=49 or acdId=50 or acdId=51 or acdId=52 or acdId=53 or acdId=54 or acdId=55 or acdId=34 or acdId=35 or acdId=36 or acdId=37 or acdId=38 or acdId=39 or acdId=40 or acdId=30 or acdId=31 or acdId=32 or acdId=33 or acdId=27 or acdId=28 or acdId=29 or acdId=26 or acdId=19 or acdId=20 or acdId=21 or acdId=22 or acdId=23 or acdId=24 or acdId=25 or acdId=15 or acdId=16 or acdId=17 or acdId=18 or acdId=13 or acdId=14   ";
		  // std_num =   this.getHibernateTemplate().find(ss).size();
		   System.out.println("std_num:" +this.getHibernateTemplate().find("select distinct(stdReasonId) from AcdReaToStanModel where degree!=0 and acdId="+hql).size());
		 
		 s= new String[std_num];
		 if(num_year==12){
			 for(int k=0;k<std_num;k++){
				 s[k]=getHibernateTemplate().find("select distinct(stdReasonId) from AcdReaToStanModel order by stdReasonId").get(k).toString();
			 }
		 }else{
		 for(int k=0;k<std_num;k++){
		 s[k]=getHibernateTemplate().find("select distinct(stdReasonId) from AcdReaToStanModel where degree!=0 and acdId="+hql+"order by stdReasonId").get(k).toString();
		 System.out.println("s["+k+"]"+s[k]);
		 }
		 }
		  System.out.println("��׼ԭ��ĸ���:"+std_num);
		return    s;
		
	}
	public List<stdreasonidModel> serStdreasonid(){
		   List<stdreasonidModel> stdlist = null;
		 
		   stdlist=this.getHibernateTemplate().find("from stdreasonidModel");
		  
		return stdlist;
		
	}
	public String serSavePridiction(AcdPriModel apm) {
		//this.getHibernateTemplate().save(apm);
		this.getHibernateTemplate().update(apm);
		return "success";
	}
    //��ѯÿ�귢���¹ʵ�ID
	public List<AcdIdYearModel> serAcdIdByYear(String acdYear) {
		String hql="from AcdIdYearModel aiym where acdYear="+acdYear;
		return this.getHibernateTemplate().find(hql);
	}
	//ͨ���¹�id��ѯȨ��
	public List<AcdReaToStanModel> serDegreeByAcdId(String acdId) {
		List<AcdReaToStanModel> list=null;
		String hql="from AcdReaToStanModel artsm where acdId='"+acdId+"'";
		list= this.getHibernateTemplate().find(hql);
		
		return list;
	
	}
	//�¹�ԭ�������
	public List<AccidentModel> serAccident(int i) {
		//����i������ֵ����ѯ��䡣
		
		String hq2="From AccidentModel";
		return this.getHibernateTemplate().find(hq2);
	}
	//cause���������������year�����������
	public List<AccidentModel> serAccident(int cause, int year) {
		//�����������cause���������¹ʡ�
		 List<AccidentModel> list1= null;
		 List<ReasonToStandModel> list2= null;
		 List<AccidentModel> list3= null;
		list3 = new LinkedList<AccidentModel>();
		
		String hq2="From AccidentModel";
		String newyearStr = "select Max(acdYear) from AccidentModel";		//�����������Ȳ�����һ���
		String newyearS =  getHibernateTemplate().find(newyearStr).toString();
		newyearS = newyearS.substring(1, 5);
		System.out.println(newyearS);
		int newyearI = Integer.parseInt(newyearS);
		for (int j=0;j<year;j++)
		{
			String yearS = String.valueOf(newyearI - j);
			yearS = "'" + yearS + "'";
			String acdStr = "from AccidentModel where acdYear like " + yearS;
			list1=getHibernateTemplate().find(acdStr);
			for (AccidentModel m : list1)		//������һ�����������¹ʡ�
			{	
				//��������ɸѡ�¹�ģ�͡�
				String acdId = m.getAcdId();
				acdId = "'" + acdId + "'";
				String causeStr = "from ReasonToStandModel where acdId like " + acdId;		//�����¹�ID������
				list2 = this.getHibernateTemplate().find(causeStr);							//���������¹�ID������϶���25����ÿһ����Ӧ��ͬ����
				if(list2.size()>0){
				if (!list2.get(cause).getDegree().equals("0"))
				{
					list3.add(m);
				}
			  }
			}
		}
		
		return list3;
	}

	

	

}
