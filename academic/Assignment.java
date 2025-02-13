package academic;

import java.util.Scanner;
import user.Teacher;

public class Assignment {
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
        System.out.println("Assigned by: " + (teacher != null ? teacher.toString() : "Annonyomous"));
    }

    //submit assignment
    public void submitAssignment(String studentName) {
        System.out.println(studentName + " has submitted the assignment: " + title); 
    }
}

