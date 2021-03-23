import java.util.Scanner;
public class WeatherForecastAppManeger {
	@SuppressWarnings("resource")
	public void startProgram(){
		 City[] cityA = null;
		 cityA=BufferReader.readFromCSVFile(cityA);
	
		 CityWeather[][] cityWeather = null;
		 cityWeather=BufferReader.readFromCSVFile2(cityWeather,cityA);
		
	     Scanner scanner = new Scanner(System.in);
	     System.out.println("Welcome to the Weather Forecast Application”");
	     System.out.println("Please choose a query number to proceed ('0' to exit)");  
	     System.out.println("1. Get  Name of the city (or cities) with the lowest feels-like temperature in the next week");
	     System.out.println("2. Get Name of top 3 cities with the highest temperature variation in the next week");
	     System.out.println("3. Get Name of the region with the highest average humidity in the next week");
	     System.out.println("4. Get Mean temperature in the highest and lowest altitude cities" );
	     System.out.println("5. Get Name of the cities that are rainy in the next 2 days (tomorrow and the day after tomorrow ");
	     System.out.println("6. Get Date (or dates) suitable for flying drones for a given city in the next week");
	     boolean exit = false;
	     while(!exit) {
			System.out.print("Enter the query number here: ");
			int key=scanner.nextInt();
	    	switch (key) {
	    		 	case 1:
	    			 WeatherQuery.lowestFeel(cityWeather);
	    		 	    System.out.println( "  ");
	    		 		break;    		 	
	    		 	case 2:
	   		 	     WeatherQuery.highestTemp(cityWeather);
	    		 	    System.out.println();
	    		 		break;
	    		 	case 3:
	      		 	     WeatherQuery.highestAverageHum(cityWeather);
	    		 		break;
	    		 	case 4:
	     		 	     WeatherQuery.tempOfHighLowAltitude(cityWeather);
	    		 		break;
	    		 	case 5:
	    		 	     WeatherQuery.precipitation(cityWeather);
	    				 System.out.println( "  ");
	    		 		break;
	    		 	case 6:
	    				System.out.print("Enter a city name to view flightworthy days: ");
	    				String cityFlying=scanner.next();
	   		 	     WeatherQuery.suitableForFlying(cityWeather,cityFlying);
					 System.out.println( "  ");
	    		 			break;
	    		 	case 0:
	    		 		 exit = true;
	    		 			break;
	    		 	default:
	    		 		throw new IllegalArgumentException("Unexpected value: " + scanner);
	    		 }
	    } 
	}	 
}