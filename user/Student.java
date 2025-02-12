package user;
import academic.Course;
import java.util.Date;
import java.util.HashSet;

public class Student  extends User{

    static Date dob;
    

    public  Course[] Course;
    static HashSet<Student> listOfStudent = new HashSet<Student>();
    public Student() {
    }







    public static Student FindStudent(Student std){
        for(Student student :listOfStudent){
            if(std.equals(student)){
                return student;
            }
        }
        return null;
    }
    



    public String getAddress() {
        return address;
    }



    public static HashSet<Student> getListOfStudent() {
        return listOfStudent;
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


    public static void setListOfStudent(HashSet<Student> listOfStudent) {
        Student.listOfStudent = listOfStudent;
    }

}
