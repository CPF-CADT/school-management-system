package user;

import java.util.HashMap;

public class Teacher extends User {
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
    public Teacher(String firstName,String lastName, String address, String phoneNumber, String major) {
        super(firstName,lastName, address, phoneNumber,EMAIL_FORMAT);
        this.major = major;
        listOfTeacher.put(super.getID(), this);

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

    public void displayUserInfo(){
        super.displayUserInfo();
        System.out.println("Major        : " + major);
        System.out.println("====================================\n");
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
