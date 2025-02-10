package user;

import java.util.Date;
import java.util.HashSet;

public class Teacher {
    public static int numberOfTeacher = 0;
    public int id = 0;
    public String lastName;
    public String firstName;
    // public Date dob ; 
    public String address;
    private String email;
    private String phoneNumber;
    private String password;
    public String major;
    public static HashSet<Teacher> listOfTeacher = new HashSet<Teacher>();
    public Teacher(){

    }
    //login
    public Teacher(String email,String password) {
        this.email = email;
        this.password = password;
    }
    //test constructor
    public Teacher(String email,String password,String firstName) {
        numberOfTeacher+=1;
        this.id =numberOfTeacher;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        listOfTeacher.add(this);
    }
    //register
    public Teacher(String lastName, String firstName, String address, String email, String phoneNumber, String password, String major) {
        numberOfTeacher+=1;
        this.id =numberOfTeacher;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Teacher name : " + lastName + " " + firstName + ", address=" + address
                + ", phoneNumber=" + phoneNumber + ", major = " + major ;
    }
    public static Teacher FindTeacher(Teacher t){
        for(Teacher teacher :listOfTeacher){
            if(t.equals(teacher)){
                return teacher;
            }
        }
        return null;
    }
    @Override
    public int hashCode() {
        return email.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        Teacher t = (Teacher) obj;
        if(this.email.hashCode() == t.hashCode()){
            if(this.password.equals(t.password)){
                return true;
            }
        }
        return false;
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
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setEmail(String email,String conPassword) {
        if (conPassword.equals(this.password)) {
            this.email = email;
        } else {
            System.out.println("Password Invalid");
        }
    }
    public void setPhoneNumber(String phoneNumber,String conPassword) {
        if (conPassword.equals(this.password)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Password Invalid");
        }
    }
    
}
