package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import exception.StringFilterException;
import exception.NumberRangeExceptionHandling;
import user.Admin;
import user.Student;
import user.Teacher;
import user.User;

public class Form implements Authentication{
    static Scanner input = new Scanner(System.in);
    Feature f = new Feature();
    public int TYPE_OF_USER = 3;
    @Override
    public User login() {

        System.out.print("Email address : ");
        String email = input.next();
        System.out.print("Password      : ");
        String passsword = input.next();

        // //TEST LOGIN
        // String email = "charlie.williams@tch.kdc.edu";
        // String passsword = "password789";

        
        User user = null;   
        if (loadData(email,passsword)!=null) {
            System.out.println("Welcome to Khode");
            if(email.endsWith("@tch.kdc.edu")) {
                user = new Teacher(email, passsword);
            }else if(email.endsWith("@stu.kdc.edu")){
                user = new Student(email, passsword);
            }else{
                user = new Admin(email, passsword);
            }
            return User.login(user);
        }
        // System.out.println("Fail");
        return null;
    }
    @SuppressWarnings("unused")
    @Override
    public boolean register(){
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
                        // Admin Dont Have Database
                        System.out.print("Role         : ");
                        role_major = input.next();
                        StringFilterException role = new StringFilterException(role_major, "^[A-Za-z]+([\\s-&][A-Za-z]+)*$", "Spcial character is not Allowed");
                        Admin adm = new Admin(firstName, lastName, address, phoneNumber, role_major);
                        break;
                    case 2:
                        // Teacher
                        System.out.print("Major        : ");
                        role_major = input.next();
                        StringFilterException major = new StringFilterException(role_major, "^[A-Za-z]+([ -&][A-Za-z]+)*$", "Spcial character is not Allowed");
                        Teacher teach = new Teacher(firstName, lastName, address, phoneNumber, role_major);
                        break;
                    case 3:
                        // Student
                        Student stu = new Student(firstName, lastName, address, phoneNumber);
                        System.out.println("Student registered successfully!");
                        break;
                    default:
                        System.out.println("Invalid user type! Registration failed.");
                        return false;
                }
                return true;
            }catch(IllegalArgumentException registerCheck){
                f.clearScreen();
                System.out.println(registerCheck.getMessage());
                inputStats = false;
            }
        }while (!inputStats) ;
        return false;
    }
    public static int inputInteger(){
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

    public static double inputNumber() throws IllegalArgumentException{
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

    @SuppressWarnings("unused")
    private static boolean isValidEmailFormat(String input) {
        return input.endsWith("@adm.kdc.edu") ||
                input.endsWith("@tch.kdc.edu") ||
                input.endsWith("@stu.kdc.edu");
    }
    public User loadData(String email,String password){
        String query;
        if (email.endsWith("@stu.kdc.edu")){
            query = "SELECT u.id,u.first_name,u.last_name,u.dob,u.address,u.email,u.phone_number,u.password,s.status FROM User AS u JOIN Students AS s ON u.id = s.user_id WHERE email = '"+email+"' AND password = '"+password+"';";
        }else if(email.endsWith("@tch.kdc.edu")){
            query = "SELECT u.id, u.first_name, u.last_name, u.dob, u.address, u.email, u.phone_number, u.password, t.role_major,t.status FROM User AS u JOIN Teachers AS t ON u.id = t.user_id WHERE u.email = '"+email+"' AND u.password = '"+password+"';";
        }else {
            query = "SELECT u.id,u.first_name,u.last_name,u.dob,u.address,u.email,u.phone_number,u.password,role_major,t. FROM User AS u JOIN Admin AS s ON u.id = s.user_id "+ "WHERE email = '" + email + "' AND password = '" + password + "';"; //NOT READY 
        }
        ResultSet result = MySQLConnection.executeQuery(query);
        if(result!=null){
            try{
                if (result.next()) { 
                    String userId = result.getString("id"); 
                    String userEmail = result.getString("email");
                    String phone = result.getString("phone_number"); 
                    String userPassword = result.getString("password");
                    String firstName = result.getString("first_name");
                    String lastName = result.getString("last_name");
                    String address = result.getString("address");
                    boolean status = result.getBoolean("status");

                    if (email.endsWith("@stu.kdc.edu")){
                        Student user = new Student(userId, firstName, lastName, address, phone, userEmail, userPassword,status);
                        return user;
                    }else if(email.endsWith("@tch.kdc.edu")){
                        String major = result.getString("role_major");
                        Teacher user = new Teacher( userId, firstName,  lastName,  address,  phone, email, password, major,status);
                        return user;
                    }
                } else {
                    System.out.println("Invalid email or password.");
                    return null;
                }
            }catch(SQLException s){
                
            }
        }else{
            System.out.println("Fail");
        }
        return null;
    }
    
}
