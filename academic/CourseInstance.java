package academic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import user.Admin;
import user.Student;
import user.Teacher;

public class CourseInstance {
    Scanner input = new Scanner(System.in);
    public static HashMap<String,CourseInstance> listCourseInstace = new HashMap<String,CourseInstance>();
    protected Teacher teacher;

    protected Course course;
    public String getKeyIdentical() {
        return keyIdentical;
    }

    public int year;
    public int term;
    public int group;

    private ArrayList<Student> listStudent = new ArrayList<>(30);
    private ArrayList<Quizz> quizzes = new ArrayList<Quizz>();
    private ArrayList<Assignment> assignments = new ArrayList<>();
    private String keyIdentical;
    public CourseInstance(Course course, Teacher teacher, int year, int term, int group) {
        this.teacher = teacher;
        this.course = course;
        this.year = year;
        this.term = term;
        this.group = group;
        keyIdentical = generatePrimaryKey( year, term, course.getShortName(),group);
        listCourseInstace.put(keyIdentical,this);
    }

    // Generate key in format Year term course_code GROUP le 2021-T1-GDS-G1
    private String generatePrimaryKey(int year, int term, String shortName,int group) {
        return String.format("%d-T%d-%s-G%d", year, term, shortName, group);
    }

    // Find instance by primary key 
    public CourseInstance findCourseInstance(int year, int term,String shortName, int group) {
        String key = generatePrimaryKey(year, term, shortName,group);
        for (CourseInstance instance : CourseInstance.listCourseInstace.values()) {
            if (instance.getKeyIdentical().equals(key)) {
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
