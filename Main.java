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
        Admin adm = new Admin(
                "John",
                "Doe",
                "123 Main St, NY",
                "1234567890",
                "Administrator");
        Form form = new Form();
        
        //check internet connection
        // if(MySQLConnection.getConnection()!=null){
            
        // }else{
        //     //use local session
        // }
        
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
                                try{
                                    Student.syncNumberOfUser();
                                    Teacher.syncNumberOfUser();
                                }catch(SQLException sql){
                                    System.out.println(sql.getMessage());
                                }
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
                            case 0:
                                System.exit(1);;
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
                        case 0:
                            System.exit(1);;
                            break;
                        default:
                            break;
                    }
                } else if (user instanceof Student) {
                    System.out.println("Student Interface");
                    System.out.println(CourseInstance.listCourseInstace);
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
                        case 0:
                            System.exit(1);;
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