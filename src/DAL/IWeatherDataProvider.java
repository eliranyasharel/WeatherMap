package DAL;

import model.Location;
import model.WeatherData;

/**
 * Interface that represents the weather data provider API
 */
public interface IWeatherDataProvider {

	public WeatherData getWeatherData(Location location);
	
}
