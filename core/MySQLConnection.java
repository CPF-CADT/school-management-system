package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/hr"; // Change database name
        String user = "root";
        String password = "";
        String query = "SELECT * FROM employees WHERE employee_id = 150";

        // Connect to MySQL
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                System.out.println(id + " | " + fname + " | " + lname);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
