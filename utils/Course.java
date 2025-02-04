package utils;
public class Course {
    static int totalCourse;
    public int id;
    public String name;
    public String level;
    public float fee;
    public String description;
    private int securityCode;
    private Quizz[] quizzes;
    private Assignment[] assignments;
    public Course(int id, String name, String level, float fee, String description,int securityCode) {
        this.securityCode = securityCode;
        totalCourse+=1;
        id = totalCourse;
        this.name = name;
        this.level = level;
        this.fee = fee;
        this.description = description;
    }
    public Course(int id,String name,String level,float fee,int securityCode) {
        totalCourse+=1;
        id = totalCourse;
        this.name = name;
        this.level = level;
        this.fee = fee;
        this.securityCode = securityCode;
    }

    public Quizz[] getQuizzes(int code) {
        return quizzes;
    }

    public void setQuizzes(int code, Quizz[] quizzes) {
        if (this.securityCode == code) {
            this.quizzes = quizzes;
        } else {
            System.out.println("Access denied: Incorrect security code.");
        }
    }

    public Assignment[] getAssignments() {
        return assignments;
    }
    public void setAssignments(int code, Assignment[] assignments) {
        if (this.securityCode == code) {
            this.assignments = assignments;
        } else {
            System.out.println("Access denied: Incorrect security code.");
        }
    }
}
