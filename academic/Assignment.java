package academic;

import java.util.HashMap;
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

    public void createAssignment(Teacher teacher) {
        
        System.out.print("Enter Assignment ID: ");
        this.id = scanner.nextInt();
        
        System.out.print("Enter Course ID: ");
        this.courseId = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter Title: ");
        this.title = scanner.nextLine();

        System.out.print("Enter Description: ");
        this.description = scanner.nextLine();
        
        System.out.print("Enter Score: ");
        this.score = scanner.nextFloat();
        
        this.teacher = teacher;
    } 
    //displlay the assignment
    public void displayAssignment() {
        System.out.println("Assignment ID: " + id);
        System.out.println("Course ID: " + courseId);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Score: " + score);
        System.out.println("Assigned by: " + (teacher != null ? teacher.toString() : "Unknown"));
    }
    ///edit assignment
    public void editAssignment() {
    
        System.out.println("Editing Assignment ID: " + id);
        System.out.print("Enter new Title (or press Enter to keep current): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.isEmpty()) this.title = newTitle;
    
        System.out.print("Enter new Description (or press Enter to keep current): ");
        String newDescription = scanner.nextLine();
        if (!newDescription.isEmpty()) this.description = newDescription;
    
        System.out.print("Enter new Score (or -1 to keep current): ");
        float newScore = scanner.nextFloat();
        if (newScore != -1) this.score = newScore;
    
        System.out.println("Assignment updated successfully!");
    }
    //delete assignment
    public void deleteAssignment() {
        this.id = -1;
        this.courseId = -1;
        this.title = null;
        this.description = null;
        this.score = 0.0f;
        this.teacher = null;
        
        System.out.println("Assignment deleted successfully.");
    }
    //submit assignment
    public void submitAssignment(String studentName) {
        System.out.println(studentName + " has submitted the assignment: " + title);
    }
    //grade assignment  
    public void gradeAssignment(String studentName, float grade) {
        System.out.println("Graded " + studentName + "'s assignment: " + title + " with score: " + grade);
    }
    //list assignment
    public void listAssignments(HashMap<Integer, Assignment> assignments) {
    if (assignments.isEmpty()) {
        System.out.println("No assignments available.");
        return;
    }
    System.out.println("List of Assignments:");
    for (Assignment a : assignments.values()) {
        a.displayAssignment();
        System.out.println("------------------------");
    }
}


    
}
