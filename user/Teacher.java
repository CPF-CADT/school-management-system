package user;

import java.util.HashMap;

public class Teacher extends Person {
    final static String EMAIL_FORMAT = "@tch.kdc.edu";
    public String major;
    public static HashMap<Integer, Teacher> listOfTeacher = new HashMap<Integer, Teacher>();

    public Teacher() {

    }

    // login
    public Teacher(String email, String password) {
        super(email, password);
    }

    // register
    public Teacher(String lastName, String firstName, String address, String phoneNumber, String major) {
        super(lastName, firstName, address, phoneNumber,EMAIL_FORMAT);
        this.major = major;
        listOfTeacher.put(id, this);

    }

    @Override
    public String toString() {
        return super.toString() + "  major :" + major;
    }

    public static Teacher login(Teacher t) {
        for (Teacher teacher : listOfTeacher.values()) {
            if (t.equals(teacher)) {
                return teacher;
            }
        }
        return null;
    }

    public static Teacher selectTeacher() {
        if (Teacher.listOfTeacher.size() != 0) {
            System.out.println("List Teacher ");
            for (Teacher t : listOfTeacher.values()) {
                System.out.println(t);
            }
            System.out.print("Enter ID : ");
            int select = input.nextInt();
            return listOfTeacher.get(select);
        } else {
            System.out.println("No teacher in list");
            return null;
        }
    }
}
