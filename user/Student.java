package user;

import java.util.Date;
import java.util.HashSet;

public class Student {
    static int id =0;
    public String lastName;
    public String firstName;
    static Date dob;
    private String address;
    static String email;
    static String phoneNumber;
    private String password;
    static HashSet<Student> listOfStudent = new HashSet<Student>();

    public Student(String phoneNumber, String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    public Student(int id, String lastName, String firstName, String address, String email, String phoneNumber,
    String password) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
    public Student() {
        
    }
    public String toString() {
        return "Student name : " + lastName + " " + firstName + ", address=" + address
                + ", phoneNumber=" + phoneNumber  ;
    }

    public static Student FindStudent(Student std){
        for(Student student :listOfStudent){
            if(std.equals(student)){
                return student;
            }
        }
        return null;
    }
    
}
