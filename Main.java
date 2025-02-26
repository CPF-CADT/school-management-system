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
        // Student students = new Student();
        Teacher t = new Teacher(
                "Smith",
                "Alice",
                "456 Elm St, CA",
                "9876543210",
                "Mathematics");
        Teacher t2 = new Teacher(
                    "Jak",
                    "Jony",
                    "456 Elm St, CA",
                    "9876543210",
                    "Mathematics");
                    
                    
        Student s1=new Student("kon","khmer","82","123","year1");
        Student s2=new Student("kon","thai","82","123","year2");

        Form form = new Form();
        Feature feature = new Feature();
        AcademicControl academicControl = new AcademicControl();

        // login to user can be admin , student or teacher
        
        do {
            for (User user : User.listUser.values()){
                user.displayUserInfo();
            }
            System.out.println("Login\n");
            User user = form.login();
            System.out.println(user);
            if (user != null) {
                if (user instanceof Admin) {
                    System.out.println("Admin Interface");
                    Admin admin = (Admin) user;
                    int option = 0 ;
                    do{
        
                        switch (feature.admin()) {
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
                    int option = 0 ;
                    switch (feature.teacher()) {
                        case 1:


                            break;
                        default:
                            break;
                    }
                } else if (user instanceof Student) {
                    System.out.println("Student Interface");
                    Student studentLogin = (Student) user;
                    System.out.println(studentLogin);
                    switch (feature.student()) {
                        case 1:
                            Student.addStudent();
                            break;
                        case 2:
                            studentLogin.displayUserInfo();;
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
