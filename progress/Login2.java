package progress;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import core.MySQLConnection;
import user.Student;

public class Login2 {
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // System.out.print("Email address : ");
        // String email = input.next();
        // System.out.print("Password      : ");
        // String password = input.next();
        // String query = "SELECT * FROM Student WHERE email = '" + email + "' AND password = '" + password + "';";
        String query = "SELECT u.id,u.first_name,u.last_name,u.dob,u.address,u.email,u.phone_number,u.password FROM User AS u JOIN Students AS s ON u.id = s.user_id "+ "WHERE email = '" + "kon.thai5@stu.kdc.edu" + "' AND password = '" + "kdc2025" + "';";
        ResultSet result = MySQLConnection.executeQuery(query);
        if(result!=null){
            try{
                if (result.next()) { 
                    String userId = result.getString("id"); 
                    String userEmail = result.getString("email");
                    String phone = result.getString("phone_number"); 
                    String userPassword = result.getString("password");
                    String firstName = result.getString("first_name");
                    String lastName = result.getString("last_name");
                    String address = result.getString("address");
                    Student stu = new Student();
                    System.out.println("Hello " + stu);
                    System.out.println("Login Success");
                } else {
                    System.out.println("Invalid email or password.");
                }
            }catch(SQLException s){
                
            }
        }else{
            System.out.println("Fail");
        }
    }
}
