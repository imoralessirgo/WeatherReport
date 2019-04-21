import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

public class Examples {

	WeatherList WL = new WeatherList();
	WeatherMonitor WM = new WeatherMonitor(WL);
	
	Reading R1 = new Reading(new Time(12,34),18,1);
	Reading R2 = new Reading(new Time(1,43),19,1);
	Reading R3 = new Reading(new Time(22,55),20,1);
	Reading R4 = new Reading(new Time(7,15),21,1);
	Reading R5 = new Reading(new Time(11,04),22,1);
	LinkedList<Reading> RL = new LinkedList<Reading>();
	LinkedList<Double> temp = new LinkedList<Double>(Arrays.asList(1.0, 2.0,3.0));
	LinkedList<Double> rain = new LinkedList<Double>(Arrays.asList(1.0, 2.0,3.0));
	
	DailyWeatherReport DWR = new DailyWeatherReport(new GregorianCalendar(2018,11,10),temp,rain);

	
	public Examples(){
		RL.add(R1);
		RL.add(R2);
		RL.add(R3);
		RL.add(R4);
		RL.add(R5);
		//WM.addDailyReport(new GregorianCalendar(2018,11,10),RL);
		WL.addDailyReport(new GregorianCalendar(2018,11,10),RL);
		///DailyWeatherReport DWR = new DailyWeatherReport(new GregorianCalendar(2018,11,10),temp,rain);
	}
	
	
	
	@Test
	public void testListSize() {
		//System.out.println(RL.size());
		//System.out.println(WL.totalRainfallForMonth(11, 2018));
		//System.out.println(DWR.getRainTotal());
		assertEquals(RL.size(),5);
	}
	
	@Test
	public void testAddDailyReport() {
		assertEquals(WM.getReport(), WL);
	}

	@Test
	public void testAvgTempForMonth() {
		assertEquals(WM.averageTempForMonth(11, 2018),20,0.1);
	}

	@Test
	public void testTotalRainForMonth() {
		System.out.println(WM.getReport().totalRainfallForMonth(11, 2018));
		assertEquals(WM.totalRainfallForMonth(11, 2018),5,0.1);
	}
}
