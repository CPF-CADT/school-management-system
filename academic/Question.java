package academic;
import core.MySQLConnection;
import java.util.HashMap;
import java.util.Scanner;

import user.Teacher;

public class Question {
    Scanner input = new Scanner(System.in);
    public String question;
    protected float marks;
    private HashMap<Integer,String> answer = new HashMap<Integer,String>();
    public int correctAnswer;
    Question(String question,float marks,int correctAnswer){
        this.question = question;
        this.marks = marks;
        this.correctAnswer = correctAnswer;
    }
    Question(){

    }
    public void createQuestion(Object user){
        if(user instanceof Teacher){
            System.out.print("Enter Question : ");
            question = input.nextLine();
            System.out.println("Enter Answer");
            for(int i=0;i<4;i++){
                System.out.print((i+1)+". ");
                answer.put(i, input.nextLine());
            }
            System.out.print("Set Correct Answer (1-4) : ");
            correctAnswer = input.nextInt();
            System.out.print("Set Mark : ");
            marks = input.nextFloat();
        }else{
            System.out.println("Access denied: You Dont have permission!");
        }
    }
    public float answerQuestion(){
        System.out.println("Question : "+question);
        for(int i=0;i<4;i++){
            System.out.println((i+1) + ". "+answer.get(i));
        }
        System.out.print("Enter : ");
        if(correctAnswer == input.nextInt()){
            return marks;
        }
        return 0.0f;
    }
    public boolean updateQuestionData(){
        String query = "UPDATE question SET question = '" + question + "' , marks = '"+marks+"' WHERE question_id = " + no;
        MySQLConnection.executeUpdate(query);
        return true;
    }
    public boolean updateQuestion(Question question) {
        System.out.println("Enter the new question: ");
        String newQuestion = input.nextLine();
        this.question = newQuestion;
        System.out.println(question);
        return question.updateQuestionData();
    }
    public boolean updateMarks(Question question) {
        System.out.println("Enter the new marks: ");
        float newMarks = input.nextFloat();
        this.marks = newMarks;
        System.out.println(question);
        return question.updateQuestionData();
    }
}
