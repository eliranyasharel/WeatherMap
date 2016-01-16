package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.TimeZone;

import exceptions.WeatherDataServiceException;
import model.IWeatherDataService;
import model.Location;
import model.WeatherData;
import model.WeatherDataServiceType;
import model.WeatherModel;

/**
 * Controller for retrieving the relevant weather data according to the requested location
 * Observes the chosen weather data service and updates the returned model accordingly
 */
public class WeatherConroller implements Observer {
	
	private WeatherModel model;
	
	@Override
	public void update(Observable o, Object arg) 
	{
		WeatherData weatherData = ((IWeatherDataService)o).getWeatherData();
		
		if (weatherData != null && weatherData.getBase() != null)
		{
			model = new WeatherModel(); 
			
			model.setCityName(weatherData.getName());
			model.setCountryCode(weatherData.getSys().getCountry());
			model.setMinTemperature(weatherData.getMain().getTemp_min());
			model.setMaxTemperature(weatherData.getMain().getTemp_max());
			model.setCurrentTemperature(weatherData.getMain().getTemp());
			model.setHumidityPercent(weatherData.getMain().getHumidity());
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss z"); // the format of your date
			dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
			
			Date sunriseDate = new Date(weatherData.getSys().getSunrise() * 1000);
			Date sunsetDate = new Date(weatherData.getSys().getSunset() * 1000);
			
			model.setSunriseTime(dateFormat.format(sunriseDate));
			model.setSunsetTime(dateFormat.format(sunsetDate));
		}
	}
	
	/**
	 * Get the weather data according to the location
	 * @param weatherDataModelType
	 * @param location
	 * @return WeatherModel
	 * @throws WeatherDataServiceException
	 */
	public WeatherModel getWeatherDataService (
			WeatherDataServiceType weatherDataModelType, Location location) 
					throws WeatherDataServiceException
	{
		IWeatherDataService weatherDataService = weatherDataModelType.getWeatherDataService();
		
		if (weatherDataService instanceof Observable)
		{
			((Observable)weatherDataService).addObserver(this);
		}
		
		weatherDataService.getWeatherData(
				weatherDataModelType.getWeatherDataProvider(), location);
		
		return model;
	}
}
