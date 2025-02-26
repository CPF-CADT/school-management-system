package user;

import java.util.ArrayList;

// import java.util.HashMap;

public class Teacher extends User {
    static int numberOfTeacher = 0;
    public String id = "T";
    final static String EMAIL_FORMAT = "@tch.kdc.edu";
    ArrayList<Integer> teachingCourseId = new ArrayList<Integer>();
    public String major;
    // login
    public Teacher(String email, String password) {
        super(email, password);
    }

    // register
    public Teacher(String firstName,String lastName, String address, String phoneNumber, String major) {
        super(firstName,lastName, address, phoneNumber,EMAIL_FORMAT);
        id +=(String.valueOf(++numberOfTeacher));
        this.major = major;
        User.listUser.put(this.id, this);
    }

    @Override
    public String toString() {
        String userInfo = super.toString();
        userInfo += "ID           : " + id + "\n"
                 + "Major         : " + major + "\n"
                 + "====================================\n";
        return userInfo;
    }

    @Override
    public void displayUserInfo(){
        super.displayUserInfo();
        System.out.println("ID           : " + id);
        System.out.println("Major        : " + major);
        System.out.println("====================================\n");
    }
}
