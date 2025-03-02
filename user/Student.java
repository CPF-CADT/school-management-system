package user;
import academic.Course;
import core.Form;
import exception.NumberRangeExceptionHandling;

import java.util.ArrayList;
import java.util.Date;
public class Student  extends User{

    public Date dob;
    public String role;
    final static String EMAIL_FORMAT="@stu.kdc.edu";
    static int numberOfStudents = 0;
    private String id = "S";
    private ArrayList<Integer> studyCourseID = new ArrayList<Integer>();
    
    //login
    public Student(String email, String password) {
        super(email, password);
    }

    //register
    public Student(String firstName, String lastName, String address, String phoneNumber,String role) {
        super(firstName,lastName, address, phoneNumber,EMAIL_FORMAT);
        id +=(String.valueOf(++numberOfStudents));
        this.role=role;
        User.listUser.put(this.id, this);
    }

    @Override
    public String toString() {
        String userInfo = super.toString();
        userInfo += "ID            : " + id + "\n"
                 + "Course         : " + studyCourseID + "\n"
                 + "====================================\n";
        return userInfo;
    }
    

    // public static Student FindStudentById(int id){
    //     for(int i :listOfStudent.keySet()){
    //         if(i== id){
    //             return listOfStudent.get(i);
    //         }
    //     }
    //     return null;
    // }
    //     public static Student login(User std) {
    //     for (User student : User.listUser.values()) {
    //         if (std.equals(student)) {
    //             return (Student) student;
    //         }
    //     }
    //     return null;
    // }
    
    public Course selectCourseStudy(){
        for(int i=0;i<studyCourseID.size();i++){
            System.out.println((i+1) + " . "+ Course.listCourses.get(studyCourseID.get(i)).name );
        }
        System.out.print("Choose Course : ");
        try{
            int choose = Form.inputInteger();
            NumberRangeExceptionHandling c = new NumberRangeExceptionHandling(1,studyCourseID.size(),choose);
            Course cStudy = Course.listCourses.get(studyCourseID.get(choose-1));
            return cStudy;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public  Student selectStudent() {
        if (!User.listUser.isEmpty()) {
            System.out.println("List Student ");
            for (User std : User.listUser.values()) {
                System.out.println(std);
            }
            System.out.print("Enter ID : ");
            String select = input.nextLine();
            User findUser = User.listUser.get(select);
            if(findUser instanceof Student student){
                return student;
            }else {
                System.out.println("ot kert");
                return null;
            }
        } else {
            System.out.println("No Student in list");
            return null;
        }
    
    }
    
    public boolean addCourseStudy(User user,int c_id){
        if(user instanceof Admin){
            //add validation
            studyCourseID.add(c_id);
            return true;
        }
        return false;
    }
    
    public    void remove() {
        if (!User.listUser.isEmpty()) {
            System.out.println("List Student ");
            for (User std : User.listUser.values()) {
                System.out.println(std);
            }
            System.out.print("Enter ID : ");
            String select = input.nextLine();
             User.listUser.remove(select);
            System.out.println("Remove successfully");
        } else {
            System.out.println("No Student in list");
            
        }
    }

}
