package academic;

import java.util.ArrayList;

import user.Admin;
import user.Student;
import user.Teacher;

public class CourseInstance {
    static int numebrClassInstance = 0;
    public int id;
    public Teacher teacher;
    public Course course;
    public int year;
    public int term;
    private ArrayList<Student> listStudent = new ArrayList<>(30);

    public CourseInstance(int id, Course course, Teacher teacher,int year,int term){
        numebrClassInstance+=1;
        this.id = numebrClassInstance;
        this.teacher = teacher;
        this.course = course;
        this.year = year;
        this.term = term;
    }
    public ArrayList<Student> listStudent(){
        return listStudent;
    }
    public void assignStudent(Object user,Student stu){
        if(user instanceof Admin){
            listStudent.add(stu);
        }else{
            System.out.println("You Dont Have Permission to Acees");
        }
    }
}
