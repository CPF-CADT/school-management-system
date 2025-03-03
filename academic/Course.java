package academic;

import java.util.ArrayList;
import java.util.HashMap;

import core.Form;
import exception.NumberRangeExceptionHandling;
public class Course {
    static int totalCourse;
    private int courseId;
    
    public String name; //graphic design
    // public String level;
    public String description;

    public int getCourseId() {
        return courseId;
    }

    private float fee;
    private String shortName;
    public static HashMap<Integer, Course> listCourses = new HashMap<>();

    //constructor 
    public Course(String name, String shortName, float fee, String description) {
        totalCourse += 1;
        this.courseId = totalCourse;
        this.name = name;
        this.shortName = shortName;
        // this.level = level;
        this.fee = fee;
        this.description = description;
        listCourses.put(courseId, this);
    }
    
    // @Override
    // public String toString() {
    //     return "Course " + courseId + ", name=" + name + ", level=" + level + ", fee=" + fee + ", description="
    //             + description ;
    // }
    @Override
    public String toString() {
        return "Course ID: " + courseId + "\n" +
               "Name: " + name + "\n" +
               "Short Name: " + shortName + "\n" +
            //    "Level: " + level + "\n" +
               "Fee: $" + fee + "\n" +
               "Description: " + description;
    }

    // Method to find a course by short name and level
    // GDS, Beginner
    public static Course findCourse(String shortName, String level) {
        for (Course course : Course.listCourses.values()) {
            if (course.shortName.equalsIgnoreCase(shortName)) {
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
    public static Course selectCourse(){
        displayCourses();
        System.out.print("Entetr Course ID : ");
        int courseID = 0;
        try{
            courseID = Form.inputInteger(); 
            NumberRangeExceptionHandling n = new NumberRangeExceptionHandling(1,Course.listCourses.size(),courseID);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return Course.listCourses.get(courseID);
    }
    // Method to display all courses
    public static void displayCourses() {
        for (Course course : Course.listCourses.values()) {
            System.out.println(course);
            System.out.println("------------------------------------------");

        }
    }  
    public float getFee() {
        return fee;
    }

    public String getShortName() {
        return shortName;
    } 
}