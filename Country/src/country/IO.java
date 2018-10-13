import java.util.Scanner;

public class IO { //Having an IO class we can skip having all input.nextLine in our main and make it more clean


    Scanner input = new Scanner(System.in);

    public int readInt(){
        int number = input.nextInt();
        input.nextLine();
        return number;
    }

    public double readDouble(){
        double number = input.nextDouble();
        input.nextLine();
        return number;
    }

    public String readString(){
        String word = input.nextLine();
        return word;
    }

    public void printLine(){
        input.nextLine();
    }

    public void printGoodBye(){ //We can use similar methods for all prints
        System.out.println("Thank you for using Global Economy Solutions. See you soon!");
    }
}
