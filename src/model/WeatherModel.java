package model;

public class WeatherModel {
	
	private String cityName;
	private String countryCode;
	private Double minTemperature;
	private Double maxTemperature;
	private Double currentTemperature;
	private Integer humidityPercent;
	private String sunriseTime;
	private String sunsetTime;

	public String getCityName() 
	{
		return cityName;
	}

	public void setCityName(String cityName) 
	{
		this.cityName = cityName;
	}

	public String getCountryCode() 
	{
		return countryCode;
	}

	public void setCountryCode(String countryCode) 
	{
		this.countryCode = countryCode;
	}
	
	public Double getMinTemperature() 
	{
		return minTemperature;
	}

	public void setMinTemperature(Double minTemperature) 
	{
		this.minTemperature = minTemperature;
	}

	public Double getMaxTemperature() 
	{
		return maxTemperature;
	}

	public void setMaxTemperature(Double maxTemperature) 
	{
		this.maxTemperature = maxTemperature;
	}

	public Double getCurrentTemperature() 
	{
		return currentTemperature;
	}

	public void setCurrentTemperature(Double currentTemperature) 
	{
		this.currentTemperature = currentTemperature;
	}

	public Integer getHumidityPercent() 
	{
		return humidityPercent;
	}

	public void setHumidityPercent(Integer humidityPercent) 
	{
		this.humidityPercent = humidityPercent;
	}

	public String getSunriseTime() 
	{
		return sunriseTime;
	}

	public void setSunriseTime(String sunriseTime) 
	{
		this.sunriseTime = sunriseTime;
	}

	public String getSunsetTime() 
	{
		return sunsetTime;
	}

	public void setSunsetTime(String sunsetTime) 
	{
		this.sunsetTime = sunsetTime;
	}
}
