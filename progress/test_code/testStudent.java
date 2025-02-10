package test_code;

import user.Student;

public class testStudent {
    public static void main(String[] args) {
        System.out.println("kon khmer b sl o");
        Student std=new Student("J@gmail","123");
        Student joe=new Student("P@gmail","1233");
        System.out.println(std.id);
        System.out.println(joe.id);
    }
}
