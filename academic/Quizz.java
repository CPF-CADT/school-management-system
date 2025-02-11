package academic;

import java.util.ArrayList;

import user.Teacher;

public class Quizz {
    static int quizzNumber=0;
    public int courseId;
    public String title;
    private ArrayList<Question> task; 
    public Quizz(int id, int courseId, int score, String title) {
        quizzNumber++;
        id = quizzNumber;
        this.courseId = courseId;
        this.title = title;
    }
    public Question getTask(int index) {
        return task.get(index);
    }
    public void addTask(Object user,Question task){
        if(user instanceof Teacher){
            this.task.add(task);
        }else{
            System.out.println("Access denied: You Dont have permission!");
        }
    }
}