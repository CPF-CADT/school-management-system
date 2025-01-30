package utils;

import java.util.Date;

public class Teacher {
    static int id;
    public String lastName;
    public String firstName;
    private Date dob ; 
    private String address;
    public String email;
    public String phoneNumber;
    private String password;
    public String major;
    public Teacher(String lastName, String firstName, String phoneNumber) {
        id +=1;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }
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
}
