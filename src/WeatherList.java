import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherList implements IWeather{
	private LinkedList<DailyWeatherReport> Reports;
	
	WeatherList(){
		this.Reports = new LinkedList<DailyWeatherReport>();
	}
	
	/**
	 * averageRainfallForMonth 
	 * calculates and returns the average temperature during a given month
	 * 
	 * @param month of the desired data readings
	 * @param year of the desired month
	 * @return average temperature reading for given month
	 */
	public double averageTempForMonth(int month, int year){
		LinkedList<DailyWeatherReport> temp = new LinkedList<DailyWeatherReport>();
		double sum = 0;
		for (DailyWeatherReport report : this.Reports) {
			if (report.getDate().get(GregorianCalendar.YEAR) == year && report.getDate().get(GregorianCalendar.MONTH) == month) {
				temp.add(report);
			}
				
		}
		for (DailyWeatherReport report : temp) {
			sum = sum + report.getTempAvg();
		}
		
		return sum/temp.size();
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
		LinkedList<DailyWeatherReport> temp2 = new LinkedList<DailyWeatherReport>();
		double sum = 0;
		for (DailyWeatherReport report : this.Reports) {
			if (report.getDate().get(GregorianCalendar.YEAR) == year && report.getDate().get(GregorianCalendar.MONTH) == month) {
					temp2.add(report);
				}
		}
		//System.out.println(this.Reports.size());
		//System.out.println(temp2.size());
		for (DailyWeatherReport report : temp2) {
			sum = sum + report.getRainTotal();
			System.out.println(report.getRainTotal());
		}
		
		return sum;
	}
	
	/**
	 * addDailyReport 
	 * adds a DailyWeatherReport to the WeatherMonitor database.
	 * 
	 * @param date date of the readings
	 * @param readings temperature and rainfall for given date
	 */
	public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings){
		LinkedList<Double> temperature = new LinkedList<Double>();
		LinkedList<Double> rainfall = new LinkedList<Double>();
		for(Reading reading : readings) {
			temperature.add(reading.getTemp());
			rainfall.add(reading.getRainfall());
		}
		this.Reports.add(new DailyWeatherReport(date,temperature,rainfall));
	}
}
