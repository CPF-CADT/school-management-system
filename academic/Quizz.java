package academic;

import java.util.ArrayList;

import user.Student;
import user.Teacher;

public class Quizz {
    static int quizzNumber=0;
    public int courseId;
    public String title;
    private ArrayList<Question> tasks; 
    public Quizz(int id, int courseId, int score, String title) {
        quizzNumber++;
        id = quizzNumber;
        this.courseId = courseId;
        this.title = title;
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
}