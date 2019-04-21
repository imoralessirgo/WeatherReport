import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyWeatherReport {
	private GregorianCalendar date; 
	private LinkedList<Double> temp;
	private LinkedList<Double> rainfall;

	
	public DailyWeatherReport(GregorianCalendar date,LinkedList<Double> temp,LinkedList<Double> rainfall) {
		this.date = date;
		this.temp = temp;
		this.rainfall = rainfall;
	}
	
	public GregorianCalendar getDate(){return this.date;}
//	public LinkedList<Double> getTemp(){return this.temp;}
//	public LinkedList<Double> getRainfall(){return this.rainfall;}
	
	/**
	 * getTempAvg
	 * Calculates the avg temperature for the day
	 * 
	 * @return average temp
	 */
	public double getTempAvg() {
		double sum = addAllElts(this.temp);
		return sum/this.temp.size();
	}
	
	/**
	 * getRainTotal
	 * gets the total number of rainfall in a day
	 * 
	 * @return double representing total rainfall
	 */
	public double getRainTotal() {
		return addAllElts(this.rainfall);
	}
	
	/**
	 * addAllElts 
	 * adds all the elements in a list of doubles
	 * 
	 * @param list of doubles
	 * @return sum of all doubles
	 */
	public double addAllElts(LinkedList<Double> list) {
		double sum = 0;
		for (double elt : list) {
			sum = sum + elt;
		}
		return sum;
	}
}
