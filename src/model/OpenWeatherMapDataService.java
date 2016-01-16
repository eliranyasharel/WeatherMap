package model;

import java.util.Observable;

import DAL.IWeatherDataProvider;
import exceptions.WeatherDataServiceException;

/**
 * Weather data service for openweathermap.org
 */
public class OpenWeatherMapDataService extends Observable implements IWeatherDataService {

	WeatherData weatherData;
	
	/**
	 * Get the weather data according to the location
	 * @param weatherDataProvider
	 * @param location
	 * @return WeatherData
	 * @throws WeatherDataServiceException
	 */
	@Override
	public WeatherData getWeatherData(
			IWeatherDataProvider weatherDataProvider, Location location) 
					throws WeatherDataServiceException 
	{
		weatherData = weatherDataProvider.getWeatherData(location);
		
		if (weatherData == null)
		{
			throw new WeatherDataServiceException();
		}
		
		this.setChanged();
		notifyObservers();
		
		return weatherData;
	}

	/**
	 * Get the updated WeatherData
	 * @return WeatherData
	 */
	@Override
	public WeatherData getWeatherData() 
	{
		return weatherData;
	}
}