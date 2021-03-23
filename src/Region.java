
public class Region {
	private int id; // using the access modifier private, data members are encapsulated (accessible in class scope only)
	private String name; 
	private City[] City;
	
	
	public Region() { // non-parameterized constructor	
		this.setId(0);
		this.setName("Unknown");
		this.setCity(null); // City refers to the new object array defined here
	} 
	public Region(int id, String name) { //parameterized constructor
		super();
		this.setId(id); 
		this.setName(name); 
	}  
	public int getId() {//methods, setter-getter	
		return id; // get methods return the data
	}
	public void setId(int id) {
		this.id = id;  // set methods modify the data 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City[] getCity() {
		return City;
	}
	public void setCity(City[] city) {
		City = city;
	}
	public void display(){
		 System.out.println("ID of the Region              : " + getId());
	     System.out.println("Name of the Region              : " + getName());
	}



}
