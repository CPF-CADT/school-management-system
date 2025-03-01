package user;

import java.util.HashMap;
import java.util.Scanner;

import exception.CastToUserHandleException;

public  abstract class User  implements Person{
    static Scanner input = new Scanner(System.in);
    static int numberOfUser = 0;
    private int id ;
    public String lastName;
    public String firstName;

    // protected Date dob; 
    protected String address;
    
    private String email;
    private String phoneNumber;
    private String password;
    public static HashMap<String,User> listUser = new HashMap<String,User>();
    //login
    public User( String email,String password){
        this.email = email;
        this.password = password;
    }
    //register
    public User(String firstName,String lastName,  String address, String phoneNumber, String emailFormat) {
        id = ++numberOfUser;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = generateEmail(emailFormat).toLowerCase();
        this.password = "kdc2025"; // defult password
    }
    @Override
    public String toString() {
        String userInfo = "Name        : " + lastName + " " + firstName + "\n"
                        + "Address     : " + address + "\n"
                        + "Phone Number: " + phoneNumber + "\n"
                        + "Email       : " + email + "\n";

        if (password.equals("kdc2025")) {
            userInfo += "Password (Default): " + password + "\n";
        }
        return userInfo;
    }
    
    // login
    public static User login(User log) {
        for (User user : User.listUser.values()) {
            if (log.equals(user)){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) throws ClassCastException{
        try{
            CastToUserHandleException c = new CastToUserHandleException(obj);
            User log = (User) obj;
            if (this.email.equals(log.getEmail())) {
                if ((log.checkPassword(this.password))) {
                    return true;
                }
            }
        }catch(ClassCastException c){
            System.out.println(c.getMessage());
        }
        return false;
    }
    @Override
    public void displayUserInfo() {
        System.out.println("\n====================================");
        System.out.println("              USER DETAILS      ");
        System.out.println("====================================");
        System.out.println("First Name   : " + firstName);
        System.out.println("Last Name    : " + lastName);
        System.out.println("Address      : " + address);
        System.out.println("Phone Number : " + phoneNumber);
        System.out.println("Email        : " + email);
        if(password.equals("kdc2025")){
            System.out.println("Password (Default)  : " + password);
        }
    }

    public void setPassword(String newPassword, String curPassword) {
        if (curPassword.equals(this.password)) {
            this.password = newPassword;
        } else {
            System.out.println("Password Invalid");
        }
    }
    public boolean checkPassword(String password){
        if(this.password.equals(password)){
            return true;
        }else{
            return false;
        }

    }   
    public String getEmail() {
        return email;
    }

    public int getID(){
        return id;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email, String conPassword) {
        if (conPassword.equals(this.password)) {
            this.email = email;
        } else {
            System.out.println("Password Invalid");
        }
    }

    public void setPhoneNumber(String phoneNumber, String conPassword) {
        if (conPassword.equals(this.password)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Password Invalid");
        }
    }
    
    private   String generateEmail(String format){
        return firstName+lastName+String.valueOf(id)+ format;
    }
}
