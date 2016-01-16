package model;

import java.util.List;

public class WeatherData {
	
	private Coord coord;
	private List<Weather> weather;
	private String base;
	private Main main;
	private Wind wind;
	private Clouds clouds;
	private Long dt;
	private Sys sys;
	private Long id;
	private String name;
	private Integer cod;
	
	public Coord getCoord() 
	{
		return coord;
	}
	
	public void setCoord(Coord coord)
	{
		this.coord = coord;
	}
	
	public List<Weather> getWeather() 
	{
		return weather;
	}
	
	public void setWeather(List<Weather> weather) 
	{
		this.weather = weather;
	}
	
	public String getBase() 
	{
		return base;
	}
	
	public void setBase(String base) 
	{
		this.base = base;
	}
	
	public Main getMain() 
	{
		return main;
	}
	
	public void setMain(Main main)
	{
		this.main = main;
	}
	
	public Wind getWind() 
	{
		return wind;
	}
	
	public void setWind(Wind wind)
	{
		this.wind = wind;
	}
	
	public Clouds getClouds() 
	{
		return clouds;
	}
	
	public void setClouds(Clouds clouds) 
	{
		this.clouds = clouds;
	}
	
	public Long getDt() 
	{
		return dt;
	}
	
	public void setDt(Long dt) 
	{
		this.dt = dt;
	}
	
	public Sys getSys() 
	{
		return sys;
	}
	
	public void setSys(Sys sys) 
	{
		this.sys = sys;
	}
	
	public Long getId() 
	{
		return id;
	}
	
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Integer getCod()
	{
		return cod;
	}
	
	public void setCod(Integer cod) 
	{
		this.cod = cod;
	}
}
