package academic;

import java.util.*;

import user.Student;
import user.Teacher;

public class Classroom {
    public int idClass;
    public int teacherId;
    public Course course;
    public HashSet<Integer> listStudentId ;

    public Classroom(int idClass, Course course, int teacherId, HashSet<Integer> listStudentId ){
        this.idClass = idClass;
        this.teacherId = teacherId;
        this.course = course;
        this.listStudentId = listStudentId;
    }
}
