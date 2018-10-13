package country;
import java.util.ArrayList;
import java.util.Scanner;

public class GlobalEconomyMain {
	
	private static final int REGISTER_COUNTRY = 1;
	private static final int PRINT_COUNTRIES = 2;
	private static final int PRINT_COUNTRY = 3;
	private static final int INJECT_MONEY = 4;
	private static final int PAY_DEBT = 5;
	private static final int QUIT = 6;
	private static final int EDIT_COUNTRY_INFORMATION =7;

    private ArrayList<Country> allCountries;
	private int registeredCountries;
	private Scanner input;

	private String name;
	private double population;
	private double GDP;
	private String newCountryName;
	

	public GlobalEconomyMain() {
        this.allCountries = new ArrayList<>();
		this.registeredCountries = 0;
		input = new Scanner(System.in);
	}

    public Country retrieveCountry(String countryName){
        for (Country currentCountry: this.allCountries){
            if(currentCountry.getName().equals(name)){
                return currentCountry;
            }
        }
        return null;
    }
	
	public Country createCountry() {		
		
		System.out.println("Please enter the country's name");
		name = input.nextLine();
		
		System.out.println("Please enter the country's population");
		population = input.nextDouble();
		
		System.out.println("Please enter the country's GDP");
		GDP = input.nextDouble();
		Country newCountry = new Country (name,GDP,population);
		
		return newCountry; 
	}

    public void printOneCountry() {
        String countryName = readCountryName();

        Country foundCountry = retrieveCountry(countryName);

        if (foundCountry != null ) {System.out.println(foundCountry);}
        else {System.out.println("Error: "+countryName +" is not registered.");}
    }

    public void printAllCountries() {

        for (Country currentCountry: this.allCountries){
            if(currentCountry != null){

                System.out.println(currentCountry);
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
        String countryName = input.nextLine();
        return countryName;
    }

    public void injectMoney() {
        String countryName = readCountryName();
        Country foundCountry = retrieveCountry(countryName);
        if (foundCountry== null) {System.out.println("Error: "+countryName +" is not registered.");}
        else {
            System.out.println("Enter the amount you want to inject");
            double amountInj = input.nextDouble();
            input.nextLine();
            foundCountry.injectMoney(amountInj);
            if (amountInj>0) {
                System.out.println(countryName +" new GDP is "+ foundCountry.GDP);}
        }
    }

    public void payDebt() {
        String countryName = readCountryName();
        Country foundCountry = retrieveCountry(countryName);
        if (foundCountry== null) {System.out.println("Error: "+countryName +" is not registered.");}
        else {
            System.out.println("Enter the amount you want to pay");
            double amountDebt = input.nextDouble();
            input.nextLine();
            foundCountry.payDebt(amountDebt);
            if (amountDebt>0 && amountDebt<GDP) {
                System.out.println(countryName +" new GDP is "+ foundCountry.GDP);
            }
        }
    }


    public void editInfo() {

        String countryName = readCountryName();
        Country foundCountry = retrieveCountry(countryName);
        if (foundCountry!= null) {
            System.out.println(" Please choose an option. ");
            System.out.println("1. Change a country's name.");
            System.out.println("2. Change a country's population.");

            int optionNum = input.nextInt();
            input.nextLine();

            if (optionNum == 1) {
                System.out.println("Enter the country's new name. ");
                String newCountryName = input.nextLine();
                foundCountry.setName(newCountryName);
                System.out.println("The country's new name is: "+ newCountryName);
            }

            else if (optionNum == 2 ) {
                System.out.println("Enter the country's new population. ");
                double newPopulation = input.nextDouble();
                foundCountry.setPopulation(newPopulation);
                System.out.println("The country's new population is: "+ newPopulation);

            }

            else {System.out.println("This is not a valid choice. ");}

        }
        else {System.out.println("Error: "+countryName +" is not registered.");}
    }


    public void run() {
		
		int option;
		do {
			printMenuOptions();
			System.out.print(" Type the option number: ");
			
			option = input.nextInt();
			input.nextLine(); //this skips the enter 
							  //that the user types after 
							  //typing the integer option.
			
			switch (option) {
			case REGISTER_COUNTRY:
				
				Country newCountry = createCountry();

                this.allCountries.add(newCountry);


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
				System.out.println("Thank you for using Global Economy Solutions. See you soon!");
				System.out.println();
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
		System.out.println(" 6. Quit this program. ");
		System.out.println(" 7. Edit a country's information. ");
		System.out.println();
	}

	
	public static void main(String[] args) {		
		GlobalEconomyMain program = new GlobalEconomyMain();
		program.run();		
	}
	
	
}
