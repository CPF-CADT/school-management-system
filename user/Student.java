package user;

import java.util.Date;
import java.util.HashSet;

public class Student {
    static int id =0;
    public String lastName;
    public String firstName;
    static Date dob;
    private String address;
    public  String email;
    static String phoneNumber;
    private String password;
    static HashSet<Student> listOfStudent = new HashSet<Student>();

    public Student(String email, String password) {
        this.email = email;
        this.password = password;   
    }

    public Student(){
        
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
    @Override
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
    

    @Override
    public  int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public   boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    public static int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public static Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public static HashSet<Student> getListOfStudent() {
        return listOfStudent;
    }
    
    
}
