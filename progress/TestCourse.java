package progress;

import user.Admin;
import user.User;
import java.util.Scanner;
import academic.Course;

public class TestCourse {
    public static void main(String[] args) {
        User admin = new Admin("adminUser", "adminPass"); // Assuming Admin has a constructor (username, password)

        while (true) {
            System.out.println("\n===== Course Management System =====");
            System.out.println("1 Create Course");
            System.out.println("0 Exit");
            System.out.print("Select an option: ");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Course.createCourse(admin);  // Call the simplified createCourse method
                    break;
                case 0:
                    System.out.println(" Exiting the system. Goodbye!");
                    return;  // Exit the program
                default:
                    System.out.println(" Invalid option. Please try again.");
            }
        }
    }
}
