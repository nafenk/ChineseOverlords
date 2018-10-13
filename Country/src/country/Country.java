package country;

public class Country {

  // private instance variables
  String name;
  double GDP;
  double population;
  double amountInj;
  double amountDebt;


  private static final int CLASS_CONS1 = 1000;
  private static final int CLASS_CONS2 = 10000;
  final String END_OF_LINE = System.lineSeparator();


  Country (String name, double GDP, double population){
    this.name=name;
    this.GDP=GDP;
    this.population=population;
  }


  protected String getName() {
    return name;
  }


  protected double getGDP() {
    return GDP;
  }


  protected double getPopulation() {
    return population;
  }


  protected void setName(String newname) {
    this.name = newname;
  }


  protected void setPopulation(double newPopulation) {
    this.population = newPopulation;
  }


  protected double getGdpPerCapita() {
    return (GDP / population);
  }


  protected String getClassification() {
    String classification="";

    if (getGdpPerCapita() >= CLASS_CONS2) {
      classification = "Developed country";
    } else if ((getGdpPerCapita() >= CLASS_CONS1) && (CLASS_CONS2 > getGdpPerCapita())) {
      classification="Economy in transition";
    } else if (getGdpPerCapita() < CLASS_CONS1) {
      classification="Developing country";
    }

    return classification;
  }


  protected void injectMoney(double amountInj) {
    if (amountInj > 0) {
      GDP = amountInj + GDP;
    } else {
      System.out.println("Error when injecting money in " + this.name + ". Amount has to be higher than zero");
    }
  }


  protected void payDebt(double amountDebt ) {
    if (amountDebt < 0 || amountDebt > GDP) {
      System.out.println("Error when paying " + this.name + "'s debt. Amount has to be higher than zero");
    } else if (amountDebt > 0) {
      GDP -= amountDebt;
    }
  }


  @Override
  public String toString() {
    String print = this.name + " : ( " + getClassification() + " )" + END_OF_LINE;
    print += "Population : " + getPopulation() + END_OF_LINE;
    print += "GDP : " + getGDP() + END_OF_LINE;
    print += getGdpPerCapita() + "GDP per capita ." + END_OF_LINE;
    print += "    ";

    return print;
  }
}


