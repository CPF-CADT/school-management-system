package academic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import user.Admin;
import user.Student;
import user.Teacher;

public class CourseInstance {
    Scanner input = new Scanner(System.in);

    public static ArrayList<CourseInstance> listCourseInstace = new ArrayList<>();
    private static HashSet<String> uniqueKeys = new HashSet<>(); // For uniqueness

    public int id;
    public Teacher teacher;
    public Course course;
    public int year;
    public int term;
    public int group;
    private ArrayList<Student> listStudent = new ArrayList<>(30);
    private Quizz[] quizzes;
    private Assignment assignments;
    public String primaryKey; // Unique primary key

    public CourseInstance(Course course, Teacher teacher, int year, int term, int group) {
        this.primaryKey = generatePrimaryKey(course, year, term, group);

        // Check uniqueness
        if (!uniqueKeys.add(this.primaryKey)) {
            throw new IllegalArgumentException("Error: Course instance already exists: " + this.primaryKey);
        }

        this.id = listCourseInstace.size() + 1;
        this.teacher = teacher;
        this.course = course;
        this.year = year;
        this.term = term;
        this.group = group;
        listCourseInstace.add(this);
    }

    // Generate key in format Year term course_code GROUP le Y2021T1 GDS G1
    private static String generatePrimaryKey(Course course, int year, int term, int group) {
        return String.format("Y%dT%d %s G%d", year, term, course.getShortNameCode(), group);
    }

    // Find instance by primary key 
    public static CourseInstance findCourseInstance(Course course, int year, int term, int group) {
        String key = generatePrimaryKey(course, year, term, group);
        for (CourseInstance instance : listCourseInstace) {
            if (instance.primaryKey.equals(key)) {
                return instance;
            }
        }
        return null;
    }
    public ArrayList<Student> listStudent() {
        return listStudent;
    }

    public void assignStudent(Object user, Student stu) {
        if (user instanceof Admin) {
            listStudent.add(stu);
        } else {
            System.out.println("Access denied: You don't have permission.");
        }
    }

    public Quizz[] getQuizzes() {
        return quizzes;
    }
    public void setQuizzes(Object user, Quizz[] quizzes) {
        if (user instanceof Teacher) {
            this.quizzes = quizzes;
        } else {
            System.out.println("Access denied: You don't have permission!");
        }
    }

    public Assignment getAssignments() {
        return assignments;
    }

    public void setAssignments(Object user, Assignment ass) {
        if (user instanceof Teacher) {
            this.assignments = ass;
        } else {
            System.out.println("Access denied: You don't have permission!");
        }
    }
    // @Override
    // public String toString() {
    //     // return primaryKey + " | Teacher: " + teacher.getName();
    // }
}
