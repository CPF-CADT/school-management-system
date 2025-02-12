package user;
import java.util.Date;
import java.util.HashSet;

public class Student {
    public  int id;
    static int people=0;
    public String lastName;
    public String firstName;
    static Date dob;
    private String address;
    private  String email;
    static String phoneNumber;
    private String password;
    public  String Course[];
    static HashSet<Student> listOfStudent = new HashSet<Student>();
    public Student() {
    }

    public Student(String email, String password) {
        this.email = email;
        this.password = password;

        
    }


    public Student(String lastName, String firstName, String address, String email, String phoneNumber,
    String password) {
        people+=1;
        this.id=people;
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

    public String getAddress() {
        return address;
    }

    

    public String getPhoneNumber() {
        return phoneNumber;
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
    public String getEmail(){
        return  email;
    }

    public static HashSet<Student> getListOfStudent() {
        return listOfStudent;
    }


    public int getId() {
        return id;
    }


    public static int getPeople() {
        return people;
    }
    public static Date getDob() {
        return dob;
    }
    public String[] getCourse() {
        return Course;
    }
    
    

    /**
     * @param address the address to set
     */
    public void setAddress(String currpassword,String curraddress) {
        if(currpassword.equals(this.password)){

            this.address = curraddress;
        } else {
            System.out.println("Password Invalid");
        }
    }

    public static void setPhoneNumber(String phoneNumber) {
        Student.phoneNumber = phoneNumber;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setCourse(String[] course) {
        Course = course;
    }


    public static void setListOfStudent(HashSet<Student> listOfStudent) {
        Student.listOfStudent = listOfStudent;
    }

}
