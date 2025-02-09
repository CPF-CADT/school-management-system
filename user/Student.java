package user;

import java.util.Date;

public class Student {
    static int id =0;
    public String lastName;
    public String firstName;
    private Date dob;
    private String address;
    public String email;
    public String phoneNumber;
    private String password;
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
}
