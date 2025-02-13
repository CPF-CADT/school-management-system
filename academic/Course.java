package academic;

import java.util.ArrayList;
import java.util.Scanner;
import user.Admin;
import user.User;

public class Course {
    static int totalCourse;
    public int id;
    public String name;
    public String level;
    public float fee;
    public String description;
    public String shortName;

    public Course(int id, String name, String shortName, String level, float fee, String description) {
        totalCourse+=1;
        id = totalCourse;
        this.name = name;
        this.shortName = shortName;
        this.level = level;
        this.fee = fee;
        this.description = description;
    }
    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", level=" + level + ", fee=" + fee + ", description="
                + description + "]";
    }
        // Method to find a course by short name and level
    public static Course findCourse(ArrayList<Course> courses, String shortName, String level) {
        for (Course course : courses) {
            if (course.shortName.equals(shortName) && course.level.equals(level)) {
                return course;
            }
        }
        return null;
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
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();
        
        Course newCourse = new Course(totalCourse, name, shortName, level, fee, description);
    System.out.println("Course Created Successfully: " + newCourse);
}
}

