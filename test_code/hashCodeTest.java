package test_code;
import user.Teacher;
public class hashCodeTest {
    public static void main(String[] args) {
        Teacher Teachers = new Teacher("nak","jak","ada","nak@","123","123","fds");
        Teacher Teach = new Teacher("nak@", "12");
        Teach = Teacher.FindTeacher(Teachers);
        if(Teach!=null){
            System.out.println(Teach);
        }
    }
}
