package core;
import java.util.InputMismatchException;
import java.util.Scanner;
public class UserInput {
    static Scanner input = new Scanner(System.in);
    private String FORMAT;
    public int inputInteger() throws IllegalArgumentException{
        int number = 0;
        while (true) {
            try{
                number = input.nextInt();
                return number;
            }catch(InputMismatchException e){
                System.out.println("Input Must be a Integer 0,1,2... ");
                System.out.print("Input : ");
            }
            input.nextLine();
        }
    }

    public double inputNumber() throws IllegalArgumentException{
        double number = 0;
        while (true) {
            try{
                number = input.nextDouble();
                return number;
            }catch(InputMismatchException e){
                System.out.println("Input Must be a Number ");
                System.out.print("Input : ");
            }
            input.nextLine();
        }
    }
}
