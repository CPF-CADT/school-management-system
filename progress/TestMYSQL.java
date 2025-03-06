package progress;

import core.Form;
import core.MySQLConnection;
import user.Student;
import user.Teacher;
import user.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class TestMYSQL {
    public static void main(String[] args) throws SQLException {
        // Form f = new Form();
        // f.register();
        Teacher.syncNumberOfUser();
        Teacher t2 = new Teacher(
                    "Jak",
                    "Jny",
                    "456 Elm St, CA",
                    "98724309210",
                    "Mathematics");
                    System.out.println(t2);
        Student.syncNumberOfUser();
        Student s1=new Student("kon","khmer","82","123");
        try {
            s1.registerToMySQL();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
