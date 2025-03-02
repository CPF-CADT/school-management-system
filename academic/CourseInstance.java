package academic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import core.Form;
import user.Admin;
import user.Student;
import user.Teacher;
import user.User;

public class CourseInstance {
    static Scanner input = new Scanner(System.in);
    public static HashMap<String, CourseInstance> listCourseInstace = new HashMap<String, CourseInstance>();
    protected Teacher teacher;

    protected Course course;

    public String getKeyIdentical() {
        return keyIdentical;
    }

    public int year;
    public int term;
    public int group;

    private ArrayList<String> listStudent = new ArrayList<>(30);
    private ArrayList<Quizz> quizzes = new ArrayList<Quizz>();
    private ArrayList<Assignment> assignments = new ArrayList<>();
    private String keyIdentical;

    public CourseInstance(Course course, Teacher teacher, int year, int term, int group) {
        this.teacher = teacher;
        this.course = course;
        this.year = year;
        this.term = term;
        this.group = group;
        keyIdentical = generatePrimaryKey(year, term, course.getShortName(), group);
        listCourseInstace.put(keyIdentical, this);
    }

    // Generate key in format Year term course_code GROUP le 2021-T1-GDS-G1
    private static String generatePrimaryKey(int year, int term, String shortName, int group) {
        return String.format("%d-T%d-%s-G%d", year, term, shortName, group);
    }

    // Find instance by primary key
    public static CourseInstance findCourseInstance() {
        System.out.print("Year              : ");
        int year = Form.inputInteger();
        System.out.print("Term              : ");
        int term = Form.inputInteger();
        System.out.print("Course Short Name : ");
        String shortName = input.next();
        System.out.print("Group             : ");
        int group = Form.inputInteger();
        String key = generatePrimaryKey(year, term, shortName, group);
        for (CourseInstance instance : CourseInstance.listCourseInstace.values()) {
            if (instance.getKeyIdentical().equals(key)) {
                return instance;
            }
        }
        return null;
    }

    public ArrayList<String> getlistStudent() {
        return listStudent;
    }

    public boolean studentEnrollment(User user) {
        if (!(user instanceof Admin)) {
            System.out.println("Permission Denied: Only Admins");
            return false;
        } else {
            System.out.println("Student Enrollment ");
            System.out.print("Student ID : ");
            String stuID = input.next();
            if (User.listUser.get(stuID) != null) {
                listStudent.add(stuID);
                Student s = (Student)User.listUser.get(stuID);
                s.addCourseStudy(user,this.course.getCourseId());
                return true;
            }
        }
        return false;
    }

    // public void assignStudent(Object user, int stuID) {
    // if (user instanceof Admin) {
    // listStudent.add(stuID);
    // } else {
    // System.out.println("Access denied: You don't have permission.");
    // }
    // }

    public void setQuizzes(Object user, Quizz quizzes) {
        if (user instanceof Teacher) {
            this.quizzes.add(quizzes);
        } else {
            System.out.println("Access denied: You don't have permission!");
        }
    }

    public Assignment getAssignments(int index) {
        return assignments.get(index);
    }

    public void setAssignments(Object user, Assignment ass) {
        if (user instanceof Teacher) {
            this.assignments.add(ass);
        } else {
            System.out.println("Access denied: You don't have permission!");
        }
    }
}
