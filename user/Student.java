package user;
import academic.Course;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
// import java.util.HashSet;

public class Student  extends User{

    public Date dob;
    // public String role;
    final static String EMAIL_FORMAT="@std.kdc.edu";

    public  Course[] Course;
    static HashMap<Integer,Student> listOfStudent = new HashMap<Integer,Student>();
    public Student() {
    }
    //login
    public Student(String email, String password) {
        super(email, password);
    }
    //register
    public Student(String firstName, String lastName, String address, String phoneNumber) {
        super(firstName, lastName, address,phoneNumber, EMAIL_FORMAT);
        listOfStudent.put(id,this);
    }







    @Override
    public String toString() {
        return super.toString()+"Student [Course=" + Arrays.toString(Course) + "]";
    }
        // public static Student FindStudentById(int id){
    //     for(int i :listOfStudent.keySet()){
    //         if(i== id){
    //             return listOfStudent.get(i);
    //         }
    //     }
    //     return null;
    // }
        public static Student login(Student std) {
        for (Student student : listOfStudent.values()) {
            if (std.equals(student)) {
                return student;
            }
        }
        return null;
    }

    public static Student selectStudent() {
        if (Student.listOfStudent.isEmpty()) {
            System.out.println("List Student ");
            for (Student std : listOfStudent.values()) {
                System.out.println(std);
            }
            System.out.print("Enter ID : ");
            int select = input.nextInt();
            return listOfStudent.get(select);
        } else {
            System.out.println("No Student in list");
            return null;
        }
    
}



    public String getAddress() {
        return address;
    }






    public int getId() {
        return id;
    }


    public static int getPeople() {
        return numberOfPerson;
    }
    public static Date getDob() {
        return dob;
    }
    public Course[] getCourse() {
        return Course;
    }
    
    




    public void setCourse(Course[] course) {
        Course = course;
    }


    // public static void setListOfStudent(HashSet<Student> listOfStudent) {
    //     Student.listOfStudent = listOfStudent;
    // }

}
