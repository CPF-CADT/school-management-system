package academic;
import java.util.HashMap;

public class Question {
    public String question;
    public float marks;
    public HashMap<Integer,String> answer = new HashMap<Integer,String>();
    public int correctAnswer;
    Question(String question,float marks,int correctAnswer){
        this.question = question;
        this.marks = marks;
        this.correctAnswer = correctAnswer;
    }
}
