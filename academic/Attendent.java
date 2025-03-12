package academic;

import exception.NumberRangeExceptionHandling;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import user.*;


public class Attendent {
    private ArrayList<Float> attendance = new ArrayList<>();
     Scanner input = new Scanner(System.in);
    private boolean present;
    private boolean late ;
    private boolean absent;
    private boolean permission;
  

    private CourseInstance courseInstance;
    private Date date;
    private int session ;

    public Attendent(ArrayList<Float> attendance, CourseInstance courseInstance, Date date) {
        this.attendance = attendance;
        this.courseInstance = courseInstance;
        this.date = date;
        // this.session = session;
    }
    public Attendent() {

    }
    // public ArrayList<Float> getAttendance() {
    //     return attendance;
    // }
    // public void setAttendance(ArrayList<Float> attendance) {
    //     this.attendance = attendance;
    // }
    // private  float present(float present) {
    //     present +=10.00;
    //     return present;
    // }
    // private float absent(float absent) {
    //     absent +=0.00;
    //     return absent;
    // }
    // private float late(float late) {
    //     late +=5.00;
    //     return late;
    // }
    // private float pointAttendance(float pointAttendance,int session) {
    //     float point=pointAttendance/session;
    //     return point;
    // }
    public void tick(){
        System.out.println("1 . Presnt");	
        System.out.println("2 . Late");	
        System.out.println("3 . Absent");	
        System.out.println("4 . Permission");	
        System.out.print("Choose : ");
        int choice = input.nextInt();
        // Add excepttion from 1 to 4
        try {
            NumberRangeExceptionHandling stuOption = new NumberRangeExceptionHandling(1,4,choice);
            switch(choice){
                case 1:
                    present = true;
                    late = absent = permission = false;
                    
                    break;
                case 2:
                    late = true;
                    present = absent = permission = false;
                    break;
                case 3:
                    absent = true;
                    present = late = permission = false;
                    break;
                case 4:
                    permission = true;
                    present = late = absent = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }}
        public void checkAttendance(Teacher teacher) {
            if(teacher instanceof Teacher) {
                for(String student:courseInstance.listStudent) {
                    System.out.println("Enter attendance for student: "+student);
                    tick();
                }
                System.out.println("Attendance checked successfully!");
            }else {
                System.out.println("Access denied: You Dont have permission!");
            }
            
        }
        
    
    // public  void checkAttendance(Teacher teacher) {
    //         if(teacher instanceof Teacher) {
    //             for(String student:courseInstance.listStudent) {
    //                 System.out.println("Enter attendance for student: "+student);
    //                 System.out.println("1. Present");
    //                 System.out.println("2. Absent");
    //                 System.out.println("3. Late");
    //                 int choice = input.nextInt();
    //                 switch(choice) {
    //                     case 1:
    //                         attendance.add(present(attendance.get(attendance.size()-1)));
    //                         break;
    //                     case 2:
    //                         attendance.add(absent(attendance.get(attendance.size()-1)));
    //                         break;
    //                     case 3:
    //                         attendance.add(late(attendance.get(attendance.size()-1)));
    //                         break;
    //                     default:
    //                         System.out.println("Invalid choice");
    //                         break;
    //                 }
    //             }
    //             System.out.println("Attendance checked successfully!");
    //         }else {
    //             System.out.println("Access denied: You Dont have permission!");
    //         }
    // }
    public static void main(String[] args) {
        Teacher t2 = new Teacher(
            "Jak",
            "Jony",
            "456 Elm St, CA",
            "9876543210",
            "Mathematics");

        Course c = new Course("C++ And OOP", "CPP", 60.0f, "Basic Level");
        ArrayList<String> listStudent = new ArrayList<>();
        listStudent.add("S1");
        listStudent.add("S2");
        listStudent.add("S3");
        CourseInstance clas;
        clas = new CourseInstance(c, t2, 2022, 2, "1",listStudent);
        Attendent att = new Attendent();
        att.checkAttendance(t2);

        
    }

}
