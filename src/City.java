
public class City {
		private int plateNo;   
		private String name;
		private Region reg; // City HAS-A data member of type Region : HAS-A Relationship 
		private double altitude;
		// using the access modifier private, data members are encapsulated (accessible in class scope only)
		
		public City() { // non-parameterized constructor		
			this.setPlateNo(0);
			this.setName("Unknown");
			this.setAltitude(0);
	        this.reg = new Region(); // Reg refers to the new Region object defined here
	    }		 
		public City(int plateNo, String name,Region reg, double altitude) { // parameterized constructor
	
			this.setPlateNo(plateNo);
			this.setName(name);
			this.setRegion(reg);
			this.setAltitude(altitude);
		}			
		// methods are public (accessible everywhere), setter-getter	 
		public int getPlateNo() {// get methods return the data
			return plateNo;
		}
		public void setPlateNo(int plateNo) { // set methods modify the data 
			this.plateNo = plateNo;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}	
		public Region getRegion() {
			return reg;
		}
		public void setRegion(Region region) {
			this.reg = region;
		}
		public double getAltitude() {
			return altitude;
		}
		public void setAltitude(double altitude) {
			if(altitude>5000||altitude<0) // argument validation (input validation)
				altitude=0; 
			this.altitude = altitude;
		}
		public void display(){
		        System.out.println("Plate No:     : " + getPlateNo());
		        System.out.println("City:    : " + getName());
		        System.out.println("Altitude     : " + getAltitude());
		        getRegion().display();
		}	 
}
