package country;

import java.util.Scanner;

public class GlobalEconomyMain {

  // private instance variables
  String name;
  double population;
  double GDP;
  String newCountryName;

	private Country[] countries;
	private int registeredCountries;
	IO io = new IO();

  private static final int REGISTER_COUNTRY = 1;
  private static final int PRINT_COUNTRIES = 2;
  private static final int PRINT_COUNTRY = 3;
  private static final int INJECT_MONEY = 4;
  private static final int PAY_DEBT = 5;
  private static final int QUIT = 6;
  private static final int EDIT_COUNTRY_INFORMATION =7;
	
	
	private String name;
	private double population;
	private double GDP;
  
	public GlobalEconomyMain() {
		final int MAX_COUNTRIES = 5;
		this.countries = new Country[MAX_COUNTRIES];
		this.registeredCountries = 0;
	}
	
	
	public Country retrieveCountry(String countryName) {
		for (int i = 0; i < this.countries.length; i++) {
			if(countries[i] != null && countries[i].getName().equals( countryName)) {
				return countries[i];
			}
			
		}
		
		return null;
	}
	
	public Country createCountry() {		
		
		System.out.println("Please entre the country's name");
		name = io.readString();
		
		System.out.println("Please entre the country's population");
		population =io.readDouble();
		
		System.out.println("Please entre the country's GDP");
		GDP = io.readDouble();

		Country newCountry = new Country (name,GDP,population);
		
		return newCountry; 
	}	
	
	public void run() {
		
		int option;
		do {
			printMenuOptions();
			System.out.print(" Type the option number: ");
			
			option = io.readInt(); //Using an IO class we don't need to have
								  //a scan next line in our main
								 //and make it look more clean
			
			switch (option) {
			case REGISTER_COUNTRY:
				
				Country newCountry = createCountry();
				this.countries[registeredCountries] = newCountry;
				this.registeredCountries = this.registeredCountries + 1;
				
				break;
	
			case PRINT_COUNTRIES:
				printAllCountries();
				break;
	
			case PRINT_COUNTRY:
				printOneCountry();				
				break;
	
			case INJECT_MONEY:
				injectMoney();
				break;
	
			case PAY_DEBT:
				payDebt();
				break;
	
			case QUIT:
				io.printGoodBye(); //Example on how we can use IO for printing messages.
				io.printLine();
				//System.out.println("Thank you for using Global Economy Solutions. See you soon!");
				//System.out.println();
          
				break;
				
			case EDIT_COUNTRY_INFORMATION:
				editInfo();
				break;
	
			default:
				System.out.println("Option "+option+" is not valid.");
				System.out.println();
				break;
			}
		} while (option != QUIT);
	}


  public void run() {
    int option;

    do {
      printMenuOptions();
      System.out.print(" Type the option number: ");

      option = input.nextInt();
      input.nextLine(); // eat \n character

      switch (option) {
        case REGISTER_COUNTRY:
          Country newCountry = createCountry();
          this.countries[registeredCountries] = newCountry;
          this.registeredCountries = this.registeredCountries + 1;
          break;

        case PRINT_COUNTRIES:
          printAllCountries();
          break;

        case PRINT_COUNTRY:
          printOneCountry();
          break;

        case INJECT_MONEY:
          injectMoney();
          break;

        case PAY_DEBT:
          payDebt();
          break;

        case EDIT_COUNTRY_INFORMATION:
          editInfo();
          break;

        case QUIT:
          System.out.println("Thank you for using Global Economy Solutions. See you soon!");
          System.out.println();
          break;

        default:
          System.out.println("Option "+option+" is not valid.");
          System.out.println();
          break;
      }
    } while (option != QUIT);
  }

	//This method is private because it should be used only by
	// this class since the menu is specific to this main.
	private void printMenuOptions() {
		System.out.println(" === Welcome to Global Economy === ");
		System.out.println(" Choose an option below: ");
		System.out.println(" ");
		System.out.println(" 1. Register a country. ");
		System.out.println(" 2. Print all countries. ");
		System.out.println(" 3. Print a country's information. ");
		System.out.println(" 4. Inject money to a country. ");
		System.out.println(" 5. Pay a country's debt. ");
		System.out.println(" 6. Edit a country's information. ");
		System.out.println(" 7. Quit this program. ");
		System.out.println();
	}

	public void printAllCountries() {
		for (int i=0; i<5 ; i++) {
		if( countries[i] != null ) {System.out.println(countries[i]);}
		}
	}
		
	
	public void printOneCountry() {
		String countryName = readCountryName();
		
		Country foundCountry = retrieveCountry(countryName);
	
		if (foundCountry != null ) {
		  System.out.println(foundCountry);}
		else {
		  System.out.println("Error: " + countryName + " not registered.");
		}
	}
		
	}
	
	
	/*
	 * This method only reads a String that here, will be the name
	 * of a country that you want to use 
	 * (for printing, injecting money, paying debt, etc.) 
	 */
	public String readCountryName() {
		System.out.print("Type the name of the country that you want to use: ");
		String countryName = io.readString();
		return countryName;
	}
  public Country retrieveCountry(String countryName) {
    for (Country country : this.countries) {
      if (country != null && country.getName().equals(countryName)) {
        return country;
      }
    }

    return null;
  }

	public void injectMoney() {
		String countryName = readCountryName();		
		Country foundCountry = retrieveCountry(countryName);

		if (foundCountry == null) {
		  System.out.println("Error: " + countryName + " not registered.");
		} else {
		 System.out.println("Enter the amount you want to inject");
		 double amountInj = io.readDouble();
		 foundCountry.injectMoney(amountInj);
		 if (amountInj > 0) {
		 System.out.println(countryName + " new GDP is " + foundCountry.GDP);}
		}
	}
	
	public void payDebt() {
		String countryName = readCountryName();		
		Country foundCountry = retrieveCountry(countryName);
		if (foundCountry== null) {System.out.println("Error: "+countryName +" is not registered.");}
		else {
		System.out.println("Enter the amount you want to pay");
		 double amountDebt = io.readDouble();
		 foundCountry.payDebt(amountDebt);
		 if (amountDebt>0 && amountDebt<GDP) {
		 System.out.println(countryName +" new GDP is "+ foundCountry.getGDP());
		}}}
	
	
	public void editInfo() {
	
		String countryName = readCountryName();	
		 Country foundCountry = retrieveCountry(countryName);
		 if (foundCountry!= null) {
		System.out.println(" Please choose an option. ");
		System.out.println("1. Change a country's name.");
		System.out.println("2. Change a country's population.");
		
		int optionNum = io.readInt();
		
		         if (optionNum == 1) {
			      System.out.println("Enter the country's new name. ");
			      String newCountryName = io.readString();
			      foundCountry.setName(newCountryName);
			      System.out.println("The country's new name is: "+ newCountryName);
		           } 
		
		         else if (optionNum == 2 ) {
				System.out.println("Enter the country's new population. ");
				double newPopulation = io.readDouble();
				 foundCountry.setPopulation(newPopulation);
				 System.out.println("The country's new population is: "+ newPopulation);
				
		           } 
		         
		         else {System.out.println("This is not a valid choice. ");}
		         
		 }
		 else {System.out.println("Error: "+countryName +" is not registered.");}
		 }
	
	public static void main(String[] args) {		
		GlobalEconomyMain program = new GlobalEconomyMain();
		program.run();		
	}
}
