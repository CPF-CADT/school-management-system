package user;

import java.util.Scanner;

public class User  implements Person{
    static Scanner input = new Scanner(System.in);
    public static int numberOfPerson = 0;
    private int id ;
    public String lastName;
    public String firstName;
    // public Date dob; 
    public String address;
    private String email;
    private String phoneNumber;
    private String password;
    public User(){

    }
    //login
    public User( String email,String password){
        this.email = email;
        this.password = password;
    }
    //register
    public User(String firstName,String lastName,  String address, String phoneNumber, String emailFormat) {
        numberOfPerson++;
        this.id=numberOfPerson;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = generateEmail(emailFormat).toLowerCase();
        this.password = "kdc2025"; // defult password
    }
    @Override
    public String toString() {
        return "ID : " + id + "  name : " + lastName + " " + firstName + ", address : " + address
                + ", phoneNumber : " + phoneNumber +" " + "Email : "+email;
    }
    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        User t = (User) obj;
        if (this.email.hashCode() == t.hashCode()) {
            if (((User) obj).checkPassword(this.password)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void displayUserInfo() {
        System.out.println("\n====================================");
        System.out.println("              USER DETAILS      ");
        System.out.println("====================================");
        System.out.println("User ID      : " + id);
        System.out.println("First Name   : " + firstName);
        System.out.println("Last Name    : " + lastName);
        System.out.println("Address      : " + address);
        System.out.println("Phone Number : " + phoneNumber);
        System.out.println("Email        : " + email);
        if(password.equals("kdc2025")){
            System.out.println("Password (Default)  : " + password);
        }
    }

    public String getPassword(String curPassword) {
        if (curPassword.equals(this.password)) {
            return password;
        } else {
            return "Password Invalid";
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
