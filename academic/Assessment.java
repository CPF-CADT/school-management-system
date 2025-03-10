package academic;

import core.MySQLConnection;
import java.util.HashMap;
import java.util.Scanner;
import user.Teacher;

public abstract class Assessment{
     Scanner input = new Scanner(System.in);
    public static int numberAssessments = 0;
    public int no;
    public int courseId;
    public String title;
    public float totalScore; 
    public Teacher teacher;
    public String description;

    //id key and value score
    public HashMap<Integer, Float> studentScore = new HashMap<Integer, Float>();

    // Constructor
    public Assessment(int courseId, String title, Teacher teacher,float score, String description) {
        numberAssessments+=1;
        this.no = numberAssessments;
        this.courseId = courseId;
        this.title = title;
        this.teacher = teacher;
        this.totalScore =  score;
        this.description = description;
    }

    //add student score
    public abstract void addStudentScore(int studentId, float score);

    //

    // Display assessment details
    public void displayAssessment() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Title: " + title);
        System.out.println("Score: " + totalScore);
        System.out.println("Assigned by: " + (teacher != null ? teacher.toString() : "Anonymous"));
    }




    




}

