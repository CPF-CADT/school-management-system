package test_code;
import academic.*;
import user.Student;
import user.Teacher;
public class testCourse {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        Student f = new Student();
        Course c = new Course(10, "Java", "Beginner", 200, "the basic of Java");
        Assignment ass = new Assignment(10, 10, "The is the C++", "sdsds", 100);
        c.setAssignments(f,ass);
        System.out.println(c.getAssignments());
    }
}
