package user;
import academic.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

// import java.util.HashSet;

public class Student  extends User{

 public Date dob;
    public String role;
    final static String EMAIL_FORMAT="@stu.kdc.edu";
    static int numberOfStudents = 0;
    public String id = "S";
    public  Course[] Course;
    
    //login
    public Student(String email, String password) {
        super(email, password);
    }
    //register
    public Student(String firstName, String lastName, String address, String phoneNumber,String role) {
        super(firstName,lastName, address, phoneNumber,EMAIL_FORMAT);
        id +=(String.valueOf(++numberOfStudents));
        this.role=role;
        User.listUser.put(this.id, this);
    }

    @Override
    public String toString() {
        return super.toString()+"ID : " + id + "Student [Course=" + Arrays.toString(Course) + "]"+"\n";
    }
    
    // public static Student FindStudentById(int id){
    //     for(int i :listOfStudent.keySet()){
    //         if(i== id){
    //             return listOfStudent.get(i);
    //         }
    //     }
    //     return null;
    // }
    //     public static Student login(User std) {
    //     for (User student : User.listUser.values()) {
    //         if (std.equals(student)) {
    //             return (Student) student;
    //         }
    //     }
    //     return null;
    // }
    @Override
    public void displayUserInfo() {
        super.displayUserInfo();
        System.out.println("ID           : " + id);
        System.out.println("Role         : " + role);
        System.out.println("====================================\n");
    }

    public  Student selectStudent() {
        if (!User.listUser.isEmpty()) {
            System.out.println("List Student ");
            for (User std : User.listUser.values()) {
                System.out.println(std);
            }
            System.out.print("Enter ID : ");
            String select = input.nextLine();
            User findUser = User.listUser.get(select);
            if(findUser instanceof Student student){
                return student;
            }else {
                System.out.println("ot kert");
                return null;
            }
        } else {
            System.out.println("No Student in list");
            return null;
        }
    
}





    public static int getPeople() {
        return numberOfPerson;
    }

    public Course[] getCourse() {
        return Course;
    }
    
    




    public void setCourse(Course[] course) {
        Course = course;
    }

    
    public    void remove() {
        if (!User.listUser.isEmpty()) {
            System.out.println("List Student ");
            for (User std : User.listUser.values()) {
                System.out.println(std);
            }
            System.out.print("Enter ID : ");
            String select = input.nextLine();
             User.listUser.remove(select);
            System.out.println("Remove successfully");
        } else {
            System.out.println("No Student in list");
            
        }
    }

    public static void addStudent(){
        System.out.println("Enter Student Information");
        System.out.print("First Name : ");
        String firstName = input.nextLine();
        System.out.print("Last Name : ");
        String lastName = input.nextLine();
        System.out.print("Address : ");
        String address = input.nextLine();
        System.out.print("Phone Number : ");
        String phoneNumber = input.nextLine();
        Student student = new Student(firstName, lastName, address, phoneNumber, "year1");
        System.out.println("Student Added Successfully");
        System.out.println(student);
    }
    



    // public static void setListOfStudent(HashSet<Student> listOfStudent) {
    //     Student.listOfStudent = listOfStudent;
    // }

}
