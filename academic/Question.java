package academic;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import user.Teacher;

public class Question {
    Scanner input = new Scanner(System.in);
    private String prompt;
    public String question;
    private String[] options;
    protected float marks;
    private HashMap<Integer,String> answer = new HashMap<Integer,String>();
    public int correctAnswer;
    private static final int TIME_LIMIT = 15; 
    Question(String question,float marks,int correctAnswer){
        this.question = question;
        this.marks = marks;
        this.correctAnswer = correctAnswer;
    }
    // initialize question
    public Question(String prompt, String[] options, int correctAnswer) {
        this.prompt = prompt;
        this.options = options;
        this.correctAnswer = correctAnswer;
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
    public boolean askQuestion() {
        Scanner scanner = new Scanner(System.in);
        final boolean[] answered = {false}; // Track if the user answered in time
        System.out.println(" " + prompt);
        System.out.println("=================================");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println("=================================");
        System.out.println("\n You have " + TIME_LIMIT + " seconds to answer...\n");  
        System.out.println("=================================");
        // Timer and countdown
        
        Timer timer = new Timer();
        final int[] remainingTime = {TIME_LIMIT};
        TimerTask countdownTask = new TimerTask() {
            @Override
            public void run() {
                if (!answered[0]) {
                    System.out.print("\r Time Left " + remainingTime[0] + ")");
                    
                    System.out.print("                ");
                    System.out.print(" Please enter  answer: ");
                    remainingTime[0]--;
                    if (remainingTime[0] < 0) {
                        System.out.println("\n times up, the correct answer is: " + options[correctAnswer]);
                        answered[0] = true;
                        System.out.println("\n Press ENTER to continue to the next question...");
                        scanner.nextLine();
                        timer.cancel();
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(countdownTask, 0, 1000); //update every 1 second
        System.out.print("\n Your answer (1-4): ");
        int choice;
        long startTime = System.currentTimeMillis();
        while (true) {
            if (answered[0]) {
                break; // Stop waiting if time is up
            }
            if (System.currentTimeMillis() - startTime >= TIME_LIMIT * 1000) {
                break; // Stop waiting for input if time is up
            }
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt() - 1; // Convert to 0-based index
                answered[0] = true; // Mark as answered
                timer.cancel(); // Stop the timer
                if (choice == correctAnswer) {
                    System.out.println("\n Correct! Moving to next question...\n");
                    return true;
                } else {
                    System.out.println("\n Incorrect! The correct answer was: " + options[correctAnswer]);
                    break;
                }
            }
        }
        scanner.nextLine(); // new line
        System.out.println("\n Press ENTER to continue...");
        scanner.nextLine(); // Wait for user to press Enter
        return false; // If time runs out before an answer is entered
    }
}
