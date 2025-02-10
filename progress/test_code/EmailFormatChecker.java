package progress.test_code;
import java.util.Scanner;

public class EmailFormatChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an email address to check: ");
        String input = scanner.nextLine().trim();
        if (isValidEmailFormat(input)) {
            System.out.println(input + " is a valid email address.");
            System.out.println("Type Of Email ");
            switch (typeOfEmail(input)) {
                case 1:
                    System.out.println("This Admin Account");
                    break;
                case 2:
                    System.out.println("This Teacher Account");
                    break;
                case 3:
                    System.out.println("This Student Account");
                    break;
                default:
                    break;
            }
        } else if(isValidPhoneFormat(input)) {
            System.out.println(input + " is a valid phone number .");
        }else {
            System.out.println(input + " is not a valid email address.");
        }
        scanner.close();
    }
    static int typeOfEmail(String input){
        if(input.contains("@adm")) return 1;
        if(input.contains("@tch")) return 2;
        if(input.contains("@stu")) return 3;
        return -1;
    }
    static boolean isValidEmailFormat(String input) {
        return input.endsWith("@adm.kdc.edu") || 
               input.endsWith("@tch.kdc.edu") || 
               input.endsWith("@stu.kdc.edu");
    }
    static boolean isValidPhoneFormat(String input) {
       for(int i=0;i<input.length();i++){
            if(input.charAt(i) > '9' || input.charAt(i)<'0'){
                return false;
            }
       }
       return true;
    }
}