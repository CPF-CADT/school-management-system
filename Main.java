import core.Form;
import user.Admin;
import user.Student;
import user.Teacher;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome To School");
        Admin admin = new Admin(
            "John", 
            "Doe", 
            "123 Main St, NY", 
            "admin@adm.kdc.edu", 
            "1234567890", 
            "123", 
            "Administrator"
        );
        Teacher teachers = new Teacher();
        Student students = new Student();
        Teacher t = new Teacher(
            "Smith",
            "Alice",
            "456 Elm St, CA",
            "alice@tch.kdc.edu",
            "9876543210",
            "123",
            "Mathematics"
        );

        Form form = new Form();
        Teacher Teacher = new Teacher(null, null);
        Admin Admin = new Admin(null, null);
        Object user = form.login(null, null);
        
        if(user!=null){
            if(user.getClass() == Admin.getClass()){
                System.out.println("Admin Interface");
                Admin adm = (Admin) user;
                System.out.println(adm);
            }else if(user.getClass() == Teacher.getClass()){
                System.out.println("Teacher Interface");
                Teacher tch = (Teacher) user;
                System.out.println(tch);
            }
        }else{
            System.out.println("Incorrect User account");
            
        }
    }
}
