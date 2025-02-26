package core;

import java.util.InputMismatchException;
import java.util.Scanner;
import exception.NumberRangeExceptionHandling;
import exception.OnlyAlphabetInString;
import exception.PhoneNumberFormartHandle;
import exception.TitleIdentifierForUser;
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
    public boolean register() throws NumberRangeExceptionHandling, InputMismatchException{
        String lastName, firstName, address, phoneNumber, role_major;
        Scanner input = new Scanner(System.in);
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
                NumberRangeExceptionHandling userType = new NumberRangeExceptionHandling(TYPE_OF_USER);
                OnlyAlphabetInString checkName = new OnlyAlphabetInString("Name must be only Contain Alphabet");
                PhoneNumberFormartHandle checkPhone =  new PhoneNumberFormartHandle();

                typeOfAccount = input.nextInt();
                userType.checkNumberInRange(typeOfAccount);
                
                System.out.print("First Name   : ");
                firstName = input.next();
                checkName.isStringConatainNonAlphabet(firstName);
                
                System.out.print("Last Name    : ");
                lastName = input.next();
                checkName.isStringConatainNonAlphabet(lastName);
                input.nextLine();
        
                System.out.print("Address      : ");
                address = input.nextLine(); 
        
                System.out.print("Phone Number : ");
                phoneNumber = input.next();
                checkPhone.IsPhoneNumberValid(phoneNumber);

                switch (typeOfAccount) {
                    case 1:
                        // Admin
                        System.out.print("Role         : ");
                        role_major = input.next();
                        TitleIdentifierForUser role = new TitleIdentifierForUser("Role of Staff Is Invalid It Cannot cotain spcial some  character ");   
                        role.titleValidate(role_major);
                        Admin adm = new Admin(firstName, lastName, address, phoneNumber, role_major);
                        adm.displayUserInfo();
                        return true;
                    case 2:
                        // Teacher
                        System.out.print("Major        : ");
                        role_major = input.next();
                        TitleIdentifierForUser majorCheck = new TitleIdentifierForUser("Major can not only cotain spcial some  character");
                        majorCheck.titleValidate(role_major);
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

    private boolean isValidEmailFormat(String input) {
        return input.endsWith("@adm.kdc.edu") ||
                input.endsWith("@tch.kdc.edu") ||
                input.endsWith("@stu.kdc.edu");
    }
}
