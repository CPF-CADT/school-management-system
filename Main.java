import user.*;
import core.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+             KHMER DEGITAL CENTER           +");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

        Admin admin = new Admin(
                "John",
                "Doe",
                "123 Main St, NY",
                "admin@adm.kdc.edu",
                "1234567890",
                "123",
                "Administrator");
        Teacher teachers = new Teacher();
        Student students = new Student();
        Teacher t = new Teacher(
                "Smith",
                "Alice",
                "456 Elm St, CA",
                "alice@tch.kdc.edu",
                "9876543210",
                "123",
                "Mathematics");

        Form form = new Form();
        Feature feature = new Feature();
        Teacher Teacher = new Teacher(null, null);
        Admin Admin = new Admin(null, null);

        // form.register(students, Admin, teachers, 2);
        // login to user can be admin , student or teacher
        do {
            System.out.println("Login\n");
            Object user = form.login(null, null);
            if (user != null) {
                if (user instanceof Admin) {
                    System.out.println("Admin Interface");
                    Admin adm = (Admin) user;
                    int option =0 ;
                    do{
                        option = feature.admin();
                        switch (option) {
                            case 1:
                                System.out.println("------------------ Create Teacher Account ------------------ ");
                                form.register(students, Admin, teachers, 2);
                                break;
                            case 2:
                                System.out.println("------------------ Create Student Account ------------------ ");
                                form.register(students, Admin, teachers, 3);
                                break;
                            case 3:
                                System.out.println("------------------ Create Staff Account ------------------ ");
                                form.register(students, Admin, teachers, 1);
                                break;
                            case 4:
                                System.out.println("------------------ Create Course ------------------ ");
    
                                break;
                            case 5:
                                System.out.println("------------------ Assign Student ------------------ ");
    
                                break;
                            case 6:
                                System.out.println("------------------ Assign Teacher ------------------ ");
                                break;
                            default:
                                break;
                        }
                    }while(option!=0);
                } else if (user instanceof Teacher) {
                    System.out.println("Teacher Interface");
                    Teacher tch = (Teacher) user;
                    System.out.println(tch);
                    switch (feature.teacher()) {
                        case 1:

                            break;
                        default:
                            break;
                    }
                }
            } else {
                System.out.println("Incorrect User account");
            }
        } while (true);
    }
}
