public class Weather {
	private int wind;  // using the access modifier private, data members are encapsulated (accessible in class scope only)
	private int temperature;
	private int feels_like;
	private int Humidity;
	private String Visibility;
	private int	precipitation;
	
	public Weather() { //non parameterized constructor	
		setWind(0);
		setFeels_like(0);
		setHumidity(0);
		setTemperature(0);
		setPrecipitation(0);
		setVisibility("Unknown");
	}
	
	public Weather(int wind, int temperature, int feels_like, int humidity,int	precipitation, String visibility) { //parameterized constructor	
		setWind(wind);
		setFeels_like(feels_like);
		setHumidity(humidity);
		setTemperature(temperature);
		setPrecipitation(precipitation);
		setVisibility(visibility);
	}
	public int getWind() {// get methods return the data
		return wind;
	}
	public void setWind(int wind) { // set methods modify the data 
		this.wind = wind;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(int feels_like) {
		this.feels_like = feels_like;
	}
	public int getHumidity() {
		return Humidity;
	}
	public void setHumidity(int humidity) {
		this.Humidity = humidity;
	}
	public int getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(int precipitation) {
		this.precipitation = precipitation;
	}
	public String getVisibility() {
		return Visibility;
	}
	public void setVisibility(String visibility) {
		this.Visibility = visibility;
	}
	public void display(){
	        System.out.println("Wind:			 " + getWind());
	        System.out.println("Temperature:	 " + getTemperature());
	        System.out.println("Feels_like:		 " + getFeels_like());
	        System.out.println("Humidity:	   	 " + getHumidity());
	        System.out.println("Precipitation:	 " + getPrecipitation());
	 }	
}
