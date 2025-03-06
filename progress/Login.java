    package progress;

    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.Scanner;

import core.Form;
import core.MySQLConnection;
import user.Student;
import user.Teacher;

    public class Login {
        public static void main(String[] args) {
            // String query = "SELECT * FROM Student WHERE email = '" + email + "' AND password = '" + password + "';";
            Form f = new Form();
            // Teacher r = (Teacher) f.login();   
            // Student r = (Student) ;   
            System.out.println(f.login());         
        }
    }
