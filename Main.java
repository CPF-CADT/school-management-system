import user.*;
import core.*;

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
        // Student students = new Student();
        Teacher t = new Teacher(
                "Smith",
                "Alice",
                "456 Elm St, CA",
                "9876543210",
                "Mathematics");

        Form form = new Form();
        Feature feature = new Feature();
        AcademicControl academicControl = new AcademicControl();

        // login to user can be admin , student or teacher
        
        do {
            System.out.println(User.listUser);
            System.out.println(User.listUser);
            System.out.println("Login\n");
            User user = form.login();
            if (user != null) {
                if (user instanceof Admin) {
                    System.out.println("Admin Interface");
                    Admin admin = (Admin) user;
                    int option =0 ;
                    do{
                        option = feature.admin();
                        switch (option) {
                            case 1:
                                System.out.println("------------------ Create User Account ------------------ ");
                                form.register();
                                break;
                            case 2:
                                System.out.println("------------------ Create Course ------------------ ");

                                break;
                            
                            case 3:
                                System.out.println("------------------ Create Course Insatnce  ------------------ ");
                                //finish
                                academicControl.createClass();
                                // CourseInstance co = new CourseInstance(2025, 2, 1);
                                // System.out.println(CourseInstance.findCourseInstance(co));
                                break;
                            case 4:
                                System.out.println("------------------ Assign Student ------------------ ");
                                //do it later
                                break;
        
                            default:
                                break;
                        }
                    }while(option!=0);
                } else if (user instanceof Teacher) {
                    System.out.println("Teacher Interface");
                    Teacher teacher = (Teacher) user;
                    System.out.println(teacher);
                    switch (feature.teacher()) {
                        case 1:

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
