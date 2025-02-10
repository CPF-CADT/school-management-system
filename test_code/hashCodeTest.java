package test_code;
import user.Teacher;
public class hashCodeTest {
    
        public static void main(String[] args) {
        Person p = new Person("12", "13");
        Person p2 = new Person("12", "12","Kh");
        System.out.println(p.equals(p2));

    }
}
