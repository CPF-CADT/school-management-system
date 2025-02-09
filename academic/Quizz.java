package academic;
public class Quizz {
    static int quizzNumber=0;
    public int courseId;
    public String title;
    private Question[] task; 
    public Quizz(int id, int courseId, int score, String title) {
        quizzNumber++;
        id = quizzNumber;
        this.courseId = courseId;
        this.title = title;
    }
}