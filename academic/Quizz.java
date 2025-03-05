package academic;

import java.util.ArrayList;
import user.Teacher;

public class Quizz extends Assessment{
    private ArrayList<Question> tasks; 
    
    public Quizz(int courseId, String title, Teacher teacher, float score,String description) {
        super(courseId, title, teacher,score,description);
        tasks = new ArrayList<Question>();
        
    }
    public Question getTask(int index) {
        return tasks.get(index);
    }
    public float attemp(int studentId) {
        float totalScore = 0.0f;
        int questionNumber = 1;
    
        for (Question task : tasks) {
            System.out.print("\n> Question " + questionNumber + " ");
            if (task.askQuestion()) {
                totalScore += 1;
            }
            questionNumber++;
        }

        System.out.println("Quiz Completed! Your Total Score: " + totalScore);
        return totalScore;
    }
    // public float attemp(int studentId){
    //     float total =0.0f;
    //     int numberOfQuestion =0;
    //     for(Question task : tasks){
    //         numberOfQuestion++;
    //         System.out.println("Question  : "+numberOfQuestion);
    //         total += task.answerQuestion();
    //     }
    //     return total; 
    // }

    public void addTask(Question task) {
        this.tasks.add(task);
    }
    
    @Override
    //add student score

    public void addStudentScore(int studentId, float score) {
        totalScore = attemp(studentId);
        System.out.println("Student ID: " + studentId + " Totalscore: " + totalScore);
        studentScore.put(studentId, totalScore);
    }
}
