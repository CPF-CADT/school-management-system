package academic;

import java.util.Scanner;
import user.Teacher;

public class Assignment extends Assessment {
    //fields
    public String instruction; 
    Scanner scanner = new Scanner(System.in);
    
    public Assignment(int courseId, String title, Teacher teacher, float score,String description) {
        super(courseId, title, teacher,score,description);
        this.description = description;
    }

    @Override
    //add student score
    public void addStudentScore(int studentId, float score) {
        
    }

    @Override
    public void displayAssessment() {
        super.displayAssessment();
        System.out.println("Description: " + description);
    }

    //for teacher  to create an assignment

    public void createAssignment(Object user){
        if (user instanceof Teacher ) {
            System.out.println("Enter Course ID: ");
            this.courseId = scanner.nextInt();
            System.out.println("Enter Title: ");
            this.title = scanner.nextLine();
            System.out.println("Enter Description: ");
            this.description = scanner.nextLine();
            System.out.println("Enter Score: ");
            this.totalScore = scanner.nextFloat();
            System.out.println("Assignment created successfully!");
        } else {
            System.out.println("Access denied: You don't have permission!");
        }
    }
    //displlay the assignment
    public void displayAssignment() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Score: " + totalScore);
        System.out.println("Assigned by: " + (teacher != null ? teacher.toString() : "Annonyomous")); //
    }

    //submit assignment
    public void submitAssignment(String studentName) {
        System.out.println(studentName + " has submitted the assignment: " + title); 
    }
}