package utils;

import java.util.Date;
import java.util.HashSet;

public class Teacher {
    static int id = 0;
    public String lastName;
    public String firstName;
    public Date dob ; 
    public String address;
    public String email;
    public String phoneNumber;
    private String password;
    public String major;
    static HashSet<Teacher> listOfTeacher = new HashSet<Teacher>();
    
    //login
    public Teacher(String email,String password) {
        this.email = email;
        this.password = password;
    }
    //register
    public Teacher(int id, String lastName, String firstName, String address, String email, String phoneNumber, String password, String major) {
        id +=1;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.major = major;
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
}
