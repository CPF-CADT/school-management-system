package academic;

import java.util.*;

import user.Student;
import user.Teacher;

public class Classroom {
    public int idClass;
    public Teacher teacher;
    public Course course;
    public Student[] student ;

    public Classroom(int idClass, Course course, Teacher teacher, Student[] student ){
        this.idClass = idClass;
        this.teacher = teacher;
        this.course = course;
        this.student = student;
    }
}
