package model;

import DAL.IWeatherDataProvider;
import exceptions.WeatherDataServiceException;

/**
 * Interface that describes the weather data service API
 */
public interface IWeatherDataService {

	public WeatherData getWeatherData(
			IWeatherDataProvider weatherDataProvider, Location location) 
					throws WeatherDataServiceException;
	
	public WeatherData getWeatherData();
	
}
