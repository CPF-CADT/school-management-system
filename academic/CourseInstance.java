package academic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import user.Admin;
import user.Student;
import user.Teacher;

public class CourseInstance {
    Scanner input = new Scanner(System.in);
    static int numebrClassInstance = 0;
    public int id;
    public Teacher teacher;
    public Course course;
    public int year;
    public int term;
    public int group;
    private ArrayList<Student> listStudent = new ArrayList<>(30);
    private Quizz[] quizzes;
    private Assignment assignments;
    static HashSet<CourseInstance> listCourseInstace = new HashSet<CourseInstance>();
    
    public CourseInstance(Course course, Teacher teacher, int year, int term,int group) {
        numebrClassInstance += 1;
        this.id = numebrClassInstance;
        this.teacher = teacher;
        this.course = course;
        this.year = year;
        this.term = term;
        this.group = group;
        listCourseInstace.add(this);
    }
    public CourseInstance(int year, int term,int group){
        this.year = year;
        this.term = term;
        this.group = group;
    }
    public static CourseInstance findCourseInstance(CourseInstance obj) {
        for(CourseInstance c : listCourseInstace){
            if(c.year == obj.year){
                if(c.term == obj.term){
                    if(c.group ==obj.group){
                        return c;
                    }
                }
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
            System.out.println("You Dont Have Permission to Acees");
        }
    }

    public Quizz[] getQuizzes(int code) {
        return quizzes;
    }
    public void setQuizzes(Object user, Quizz[] quizzes) {
        if (user instanceof Teacher) {
            this.quizzes = quizzes;
        } else {
            System.out.println("Access denied: You Dont have permission!");
        }
    }

    public Assignment getAssignments() {
        return assignments;
    }

    public void setAssignments(Object user, Assignment ass) {
        if (user instanceof Teacher) {
            this.assignments = ass;
        } else {
            System.out.println("Access denied: You Dont have permission!");
        }
    }
}
