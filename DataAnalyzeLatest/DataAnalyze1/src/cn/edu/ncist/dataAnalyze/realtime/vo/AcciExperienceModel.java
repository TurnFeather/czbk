package cn.edu.ncist.dataAnalyze.realtime.vo;

public class AcciExperienceModel {
	
	String acdLesson; //�¹ʾ���
	String acdId; //�¹�Id
	int acdOrder;//����˳���
	String lessonId; //����id
	
	
	public String getLessonId() {
		return lessonId;
	}
	public void setLessonId(String lessonId) {
		this.lessonId = lessonId;
	}
	public int getAcdOrder() {
		return acdOrder;
	}
	public void setAcdOrder(int acdOrder) {
		this.acdOrder = acdOrder;
	}
	public String getAcdLesson() {
		return acdLesson;
	}
	public void setAcdLesson(String acdLesson) {
		this.acdLesson = acdLesson;
	}
	public String getAcdId() {
		return acdId;
	}
	public void setAcdId(String acdId) {
		this.acdId = acdId;
	}
}
