package cn.itcast.domain;

import java.util.List;

//��ʾÿҳ����Ҫ��ȫ������
public class Page {
	private List recorders;
	private int pagesize = 10;	//ÿҳ��¼��
	private int pagenum;		//��ǰҳ����
	private int totalpage;		//��ҳ��
	private int startIndex;		//ÿҳ��ʼ����
	private int totalrecords;	//�ܼ�¼����
	
	public Page(int pagenum,int totalrecords)
	{
		this.pagenum = pagenum;
		this.totalrecords = totalrecords;
		totalpage = totalrecords%pagesize==0?totalrecords/pagesize:(totalrecords/pagesize+1);
		startIndex = (pagenum - 1) * pagesize;
	}
	
	public List getRecorders() {
		return recorders;
	}
	public void setRecorders(List recorders) {
		this.recorders = recorders;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalrecords() {
		return totalrecords;
	}
	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}
}
