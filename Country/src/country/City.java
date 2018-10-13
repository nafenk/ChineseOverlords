
public class City {

	private String name;
	private int population;
	
	public City(String name){
		
		this.name = name;
		this.population = 0;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public int getPopulation() {
		
		return this.population;
	}
	
	public void setPopulation(int population) {
		
		this.population = population;
	}
	
	public String toString() {
		
		String output = "";
		
		output += "Name: " + this.name + "\n";
		output += "Population: " + this.population + "\n";
		
		return output;
	}
}
