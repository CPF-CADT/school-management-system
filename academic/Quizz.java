package academic;

import core.MySQLConnection;
import java.util.ArrayList;
import user.Teacher;

public class Quizz extends Assessment{
    private ArrayList<Question> tasks = new ArrayList<Question>(); 
    public Quizz(int courseId, String title, Teacher teacher, float score, String description) {
        super(courseId, title, teacher, score, description);
        
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
    public float attemp(String studentId){
        float total =0.0f;
        int numberOfQuestion =0;
        for(Question task : tasks){
            numberOfQuestion++;
            System.out.println("Question  : "+numberOfQuestion);
            total += task.answerQuestion();
        }
        return total; 
    }
    // @Override
    //add student score

    public void addStudentScore(String studentId, float score) {
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
    // @Override
    // public void addStudentScore(String studentId, float score) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'addStudentScore'");
    // }

    // public  void createQuiz(){
        
    //     System.out.println("How many question you want to add?");
    //     int n = input.nextInt();
    //     for(int i=0;i<n;i++){
    //         System.out.println("Input question "+(i+1));
    //         String question = input.next();
    //         System.out.println("Input marks"+(i+1));
    //         double marks = input.nextFloat();
    //         System.out.println("Input correct answer"+(i+1));
    //         char correctAnswer = input.next().charAt(0);
    //         System.out.println("Input 4choices "+(i+1));
    //         String[] choices = new String[4];
    //         for (int j = 0; j < 4; j++) {
    //             char label = (char) ('a' + j);
    //             System.out.print(label + ") ");
    //             choices[j] = input.next();
    //         }
    //         // tasks.add(q);

    //     }
    // }
}
