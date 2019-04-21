import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherMonitor implements IWeather{
	
	private IWeather Reports;
	
	public WeatherMonitor(IWeather Reports) {this.Reports = Reports;}
	public IWeather getReport() {return this.Reports;}
	
	/**
	 * averageRainfallForMonth 
	 * calculates and returns the average temperature during a given month
	 * 
	 * @param month of the desired data readings
	 * @param year of the desired month
	 * @return average temperature reading for given month
	 */
	public double averageTempForMonth(int month, int year){
		return this.Reports.averageTempForMonth(month, year);
	}
	
	/**
	 * totalRainfallForMonth
	 * calculates and returns the total amount of rainfall during a given month
	 * 
	 * @param month of the desired data readings
	 * @param year of the desired month
	 * @return total amount of rainfall for the given month in the given year
	 */
	public double totalRainfallForMonth(int month, int year) {
		return this.Reports.totalRainfallForMonth(month, year);
	}
	
	/**
	 * addDailyReport 
	 * adds a DailyWeatherReport to the WeatherMonitor database.
	 * 
	 * @param date date of the readings
	 * @param readings temperature and rainfall for given date
	 */
	public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings){
		this.Reports.addDailyReport(date,readings);
	}
	
}

