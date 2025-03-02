package core;
import user.*;

import java.util.Scanner;

import academic.*;
import exception.CastFromUserToAnotherException;
public class AcademicControl {
    Scanner input = new Scanner(System.in);
    public boolean createCourse(User user) {
        if (!(user instanceof Admin)) {
            System.out.println("Permission Denied: Only Admins can create courses.");
            return false;
        }else{
            System.out.print("Enter Course Name: ");
            String name = input.nextLine();
            System.out.print("Enter Short Name: ");
            String shortName = input.next();
            System.out.print("Enter Level: ");
            String level = input.next();
            System.out.print("Enter Fee: ");
            float fee = input.nextFloat();
            input.nextLine();
            System.out.print("Enter Description: ");
            String description = input.nextLine();    
            Course c = new Course(name, shortName, fee, description);
            return true;
        }
    }

    public boolean createClass(User user){
        if (!(user instanceof Admin)) {
            System.out.println("Permission Denied: Only Admins can create class.");
            return false;
        }else{
            System.out.println("Enter The Clss Information");
            System.out.print("Year     : ");
            int year = Form.inputInteger();
            System.out.print("Term     : ");
            int term = Form.inputInteger();
            System.out.print("Group    : ");
            int group = Form.inputInteger();
            System.out.println(" - Select Course ");
            Course c = Course.selectCourse();
            System.out.print("Teacher ID  : ");
            String teacherId = input.next();
            User t = User.listUser.get(teacherId);
            Teacher teach = null;
            try {
                CastFromUserToAnotherException cast = new CastFromUserToAnotherException(t,teach);
                teach = (Teacher) t;
            } catch (ClassCastException e) {
                System.out.println(e.getMessage());
                System.out.println("Class Create Unsuccess");
                return false;
            }
            CourseInstance course = new CourseInstance( c, teach, year,term,group);
        }
        // CourseInstance course = new CourseInstance( null, teacher, year,term,group);
        return true;
    }
}
