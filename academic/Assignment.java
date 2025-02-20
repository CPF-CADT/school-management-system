package academic;

import java.util.Scanner;
import user.Teacher;

public class Assignment extends Assessment {
    //field
    public int id;
    public int courseId;
    public String title;
    public String description;
    public float score;
    public Teacher teacher;
    public Scanner scanner = new Scanner(System.in);
    
    public Assignment(int id, int courseId, String title, String description, float score, Teacher teacher) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.score = score;
        this.teacher = teacher;
    }

    @Override
    public void provideScore(float score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
            System.out.println("Score provided for Assignment: " + score);
        } else {
            System.out.println("Invalid score! Must be between 0 and 100.");
        }
    }

    @Override
    public void displayAssessment() {
        super.displayAssessment();
        System.out.println("Description: " + description);
    }

    //for teacher  to create an assignment

    public void createAssignment(Object user){
        if (user instanceof Teacher ) {
            System.out.println("Enter Assignment ID: ");
            this.id = scanner.nextInt();
            System.out.println("Enter Course ID: ");
            this.courseId = scanner.nextInt();
            System.out.println("Enter Title: ");
            this.title = scanner.nextLine();
            System.out.println("Enter Description: ");
            this.description = scanner.nextLine();
            System.out.println("Enter Score: ");
            this.score = scanner.nextFloat();
            System.out.println("Assignment created successfully!");
        } else {
            System.out.println("Access denied: You don't have permission!");
        }
    }
    //displlay the assignment
    public void displayAssignment() {
        System.out.println("Assignment ID: " + id);
        System.out.println("Course ID: " + courseId);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Score: " + score);
        System.out.println("Assigned by: " + (teacher != null ? teacher.toString() : "Annonyomous")); //
    }

    //submit assignment
    public void submitAssignment(String studentName) {
        System.out.println(studentName + " has submitted the assignment: " + title); 
    }
}