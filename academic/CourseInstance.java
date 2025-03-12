package academic;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import core.Form;
import core.MySQLConnection;
import exception.NumberRangeExceptionHandling;
import java.sql.Date;
import user.Admin;
import user.Student;
import user.Teacher;
import user.User;

public class CourseInstance {
    static Scanner input = new Scanner(System.in);
    public static HashMap<String, CourseInstance> listCourseInstace = new HashMap<String, CourseInstance>();
    protected String teacherID;

    public Course course;
    public int year;
    public int term;
    public String group;
    ArrayList<String> listStudent = new ArrayList<>(30); //future will store referenece of student
    private ArrayList<Quizz> quizzes = new ArrayList<Quizz>();
    private ArrayList<Assignment> assignments = new ArrayList<>();
    private HashMap<String, ArrayList<Attendent>> attendents = new HashMap<>();
    private String keyIdentical;
    
    private HashMap<String,ArrayList<Grading>> stuGrade =  new HashMap<String,ArrayList<Grading>>();
    public CourseInstance(Course course, String teacherID, int year, int term, String group,ArrayList<String> listStudent) {
        this.teacherID = teacherID;
        this.course = course;
        this.year = year;
        this.term = term;
        this.group = group;
        keyIdentical = generatePrimaryKey(year, term, group ,course.getShortName());
        listCourseInstace.put(keyIdentical, this);
    }
    public CourseInstance(Course course, Teacher teacher, int year, int term, String group) {
        this.teacherID = teacher.getId();
        this.course = course;
        this.year = year;
        this.term = term;
        this.group = group;
        keyIdentical = generatePrimaryKey(year, term, group ,course.getShortName());
        teacher.addTeachingCourse(keyIdentical);
        listCourseInstace.put(keyIdentical, this);
    }


    // Generate key in format Year term course_code GROUP le 2021-T1-GDS-G1
    private static String generatePrimaryKey(int year, int term,String group,String shortName) {
        return String.format("%d-%d-%s-%s", year, term,group,shortName);
    }

    // Find instance by primary key
    public static CourseInstance findCourseInstance() {
        System.out.print("Year              : ");
        int year = Form.inputInteger();
        System.out.print("Term              : ");
        int term = Form.inputInteger();
        System.out.print("Course Short Name : ");
        String shortName = input.next();
        System.out.print("Group             : ");
        String group = input.next();
        String key = generatePrimaryKey(year, term, group, shortName);
        for (CourseInstance instance : CourseInstance.listCourseInstace.values()) {
            if (instance.getKeyIdentical().equals(key)) {
                return instance;
            }
        }
        return null;
    }

    public ArrayList<String> getlistStudent() {
        return listStudent;
    }

    public boolean studentEnrollment(User user) {
        if (!(user instanceof Admin)) {
            System.out.println("Permission Denied: Only Admins");
            return false;
        } else {
            System.out.println("Student Enrollment ");
            System.out.print("Student ID : ");
            String stuID = input.next();
            if (User.listUser.get(stuID) != null) {
                listStudent.add(stuID);
                Student s = (Student)User.listUser.get(stuID);
                s.addCourseStudy(user,this.keyIdentical);
                ArrayList<Grading> g = new ArrayList<Grading>();
                stuGrade.put(stuID,g);
                return true;
            }
        }
        return false;
    }

    public void setQuizzes(Object user, Quizz quizzes) {
        if (user instanceof Teacher) {
            this.quizzes.add(quizzes);
        } else {
            System.out.println("Access denied: You don't have permission!");
        }
    }

    public Assignment getAssignments(int index) {
        return assignments.get(index);
    }
    
    public void setAssignments(Object user, Assignment ass) {
        if (user instanceof Teacher) {
            this.assignments.add(ass);
        } else {
            System.out.println("Access denied: You don't have permission!");
        }
    }
    public String getKeyIdentical() {
        return keyIdentical;
    }

    public void setStuGrade(User user,String stuID, String assessmentType,int ses_number,float socre) {
        if(user instanceof Teacher){
            Grading grade = new Grading(assessmentType, ses_number, socre);
            stuGrade.get(stuID).add(grade);
        }else{
            System.out.println("Access Denied : teacherID Only");
        }
    }
    public static void syncCourseInstance(ArrayList<String> instanceID){
        //check instanceID is null or not
        for(String classID : instanceID){
            String query = "SELECT * FROM Course_instance AS c WHERE c.course_instance_id = '"+classID+"';";
            ResultSet result = MySQLConnection.executeQuery(query);
            if(result!=null){
                try{
                    while(result.next()){
                        int year = result.getInt("year");
                        int term = result.getInt("term");
                        String group = result.getString("group_s");
                        String short_name = result.getString("short_name");
                        String teacher_id = result.getString("teacher_id");
                        Course.syncCourse(short_name);
                        try{
                            Course course = Course.findCourse(short_name);
                            ArrayList<String> listStu = getStudentList(year,term,group,short_name);
                            CourseInstance c = new CourseInstance(course, teacher_id, year, term, group,listStu);
                        }catch(NullPointerException nu){
                            System.out.println("Cannot Sync" + nu.getMessage());
                        }
                    }
                }catch(SQLException e){
                    System.out.println("Cannot Sync"+e.getMessage());
                }
            }
        }
    }
    private static ArrayList<String> getStudentList(int y,int t,String g,String short_name){
        String query = "SELECT student_id FROM Enrollment WHERE course_instance_id = (SELECT course_instance_id FROM Course_instance WHERE year = "+y+" AND term = "+t+" AND group_s = '"+g+"' AND short_name = '"+short_name+"');";
        ArrayList<String> list = new ArrayList<String>();
        ResultSet result =  MySQLConnection.executeQuery(query);
        if(result!=null){
            try{
                while (result.next()) {
                    list.add(result.getString("student_id"));
                }
            }catch(SQLException sql){
                System.out.println("No Student In Class "+ sql.getMessage());
            }
        }

        return list;
    }

        public class Attendent {
        
        Scanner input = new Scanner(System.in);
        private boolean present;
        private boolean late;
        private boolean absent;
        private boolean permission;
        private Date date;
        private int session;
        public Attendent() {
        }

        public void tick() {
            System.out.println("1. Present");
            System.out.println("2. Late");
            System.out.println("3. Absent");
            System.out.println("4. Permission");
            System.out.print("Choose: ");
            int choice = input.nextInt();
            try {
                NumberRangeExceptionHandling stuOption = new NumberRangeExceptionHandling(1, 4, choice);
                switch (choice) {
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
            }
        }
        
        public void checkAttendance(Teacher teacher) {
            if (teacher instanceof Teacher) {
                for (String student : listStudent) {
                    System.out.println("Enter attendance for student: " + student);
                    tick();
                }
                System.out.println("Attendance checked successfully!");
            } else {
                System.out.println("Access denied: You don't have permission!");
            }
        }
    }


}
