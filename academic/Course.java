package academic;

import user.Teacher;

public class Course {
    static int totalCourse;
    public int id;
    public String name;
    public String level;
    public float fee;
    public String description;
    private Quizz[] quizzes;
    private Assignment assignments;
    public Course(int id, String name, String level, float fee, String description) {
        totalCourse+=1;
        id = totalCourse;
        this.name = name;
        this.level = level;
        this.fee = fee;
        this.description = description;
    }
    public Quizz[] getQuizzes(int code) {
        return quizzes;
    }

    public void setQuizzes(Object user, Quizz[] quizzes) {
        if (user instanceof Teacher) {
            this.quizzes = quizzes;
        } else {
            System.out.println("Access denied: You Dont have permission!");
        }
    }

    public Assignment getAssignments() {
        return assignments;
    }
    public void setAssignments(Object user, Assignment ass) {
        if (user instanceof Teacher) {
            this.assignments = ass;
        } else {
            System.out.println("Access denied: You Dont have permission!");
        }
    }
}
