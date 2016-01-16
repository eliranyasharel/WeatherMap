package model;

import DAL.IWeatherDataProvider;
import DAL.OpenWeatherMapDataProvider;

/**
 * ENUM that represents the weather data service types.
 * Implements the Command pattern to get the relevant weather
 * data service and weather data provider according to the ENUM value
 */
public enum WeatherDataServiceType {
	
	OPEN_WEATHER_MAP {
		
		@Override
		public IWeatherDataService getWeatherDataService() 
		{
			return new OpenWeatherMapDataService();
		}

		@Override
		public IWeatherDataProvider getWeatherDataProvider() 
		{
			return new OpenWeatherMapDataProvider();
		}
	};
	
	/**
	 * Get the WeatherDataService according to the ENUM value
	 * @return IWeatherDataService
	 */
	public abstract IWeatherDataService getWeatherDataService();
	
	/**
	 * Get the WeatherDataProvider according to the ENUM value
	 * @return IWeatherDataProvider
	 */
	public abstract IWeatherDataProvider getWeatherDataProvider();

}
