import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface IWeather {
	double averageTempForMonth(int month, int year);
	double totalRainfallForMonth(int month, int year);
	void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings);
}
