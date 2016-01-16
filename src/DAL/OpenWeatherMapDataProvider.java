package DAL;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import model.Location;
import model.WeatherData;

/**
 * Weather data provider for openweathermap.org
 */
public class OpenWeatherMapDataProvider implements IWeatherDataProvider {

	//openweathermap.org API URL with place holders for the city name and API key
	private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&APPID=%s";
	//openweathermap.org API key
	private static final String API_KEY = "413f69f2c7bbc3a96792f233cc6eb2bf";

	/**
	 * Get the weather data for the provided location from openweathermap.org.
	 * @param location
	 * @return WeatherData or null if failed
	 */
	@Override
	public WeatherData getWeatherData(Location location)
	{
		WeatherData weatherData;
		
		//Construct the API url
		String apiUrl = String.format(API_URL, location.getCity(), API_KEY);
		HttpURLConnection connection = null;
		
		  try 
		  {
			  connection = (HttpURLConnection) new URL(apiUrl).openConnection();
			  connection.setRequestMethod("POST");

			  //Get real time data without cache
			  connection.setUseCaches(false);
			  //Set the connection to use output
			  connection.setDoOutput(true);

			  //Send request
			  DataOutputStream out = new DataOutputStream (connection.getOutputStream());
			  out.writeBytes("");
			  out.close();

			  //Get Response  
			  InputStream in = connection.getInputStream();
			  BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		    
			  //Read the response into a String
			  String weatherDataStr = reader.lines().
					  reduce("", (accumulator, actual) -> accumulator + actual);
		    
			  reader.close();
		    
			  //Convert the response String to a WeatherData object
			  weatherData = new Gson().fromJson(weatherDataStr, WeatherData.class);
		  } 
		  catch (Exception e) 
		  {
			  //Return null for failure
			  weatherData = null;
		  } 
		  finally 
		  {
			  if(connection != null)
			  {
				  connection.disconnect(); 
			  }
		  }
		  
		  return weatherData;
	}
}
