package cn.edu.ncist.dataAnalyze.realtime.vo;

public class AccidentModel {
	
	String acdId; //事故编号
	String acdName; //事故名称
	String acdProvince; //事故发生省份
	String acdCity;
	String acdLocale;
	String acdYear;
	String acdMonth;
	String Temperature;
	String Humidity;
	String WindSpeed;
	String AirQuality;
	String acdSituation;
	String acdDateTime;
	String acdCompany;
	String acdCompanyOverview;
	String acdOverview;
	int minorInjuryNum;
	int badlyInjuryNum;
	int deathNum;
	float directEconomicLoss;
	String acdGrade;
	String acdType;
	String acdProperties;
	String emergencyDisposal; //紧急处理
	String incidence;
	String acdReason;
	String endDate; //结束日期
	String vehicleType; //车辆类型
	String numberPlate; //车牌号
	String weatherCondition; //天气状况
	String driverCondition;
	String equipmentCondition;
	String causeThingsSituation;
	String acdKeywords;
	String acdDataIndex;
	
	//String equipmentCondition;
	//String driverCondition;
	
	
	public String getAcdName() {
		return acdName;
	}
	public String getAcdId() {
		return acdId;
	}
	public void setAcdId(String acdId) {
		this.acdId = acdId;
	}
	public String getTemperature() {
		return Temperature;
	}
	public void setTemperature(String temperature) {
		Temperature = temperature;
	}
	public String getHumidity() {
		return Humidity;
	}
	public void setHumidity(String humidity) {
		Humidity = humidity;
	}
	public String getWindSpeed() {
		return WindSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		WindSpeed = windSpeed;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public String getWeatherCondition() {
		return weatherCondition;
	}
	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}
	public String getDriverCondition() {
		return driverCondition;
	}
	public void setDriverCondition(String driverCondition) {
		this.driverCondition = driverCondition;
	}
	public String getEquipmentCondition() {
		return equipmentCondition;
	}
	public void setEquipmentCondition(String equipmentCondition) {
		this.equipmentCondition = equipmentCondition;
	}
	public String getCauseThingsSituation() {
		return causeThingsSituation;
	}
	public void setCauseThingsSituation(String causeThingsSituation) {
		this.causeThingsSituation = causeThingsSituation;
	}
	public String getAcdKeywords() {
		return acdKeywords;
	}
	public void setAcdKeywords(String acdKeywords) {
		this.acdKeywords = acdKeywords;
	}
	public String getAcdDataIndex() {
		return acdDataIndex;
	}
	public void setAcdDataIndex(String acdDataIndex) {
		this.acdDataIndex = acdDataIndex;
	}
	public void setAcdName(String acdName) {
		this.acdName = acdName;
	}
	public String getAcdProvince() {
		return acdProvince;
	}
	public void setAcdProvince(String acdProvince) {
		this.acdProvince = acdProvince;
	}
	public String getAcdCity() {
		return acdCity;
	}
	public void setAcdCity(String acdCity) {
		this.acdCity = acdCity;
	}
	public String getAcdLocale() {
		return acdLocale;
	}
	public void setAcdLocale(String acdLocale) {
		this.acdLocale = acdLocale;
	}
	public String getAcdYear() {
		return acdYear;
	}
	public void setAcdYear(String acdYear) {
		this.acdYear = acdYear;
	}
	public String getAcdMonth() {
		return acdMonth;
	}
	public void setAcdMonth(String acdMonth) {
		this.acdMonth = acdMonth;
	}
	public String getAirQuality() {
		return AirQuality;
	}
	public void setAirQuality(String airQuality) {
		AirQuality = airQuality;
	}
	public String getAcdSituation() {
		return acdSituation;
	}
	public void setAcdSituation(String acdSituation) {
		this.acdSituation = acdSituation;
	}
	public String getAcdDateTime() {
		return acdDateTime;
	}
	public void setAcdDateTime(String acdDateTime) {
		this.acdDateTime = acdDateTime;
	}
	public String getAcdCompany() {
		return acdCompany;
	}
	public void setAcdCompany(String acdCompany) {
		this.acdCompany = acdCompany;
	}
	public String getAcdCompanyOverview() {
		return acdCompanyOverview;
	}
	public void setAcdCompanyOverview(String acdCompanyOverview) {
		this.acdCompanyOverview = acdCompanyOverview;
	}
	public String getAcdOverview() {
		return acdOverview;
	}
	public void setAcdOverview(String acdOverview) {
		this.acdOverview = acdOverview;
	}
	public int getMinorInjuryNum() {
		return minorInjuryNum;
	}
	public void setMinorInjuryNum(int minorInjuryNum) {
		this.minorInjuryNum = minorInjuryNum;
	}
	public int getBadlyInjuryNum() {
		return badlyInjuryNum;
	}
	public void setBadlyInjuryNum(int badlyInjuryNum) {
		this.badlyInjuryNum = badlyInjuryNum;
	}
	public int getDeathNum() {
		return deathNum;
	}
	public void setDeathNum(int deathNum) {
		this.deathNum = deathNum;
	}
	public float getDirectEconomicLoss() {
		return directEconomicLoss;
	}
	public void setDirectEconomicLoss(float directEconomicLoss) {
		this.directEconomicLoss = directEconomicLoss;
	}
	public String getAcdGrade() {
		return acdGrade;
	}
	public void setAcdGrade(String acdGrade) {
		this.acdGrade = acdGrade;
	}
	public String getAcdType() {
		return acdType;
	}
	public void setAcdType(String acdType) {
		this.acdType = acdType;
	}
	public String getAcdProperties() {
		return acdProperties;
	}
	public void setAcdProperties(String acdProperties) {
		this.acdProperties = acdProperties;
	}
	public String getEmergencyDisposal() {
		return emergencyDisposal;
	}
	public void setEmergencyDisposal(String emergencyDisposal) {
		this.emergencyDisposal = emergencyDisposal;
	}
	public String getIncidence() {
		return incidence;
	}
	public void setIncidence(String incidence) {
		this.incidence = incidence;
	}
	public String getAcdReason() {
		return acdReason;
	}
	public void setAcdReason(String acdReason) {
		this.acdReason = acdReason;
	}
	
	
	

	
	
	

}
