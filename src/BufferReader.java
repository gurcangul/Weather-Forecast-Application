import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public  class BufferReader {
	public static int numberOfCities=1;
    @SuppressWarnings("hiding")
	public static  City[] readFromCSVFile(City[] cityA) {
        	//the compiler doesn't know numbers of the cities, lets find it.
         BufferedReader bufferedReader = null;        
         try {
             bufferedReader = new BufferedReader(new FileReader("CENG211_HW1_Cities.csv"));
             String line = bufferedReader.readLine();
             while (line != null) {
                 line = bufferedReader.readLine();
                 numberOfCities++;                 
             }
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
                     
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("CENG211_HW1_Cities.csv")))) {  
		     cityA=new City[numberOfCities];
			 while (scanner.hasNextLine()) {    	  
				 String cities = scanner.nextLine();
	             String[] array = cities.split(","); 
	             
	             int plateNo = Integer.valueOf(array[0]);
	             String name= array[1];
	         	 int regionID=Integer.valueOf(array[2]);
	         	 String region = array[3];
	         	double altitude = Double.valueOf(array[4]);

	             City city=new City( plateNo,  name,new Region(regionID, region), altitude); //constructor type: int plateNo, String name, Region region, double altitude         
	             cityA[plateNo]=city;     	
	         }
	         
	     } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return cityA;
    }
    public static CityWeather [][] readFromCSVFile2(CityWeather[][] cityWeather, City[] cityA) {
    	int day=0;
    	try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("CENG211_HW1_WeeklyForecast.csv")))) {
		cityWeather=new CityWeather [numberOfCities][7];
			while (scanner.hasNextLine()) {            
				String cityweather = scanner.nextLine();
				String[] weatherArray = cityweather.split(","); 
				//PlateNo, Date,Wind,Temperature,FeelsLikeTemperature,Humidity, Precipitation,Visibility 
				int plateNo = Integer.valueOf(weatherArray[0]);
				String date= weatherArray[1];
				int wind=Integer.valueOf(weatherArray[2]);
				int temperature=Integer.valueOf(weatherArray[3]);
				int feelsLikeTemperature=Integer.valueOf(weatherArray[4]);
				int humidity=Integer.valueOf(weatherArray[5]);
				int precipitation=Integer.valueOf(weatherArray[6]);
				String visibility= weatherArray[7];       	 
           
				CityWeather cityW=new CityWeather( cityA[plateNo], new Weather(wind, temperature,feelsLikeTemperature,humidity,precipitation,visibility),date,cityWeather); //constructor type: int plateNo, String name, Region region, double altitude
				cityWeather[plateNo][day]=cityW;
				day++;
				if(day>6)
					day=0;                       
			}  
    	} catch (FileNotFoundException ex) {
    		System.out.println("File not found...");      
    	}
	return cityWeather;  
    } 
} 