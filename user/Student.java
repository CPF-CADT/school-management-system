package user;
import academic.Course;
import java.util.Arrays;
import java.util.Date;

// import java.util.HashSet;

public class Student  extends User{

 public Date dob;
    public String role;
    final static String EMAIL_FORMAT="@std.kdc.edu";

    public  Course[] Course;
    
    //login
    public Student(String email, String password) {
        super(email, password);
    }
    //register
    public Student(String firstName, String lastName, String address, String phoneNumber,String role) {
        super(firstName, lastName, address,phoneNumber, EMAIL_FORMAT);

       

        User.listUser.put(super.getID(),this);

    }

    @Override
    public String toString() {
        return super.toString()+"Student [Course=" + Arrays.toString(Course) + "]";
    }
    
    // public static Student FindStudentById(int id){
    //     for(int i :listOfStudent.keySet()){
    //         if(i== id){
    //             return listOfStudent.get(i);
    //         }
    //     }
    //     return null;
    // }
        public static Student login(User std) {
        for (User student : User.listUser.values()) {
            if (std.equals(student)) {
                return (Student) student;
            }
        }
        return null;
    }

    public static Student selectStudent() {
        if (!User.listUser.isEmpty()) {
            System.out.println("List Student ");
            for (User std : User.listUser.values()) {
                System.out.println(std);
            }
            System.out.print("Enter ID : ");
            int select = input.nextInt();
            User findUser = User.listUser.get(select);
            if(findUser instanceof Student){
                return (Student) findUser;
            }else {
                return null;
            }
        } else {
            System.out.println("No Student in list");
            return null;
        }
    
}



    public String getAddress() {
        return address;
    }

    public static int getPeople() {
        return numberOfPerson;
    }

    public Course[] getCourse() {
        return Course;
    }
    
    




    public void setCourse(Course[] course) {
        Course = course;
    }
    public    void remove() {
        if (!User.listUser.isEmpty()) {
            System.out.println("List Student ");
            for (User std : User.listUser.values()) {
                System.out.println(std);
            }
            System.out.print("Enter ID : ");
            int select = input.nextInt();
             User.listUser.remove(select);
            System.out.println("Remove successfully");
        } else {
            System.out.println("No Student in list");
            
        }
    
}


    // public static void setListOfStudent(HashSet<Student> listOfStudent) {
    //     Student.listOfStudent = listOfStudent;
    // }

}
