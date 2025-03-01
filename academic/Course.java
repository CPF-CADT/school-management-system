package academic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import user.Admin;
import user.User;

public class Course {
    public float getFee() {
        return fee;
    }

    public String getShortName() {
        return shortName;
    }
    static int totalCourse;
    private int courseId;
    
    public String name; //graphic design
    public String level;
    public String description;

    private float fee;
    private String shortName;
    public static HashMap<String, Course> listCourses = new HashMap<>();
    //constructor 
    public Course(int id, String name, String shortName, String level, float fee, String description) {

        totalCourse += 1;
        this.courseId = totalCourse;
        this.name = name;
        this.shortName = shortName;
        this.level = level;
        this.fee = fee;
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "Course [id=" + courseId + ", name=" + name + ", level=" + level + ", fee=" + fee + ", description="
                + description + "]";
    }
    // Method to find a course by short name and level
    // GDS, Beginner
    public static Course findCourse(String shortName, String level) {
        for (Course course : Course.listCourses.values()) {
            if (course.shortName.equalsIgnoreCase(shortName) && course.level.equalsIgnoreCase(level)) {
                return course;
            }
        }
        return null;
    }
    public static void removeCourse(ArrayList<Course> courses, int inputId) {
        for (Course course : courses) {
            if (inputId == course.courseId) {
                courses.remove(course);
                System.out.println("Course removed successfully.");
                return;
            }
        }
    }
    // Method to create a course by user input
    public static void createCourse(User user) {
        if (!(user instanceof Admin)) {
            System.out.println("Permission Denied: Only Admins can create courses.");
            return;
        }
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Course Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Short Name: ");
            String shortName = scanner.nextLine();
            System.out.print("Enter Level: ");
            String level = scanner.nextLine();
            System.out.print("Enter Fee: ");
            float fee = scanner.nextFloat();
            scanner.nextLine();
            System.out.print("Enter Description: ");
            String description = scanner.nextLine();          
            Course newCourse = new Course(totalCourse, name, shortName, level, fee, description);
            System.out.println("Course Created Successfully: " + newCourse);
        }
    // Method to display all courses
    public static void displayCourses(ArrayList<Course> courses) {
        for (Course course : courses) {
            System.out.println(course);
        }
    }   
    // public static void updateCourse(User user, Course course) {
    //     if (!(user instanceof Admin)) {
    //         System.out.println("Permission Denied: Only Admins can update courses.");
    //         return;
    //     }
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.print("-- Update Course --\n");
    //     System.out.print("Enter New Course Name: ");
    //     course.name = scanner.nextLine();       
    //     System.out.print("Enter Short Name: ");
    //     course.shortName = scanner.nextLine();
    //     System.out.print("Enter Level: ");
    //     course.level = scanner.nextLine();
    //     System.out.print("Enter Fee: ");
    //     course.fee = scanner.nextFloat();
    //     scanner.nextLine(); // Consume newline
    //     System.out.print("Enter Description: ");
    //     course.description = scanner.nextLine();
    //     System.out.println("Course Updated Successfully: " + course);
    // }
}