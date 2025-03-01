package core;

import java.util.InputMismatchException;
import java.util.Scanner;
import exception.StringFilterException;
import exception.NumberRangeExceptionHandling;
import user.Admin;
import user.Teacher;
import user.User;

public class Form implements Authentication{
    Scanner input = new Scanner(System.in);
    Feature f = new Feature();
    public int TYPE_OF_USER = 3;
    @Override
    public User login() {
        System.out.print("Email address : ");
        String email = input.next();
        System.out.print("Password      : ");
        String passsword = input.next();
        if (isValidEmailFormat(email)) {
            return User.login(email, passsword);
        }
        return null;
    }
    @Override
    public boolean register() throws RuntimeException{
        String lastName, firstName, address, phoneNumber, role_major;
        boolean inputStats = true;
        int typeOfAccount =0;
        do{
            System.out.println("====================================");
            System.out.println("      USER REGISTRATION FORM       ");
            System.out.println("====================================");
            System.out.println("Choose Type User :");
            System.out.println("1 . Staff");
            System.out.println("2 . Teacher");
            System.out.println("3 . Student");
            System.out.print("Choose : ");
            try{
                typeOfAccount = inputInteger();
                NumberRangeExceptionHandling userType = new NumberRangeExceptionHandling(1,TYPE_OF_USER,typeOfAccount);
                
                System.out.print("First Name   : ");
                firstName = input.next();
                StringFilterException f_name = new StringFilterException(firstName,"^[A-Za-z]+$","Alphabet Only");             
                System.out.print("Last Name    : ");

                lastName = input.next();
                StringFilterException l_name = new StringFilterException(lastName,"^[A-Za-z]+$","Alphabet Only");             
                input.nextLine();
        
                System.out.print("Address      : ");
                address = input.nextLine(); 
        
                System.out.print("Phone Number : ");
                phoneNumber = input.next();
                StringFilterException phone = new StringFilterException(phoneNumber,"^0[1-9]\\d{6,12}$","Invalid Phone Numebr Format");

                switch (typeOfAccount) {
                    case 1:
                        // Admin
                        System.out.print("Role         : ");
                        role_major = input.next();
                        StringFilterException role = new StringFilterException(role_major, "^[A-Za-z]+([\\s-&][A-Za-z]+)*$", "Spcial character is not Allowed");
                        Admin adm = new Admin(firstName, lastName, address, phoneNumber, role_major);
                        adm.displayUserInfo();
                        return true;
                    case 2:
                        // Teacher
                        System.out.print("Major        : ");
                        role_major = input.next();

                        StringFilterException major = new StringFilterException(role_major, "^[A-Za-z]+([\\\\s-&][A-Za-z]+)*$", "Spcial character is not Allowed");
                        Teacher teach = new Teacher(firstName, lastName, address, phoneNumber, role_major);
                        teach.displayUserInfo();
                        return true;
                    case 3:
                        // Student
                        System.out.println("Student registered successfully!");
                        return true;
        
                    default:
                        System.out.println("Invalid user type! Registration failed.");
                        return false;
                }
        
            }catch(RuntimeException registerCheck){
                f.clearScreen();
                System.out.println(registerCheck.getMessage());
                inputStats = false;
            }
        }while (!inputStats) ;
        return false;
    }
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

    private boolean isValidEmailFormat(String input) {
        return input.endsWith("@adm.kdc.edu") ||
                input.endsWith("@tch.kdc.edu") ||
                input.endsWith("@stu.kdc.edu");
    }
}
