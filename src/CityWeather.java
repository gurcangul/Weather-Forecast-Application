
public class CityWeather {
	private City cit; // CityWeather HAS-A data member of type City : HAS-A Relationship 
	private Weather weat; // Weather HAS-A data member of type Weather : HAS-A Relationship 
	private String date;  // using the access modifier private, data members are encapsulated (accessible in class scope only)
	// using the access modifier private, data members are encapsulated (accessible in class scope only)
	public CityWeather(City city, Weather weather, String date,CityWeather[][] cweather) {
		this.setCity(city);
		this.setWeather(weather);
		this.setDate(date);
	}
	public City getCity() { 
		return cit; // get methods return the data
	}
	public void setCity(City city) {
		this.cit = city;// set methods modify the data
	}
	public Weather getWeather() {
		return weat;
	}
	public void setWeather(Weather weather) {
		this.weat = weather;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void display(){
	        System.out.println("CITY-WEATHER INFORMATION");
	        System.out.println("**************************************************");
	        getCity().display();
	        getWeather().display();
	        System.out.println("Date     : " + getDate());
	} 
}