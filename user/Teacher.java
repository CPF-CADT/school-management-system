package user;

import java.util.ArrayList;

import academic.CourseInstance;
import core.Form;
import exception.NumberRangeExceptionHandling;

// import java.util.HashMap;

public class Teacher extends User {
    static int numberOfTeacher = 0;
    public String id = "T";
    final static String EMAIL_FORMAT = "@tch.kdc.edu";
    public ArrayList<String> teachingCourseId = new ArrayList<String>();
    public String major;
    // login
    public Teacher(String email, int password) {
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

    public void addTeachingCourse(String c_id){
            //add validation
        teachingCourseId.add(c_id);
    }

    public CourseInstance selectCourseTeaching(){
        for(int i=0;i<teachingCourseId.size();i++){
            System.out.println((i+1) + " . "+ CourseInstance.listCourseInstace.get(teachingCourseId.get(i)).course.name );
        }
        System.out.print("Choose Course : ");
        try{
            int choose = Form.inputInteger();
            NumberRangeExceptionHandling c = new NumberRangeExceptionHandling(1,teachingCourseId.size(),choose);
            CourseInstance cStudy = CourseInstance.listCourseInstace.get(teachingCourseId.get(choose-1));
            return cStudy;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

}
