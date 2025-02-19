package academic;

import user.Teacher;

public abstract class Assessable {
    public int id;
    public int courseId;
    public String title;
    public float score;
    public Teacher teacher;

    // Constructor
    public Assessable(int id, int courseId, String title, Teacher teacher) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.teacher = teacher;
    }

    // Abstract method to be implemented by subclasses
    public abstract void provideScore(float score);

    // Display assessment details
    public void displayAssessment() {
        System.out.println("Assessment ID: " + id);
        System.out.println("Course ID: " + courseId);
        System.out.println("Title: " + title);
        System.out.println("Score: " + score);
        System.out.println("Assigned by: " + (teacher != null ? teacher.toString() : "Anonymous"));
    }
}

