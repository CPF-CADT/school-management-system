package utils;

import java.util.Date;

public class Teacher {
    static int numberOfTeacher ;
    private int id;
    private String lastName;
    private String firstName;
    private Date dob ; //
    private String address;
    private String email;
    private String phoneNumber;
    private String password;
    private String major;
    
    public Teacher() {
        numberOfTeacher++;
        this.id = numberOfTeacher;
    }
    public Teacher(String lastName, String firstName, String phoneNumber) {
        numberOfTeacher++;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.id = numberOfTeacher;
    }
    public Teacher(int id, String lastName, String firstName, String address, String email, String phoneNumber, String password, String major) {
        numberOfTeacher++;
        this.id = numberOfTeacher;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.major = major;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
}
