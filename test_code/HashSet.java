package test_code;

import java.util.Scanner;

public class HashSet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int op = 1;
        do{
            System.out.println("1 . Create");
            System.out.println("2 . Login");
            System.out.println("3 . Show");
            System.out.println("0. Exit");
            System.out.print("Choose : ");
            op = input.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Name : ");
                    String tempName = input.next();
                    System.out.print("Phone : ");
                    String tempPhone = input.next();
                    Person person = new Person(tempName, tempPhone);
                    break;
                case 2:
                    System.out.println("Phone : ");
                    String phoneNum = input.next();
                    Person login = new Person(phoneNum, tempName);
                   
                    login = Person.searchPerson(login);
                    System.err.println(login);
                    System.out.println("Good");
                    break;
                case 3: 
                    System.out.println(Person.listPerson);
                    break;
                default:
                    break;
            }
        }while(op!=0);
        System.out.println(Person.listPerson);
    }
}
