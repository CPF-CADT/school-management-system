import java.sql.SQLException;

import academic.CourseInstance;
import core.*;
import user.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+             KHMER DEGITAL CENTER           +");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

        int incorrectLoginCount = 3;
        try{
            Student.syncNumberOfUser();
            Teacher.syncNumberOfUser();
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }

        Admin adm = new Admin(
                "John",
                "Doe",
                "123 Main St, NY",
                "1234567890",
                "Administrator");
        // Teacher t = new Teacher(
        //         "Smidth",
        //         "Alice",
        //         "456 Elm St, CA",
        //         "9876543256100",
        //         "Mathematics");
        // Teacher t2 = new Teacher(
        //             "Jsak",
        //             "Jony",
        //             "456 Elm St, CA",
        //             "98765432100",
        //             "Mathematics");
                              
        // Student s1=new Student("kon","khmer","82","1231");
        // Student s2=new Student("kon","thai","82","123");
        // Student s = new Student("kon.thai5@stu.kdc.edu", "kdc2025");
        // System.out.println(User.login(s));
        Form form = new Form();
        // login to user can be admin , student or teacher
        
        do {
            System.out.println("Login\n");
            User user = form.login();
            if (user != null) {
                if (user instanceof Admin) {
                    System.out.println("Admin Interface");
                    Admin admin = (Admin) user;
                    int option = 0 ;
                    do{
        
                        switch (Feature.admin()) {
                            case 1:
                                System.out.println("------------------ Create User Account ------------------ ");
                                form.register();
                                break;
                            case 2:
                                System.out.println("------------------ Create Course ------------------ ");
                                AcademicControl.createCourse(admin);
                                break;
                            case 3:
                                System.out.println("------------------ Create Course Insatnce  ------------------ ");
                                AcademicControl.createClass(admin);
                                break;
                            case 4:
                                System.out.println("------------------ Assign Student ------------------ ");
                                try{
                                    CourseInstance stuClass = CourseInstance.findCourseInstance();
                                    stuClass.studentEnrollment(admin);
                                }catch(NullPointerException n){
                                    System.out.println("Class not Found");
                                }
                                break;
                            case 5:
                                System.out.println("------------------ Save to Cloud ------------------ ");
                                for(User u : User.listUser.values()){
                                    if (!(u instanceof Admin)){ //dont have table admin
                                        try{
                                            u.registerToMySQL();
                                            System.out.println(u.firstName + u.lastName + " Save.");
                                        }catch(SQLException e){
                                           System.out.println("data is already save");
                                        }
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                    }while(option==0);
                } else if (user instanceof Teacher) {
                    System.out.println("Teacher Interface");
                    Teacher teacher = (Teacher) user; //casting
                    System.out.println(teacher);
                    switch (Feature.teacher()) {
                        case 1:
                            System.out.println( "-------------- Teaching Course -------------- ");
                            teacher.selectCourseTeaching();
                            break;
                        default:
                            break;
                    }
                } else if (user instanceof Student) {
                    System.out.println("Student Interface");
                    Student studentLogin = (Student) user;
                    System.out.println(studentLogin);
                    switch (Feature.student()) {
                        case 1:
                            System.out.println(" - Your Course ");
                            studentLogin.selectCourseStudy();
                            ///
                            break;
                        case 2:
                            break;
                        default:
                            break;
                    }
                }
            } else {
                incorrectLoginCount-=1;
                System.out.println("Incorrect User account");
                if(incorrectLoginCount==0) break;
            }
        } while (true);
    }
}