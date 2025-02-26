package core;
import user.*;

import java.util.Scanner;

import academic.*;
public class AcademicControl {
    Scanner input = new Scanner(System.in);
    public boolean createClass(){
        System.out.print("Enter The Clss Information");
        System.out.print("Year     : ");
        int year = input.nextInt();
        System.out.print("Term     : ");
        int term = input.nextInt();
        System.out.print("Group    : ");
        int group = input.nextInt();
        System.out.print("Course   : ");
        Course courseId = Course.findCourse(null, null, null);
        System.out.print("Teacher ID  : ");
        int teacherId = input.nextInt();
        Teacher teach = (Teacher) User.listUser.get(teacherId);
        if(teach!=null){
            CourseInstance course = new CourseInstance( null, teach, year,term,group);
            return true;
        }
        return false;
        // CourseInstance course = new CourseInstance( null, teacher, year,term,group);
    }
    // void assignStudentToClass(CourseInstance c, Student stu){  
        
    // }
}
