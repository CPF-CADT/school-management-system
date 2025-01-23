package utils;

import java.util.*;

public class Classroom {
    private int idClass;
    private Teacher teacher = new Teacher();
    private Course course;
    private ArrayList<Student> student = new ArrayList<Student>();

    public Classroom(int idClass, Course course, Teacher teacher, ArrayList<Student> student ){
        this.idClass = idClass;
        this.teacher = teacher;
        this.course = course;
        this.student = student;
    }
}
