package academic;

import java.util.ArrayList;

import core.MySQLConnection;
import user.Teacher;

public class Quizz extends Assessment{
    private ArrayList<Question> tasks; 
    
    public Quizz(int courseId, String title, Teacher teacher, float score,String description) {
        super(courseId, title, teacher,score,description);
        
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
    public float attemp(int studentId){
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
    //add student score

    public void addStudentScore(int studentId, float score) {
        totalScore = attemp(studentId);
        System.out.println("Student ID: " + studentId + " Totalscore: " + totalScore);
        studentScore.put(studentId, totalScore);
    }
    
        public boolean updateQuizzData(){
        String query = "UPDATE quizz SET description = '" + description + "' , title = '"+title+"' WHERE quizz_id = " + no;
        MySQLConnection.executeUpdate(query);
        return true;
    }

    public boolean updateDescriptionInQuizz(Quizz quizz) {
        System.out.println("Enter the new description: ");
        String newDescription = input.nextLine();
        description = newDescription;
        System.out.println(quizz);
        return quizz.updateQuizzData();
    }

    public boolean updateTitleInQuizz(Quizz quizz) {
        System.out.println("Enter the new title: ");
        String newTitle = input.nextLine();
        title = newTitle;
        System.out.println(quizz);
        return quizz.updateQuizzData();
    }
}
