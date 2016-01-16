package tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.mockito.Mockito;

import DAL.IWeatherDataProvider;
import exceptions.WeatherDataServiceException;
import model.Clouds;
import model.Coord;
import model.Location;
import model.Main;
import model.OpenWeatherMapDataService;
import model.Sys;
import model.Weather;
import model.WeatherData;
import model.Wind;

public class AllTests {
	
	private WeatherData weatherData;
	
	/**
	 * Prepare the WeatherData object to return by the mock
	 */
	 @Before
	 public void initObjects() {
		 
		 weatherData = new WeatherData();
			
		 Coord coord = new Coord();
		 coord.setLon(-74.01);
		 coord.setLat(40.71);
			
		 List<Weather> weatherList = new LinkedList<Weather>();
		 Weather weather1 = new Weather();
		 weather1.setId(500);
		 weather1.setMain("Rain");
		 weather1.setDescription("light rain");
		 weather1.setIcon("10d");
			
		 Weather weather2 = new Weather();
		 weather1.setId(701);
		 weather1.setMain("Mist");
		 weather1.setDescription("mist");
		 weather1.setIcon("50d");
			
		 weatherList.add(weather1);
		 weatherList.add(weather2);
			
		 String base = "cmc stations";
			
		 Main main = new Main();
		 main.setTemp(Double.valueOf(15.5));
			
		 Wind wind = new Wind();
		 wind.setSpeed(2.1);
		 wind.setDeg(280);
			
		 Clouds clouds = new Clouds();
		 clouds.setAll(90);
			
		 Long dt = 1452957980L;
			
		 Sys sys = new Sys();
		 sys.setType(1);
		 sys.setId(1966);
		 sys.setMessage(0.0087);
		 sys.setCountry("US");
		 sys.setSunrise(1452946646L);
		 sys.setSunset(1452981281L);
			
		 Long id = 5128581L;
		 String name = "New York";
		 Integer cod = 200;
			
		 weatherData.setCoord(coord);
		 weatherData.setWeather(weatherList);
		 weatherData.setBase(base);
		 weatherData.setMain(main);
		 weatherData.setWind(wind);
		 weatherData.setClouds(clouds);
		 weatherData.setDt(dt);
		 weatherData.setSys(sys);
		 weatherData.setId(id);
		 weatherData.setName(name);
		 weatherData.setCod(cod);
	 }
	
	/**
	 * Test the OpenWeatherMapDataService
	 */
	@Test
	public void testOpenWeatherMapDataService ()
	{
		OpenWeatherMapDataService openWeatherMapDataService = new OpenWeatherMapDataService();
		Location location = new Location("New-York");
		
		//Create an IWeatherDataProvider mock
		IWeatherDataProvider provider = Mockito.mock(IWeatherDataProvider.class);
		
		//Set the IWeatherDataProvider mock to return weatherData when running getWeatherData(location)
		Mockito.when(provider.getWeatherData(location)).thenReturn(weatherData);
		
		try {
			assertEquals(weatherData, openWeatherMapDataService.getWeatherData(provider, location));
		} catch (WeatherDataServiceException e) {
			e.printStackTrace();
		}
	}
}
