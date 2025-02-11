package core;
import user.*;

import java.util.Scanner;

import academic.*;
public class AcademicControl {
    Scanner input = new Scanner(System.in);
    public void createClass(){
        System.out.print("Enter The Clss Information");
        System.out.print("Year     : ");
        int year = input.nextInt();
        System.out.print("Term     : ");
        int term = input.nextInt();
        System.out.print("Group    : ");
        int group = input.nextInt();
        // System.out.print("Course   : ");
        System.out.print("Teacher  : ");
        Teacher teacher = Teacher.selectTeacher();
        CourseInstance course = new CourseInstance( null, teacher, year,term,group);
    }
    // void assignStudentToClass(CourseInstance c, Student stu){  
        
    // }
}
