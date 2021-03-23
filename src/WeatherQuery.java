public class WeatherQuery {
	public static void lowestFeel(CityWeather[][] cityWeather ) {// Query 1 
		 int feels_like=cityWeather[1][0].getWeather().getFeels_like();
		 for(int i=1;i<=BufferReader.numberOfCities-1;i++) {
			 for(int j=0;j<=6;j++) {
				 if(feels_like>cityWeather[i][j].getWeather().getFeels_like()) {
					 feels_like=cityWeather[i][j].getWeather().getFeels_like();
				 }
			 }			 
		 } 
		 for(int i=1;i<=BufferReader.numberOfCities-1;i++) {
			 	for(int j=0;j<=6;j++) {
			 		if(feels_like==cityWeather[i][j].getWeather().getFeels_like()) {
					 System.out.print( cityWeather[i][j].getCity().getName() +" ");
			 		}
			 	}			 
		 }
	}
	public static void highestTemp(CityWeather[][] cityWeather ) { // Query 2
		double[] tempArray=new double[7];
		double[][] plateDeviationArray=new double[82][2];

		for(int i=1;i<=BufferReader.numberOfCities-1;i++) {
			 for(int j=0;j<=6;j++) {
				 tempArray[j]=cityWeather[i][j].getWeather().getTemperature();
			 }	 
			 plateDeviationArray[i][0]= i;
			 plateDeviationArray[i][1]= calculateSD(tempArray,cityWeather);
		}	arraysSort(cityWeather,plateDeviationArray);
	}
	public static void arraysSort(CityWeather[][] cityWeather2,double[][] plateDeviationArray) { // Sorting the two dimensional array [PlateNumber][Standard Deviation]
        for (int i = 1; i <= BufferReader.numberOfCities-1; i++) {   
 
            double num = plateDeviationArray[i][1]; 
            int temp = i; 
            double plate = plateDeviationArray[i][0];
            for (int j = i+1; j < plateDeviationArray.length ; j++) { 
                if(plateDeviationArray[j][1]<num){ 
                	num = plateDeviationArray[j][1]; 
                    temp = j; 
                    plate = plateDeviationArray[j][0];
                }
            }
            if(temp != i){ 
            	plateDeviationArray[temp][1] = plateDeviationArray[i][1];
            	plateDeviationArray[i][1] = num;
             
            	plateDeviationArray[temp][0] = plateDeviationArray[i][0];
            	plateDeviationArray[i][0] = plate;
            }
        }
        int b;
        int count=0;
        for(int k=BufferReader.numberOfCities-1;k>=1;k--) { 	
        	if(plateDeviationArray[k][1]>plateDeviationArray[k-1][1]) {
           	 	b=(int) plateDeviationArray[k][0];
            	System.out.print(cityWeather2[b][0].getCity().getName()+ " ");
            	count++;
        	}
            else if(plateDeviationArray[k][1]==plateDeviationArray[k-1][1]) {
            	 b=(int) plateDeviationArray[k][0];
            	System.out.print(cityWeather2[b][0].getCity().getName()+ " ");
            }
        	if(count==3)
        	break;
        }    
	}
	public static double calculateSD(double[] numArray, CityWeather[][] cityWeather){ // Calculate Standard Deviation
        double sum = 0.0; 
        double standardDeviation = 0.0;
         double length = numArray.length;
        for(double num : numArray) {
            sum += num;
        }
        double mean = sum/length;
        for(double num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        return Math.sqrt(standardDeviation/(length-1));
    }
	public static void highestAverageHum(CityWeather[][] cityWeather ) { // Query 3
		 int AverageHum=0;
		 int highestAverageHum=0;
		 int totalHumidity=0;
		 int regId=1;
		 int count=0;
		 for(int i=1;i<=7;i++) {
			 for(int j=1;j<=BufferReader.numberOfCities-1;j++) {
				 if(i==cityWeather[j][0].getCity().getRegion().getId()) {
					 count++;
					 for(int k=0;k<=6;k++) {
						 totalHumidity+=cityWeather[j][k].getWeather().getHumidity();							 					 
					 }
				 }	
			 }
			 AverageHum=(totalHumidity/count);
			 count=0;
			 totalHumidity=0;
			 if(AverageHum>highestAverageHum) {
				 highestAverageHum=AverageHum;
				 regId=i;
			 }
		 }
		 for(int i=1;i<=BufferReader.numberOfCities-1;i++) {
			 if(regId==cityWeather[i][0].getCity().getRegion().getId()) {
				 System.out.println(cityWeather[i][0].getCity().getRegion().getName());
				 break;
				 }
		 }
	}
	public static void tempOfHighLowAltitude(CityWeather[][] cityWeather ) {// Query 4
		double highestAltitude=0;
		double lowestAltitude=5000;
		int iTemp=0;
		int jTemp=0;
		 for(int i=1;i<=BufferReader.numberOfCities-1;i++) {
				 if(highestAltitude<cityWeather[i][0].getCity().getAltitude()) {
					 highestAltitude=cityWeather[i][0].getCity().getAltitude();
				 iTemp=i;
				 }
				 if(lowestAltitude>=cityWeather[i][0].getCity().getAltitude()) { 
					 lowestAltitude=cityWeather[i][0].getCity().getAltitude();
					 jTemp=i;	
				 } 
		 }
		 double highestAltitudeTemp=0;
		 double lowestAltitudeTemp=0;
		 for(int j=0;j<=6;j++) {
				 highestAltitudeTemp+=cityWeather[iTemp][j].getWeather().getTemperature(); 	
				 lowestAltitudeTemp+=cityWeather[jTemp][j].getWeather().getTemperature();
		 } 	 
		 highestAltitudeTemp/=7.0;
		 lowestAltitudeTemp/=7.0;
		 System.out.println(highestAltitudeTemp + " " + lowestAltitudeTemp);
	}
	public static void precipitation(CityWeather[][] cityWeather ) {// Query 5 
		 for(int i=1;i<=BufferReader.numberOfCities-1;i++) {
			 if((cityWeather[i][1].getWeather().getPrecipitation()>=80) && (cityWeather[i][2].getWeather().getPrecipitation()>=80)) {
				 System.out.print(cityWeather[i][0].getCity().getName()+"  ");
			 }
		 }
	}
	public static void suitableForFlying (CityWeather[][] cityWeather, String city  ) {// Query 6 
		String str = city;
		String cap = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
		int cityId=1;
		boolean found=false;
		int count=0;
		 for(int i=1;i<=BufferReader.numberOfCities-1;i++) {				 
			 if(cap.equals(cityWeather[i][0].getCity().getName())) {
				 cityId=i;
				 found=true;
			 }
			  
		 }
		 for(int j=0;j<=6;j++) {
			 if(found==false){
				 System.out.print("Name of the city that you entered not found in the system! ");
				 count++;
				 break;
			 }
			 else if((cityWeather[cityId][j].getWeather().getVisibility().equals("medium")||(cityWeather[cityId][j].getWeather().getVisibility().equals("high")) ) & cityWeather[cityId][j].getWeather().getWind()<40 ) {
				 System.out.print(cityWeather[cityId][j].getDate()+ "  ");
				 count++;
			 }
		 }
		 if(count==0 ) {
		 System.out.print("The city that you entered is not suitable for flying during this week.");
		 }
	}
}