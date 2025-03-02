package progress;

import java.util.Scanner;

import academic.Course;
import academic.CourseInstance;
import core.AcademicControl;
import user.Admin;
import user.Student;
import user.Teacher;
import user.User;

public class studentCourse {
    public static void main(String[] args) {
        Teacher t2 = new Teacher(
                    "Jak",
                    "Jony",
                    "456 Elm St, CA",
                    "9876543210",
                    "Mathematics");
                    
                    
        Student s1=new Student("kon","khmer","82","123","year1");
        Scanner sc = new Scanner(System.in);
        AcademicControl ac = new AcademicControl();
        Course c = new Course("C++ And OOP", "CPP", 60.0f, "Basic Level");
        Course c2 = new Course("JAVA GUI", "JAV", 60.0f, "Basic Level");

        User admin = new Admin("adminUser", "adminPass"); // Assuming Admin has a constructor (username, password)
        CourseInstance clas = new CourseInstance(c, t2, 2022, 2, 1);
        CourseInstance clas2 = new CourseInstance(c2, t2, 2022, 3, 1);

        // clas.studentEnrollment(admin);
        // clas2.studentEnrollment(admin);
        // CourseInstance cs = s1.selectCourseStudy();
        
        // CourseInstance cs = t2.selectCourseTeaching();
        // System.out.println(cs.course);


        
    }
}
