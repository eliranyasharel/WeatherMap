package exceptions;

/**
 * Exception that describes weather data service failure
 */
public class WeatherDataServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MESSAGE = "Failed to get weather data";
	
	public WeatherDataServiceException ()
	{
		super(DEFAULT_MESSAGE);
	}
}
