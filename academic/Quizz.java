package academic;

import java.util.ArrayList;

import user.Student;
import user.Teacher;

public class Quizz extends Assessment{
    static int quizzNumber=0;
    public int courseId;
    public String title;
    public float totalScore;
    private ArrayList<Question> tasks; 
    
    public Quizz(int id, int courseId, String title, Teacher teacher) {
        super(++quizzNumber, courseId, title, teacher); // Auto-increment ID
    }
    public Question getTask(int index) {
        return tasks.get(index);
    }
    public void addTask(Object user,Question task){
        if(user instanceof Teacher){
            this.tasks.add(task);
        }else{
            System.out.println("Access denied: You Dont have permission!");
        }
    }
    public float attemp(){
        float total =0.0f;
        int numberOfQuestion =0;
        for(Question task : tasks){
            numberOfQuestion++;
            System.out.println("Question  : "+numberOfQuestion);
            total += task.answerQuestion();
        }
        return total; 
    }
    @Override
    public void provideScore(float score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
            System.out.println("Score provided for Quiz: " + score);
        } else {
            System.out.println("Invalid score! Must be between 0 and 100.");
        }
    }
}// assign quiz provide score to student using abstract class
