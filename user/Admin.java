package user;

import java.util.Date;
import java.util.HashSet;

public class Admin {
    static int numberOfAdmins = 0;
    public int id;
    public String lastName;
    public String firstName;
    // public Date dob; 
    public String address;
    private String email;
    private String phoneNumber;
    private String password;
    public String role;
    static HashSet<Admin> listOfAdmins = new HashSet<Admin>();
    Admin(){
        
    }
    public Admin(String firstName, String lastName, String address, String email, String phoneNumber, String password, String role) {
        numberOfAdmins++;
        this.id = numberOfAdmins;
        this.firstName = firstName;
        this.lastName = lastName;
        // this.dob = dob;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        listOfAdmins.add(this);
    }
    public Admin(String email,String password) {
        this.email = email;
        this.password = password;
    }
    @Override
    public String toString() {
        return "Admin name : " + lastName + " " + firstName  + ", address=" + address
                + ", phoneNumber=" + phoneNumber + ", Role = " + role ;
    }
    public static Admin FindAdmins(Admin t){
        for(Admin adm :listOfAdmins){
            if(t.equals(adm)){
                return adm;
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
        Admin t = (Admin) obj;
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
