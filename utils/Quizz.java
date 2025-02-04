package utils;
public class Quizz {
    static int id=0;
    public int courseId;
    public float score;
    public String title;
    public Question[] task; 
    public Quizz(int id, int courseId, int score, String title) {
        id = id+1;
        this.courseId = courseId;
        this.score = score;
        this.title = title;
    }
}