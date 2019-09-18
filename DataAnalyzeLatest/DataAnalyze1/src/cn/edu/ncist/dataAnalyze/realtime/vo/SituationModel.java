package cn.edu.ncist.dataAnalyze.realtime.vo;

public class SituationModel 
{
	private int id;
	private int Year;
	private int Month;
	private int Day;
	private int Hour;
	private double Temperature;
	private double Humidity;
	private double WindSpeed;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return Year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		Year = year;
	}
	/**
	 * @return the month
	 */
	public int getMonth() {
		return Month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		Month = month;
	}
	/**
	 * @return the day
	 */
	public int getDay() {
		return Day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		Day = day;
	}
	/**
	 * @return the hour
	 */
	public int getHour() {
		return Hour;
	}
	/**
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		Hour = hour;
	}
	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return Temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		Temperature = temperature;
	}
	/**
	 * @return the humidity
	 */
	public double getHumidity() {
		return Humidity;
	}
	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(double humidity) {
		Humidity = humidity;
	}
	/**
	 * @return the windSpeed
	 */
	public double getWindSpeed() {
		return WindSpeed;
	}
	/**
	 * @param windSpeed the windSpeed to set
	 */
	public void setWindSpeed(double windSpeed) {
		WindSpeed = windSpeed;
	}
	
	
}
