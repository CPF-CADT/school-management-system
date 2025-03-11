package progress;

import academic.*;
import java.util.HashMap;
import user.Teacher;

public class testQuizz {
    public static void main(String[] args) {
        Teacher t2 = new Teacher(
                    "Jak",
                    "Jony",
                    "456 Elm St, CA",
                    "9876543210",
                    "Mathematics");
        // Create a quiz
        Quizz quiz = new Quizz(1, "Java Basics", null, 10, "A quiz on Java basics");
        HashMap<Character,String> a = new HashMap<>();
        a.put('A',"2");
        a.put('B',"3");
        a.put('C',"4");
        a.put('D',"5");

        Question q = new Question("1+1",10.0f,'A',a);
        // q.createQuestion(t2);
        quiz.addTask(t2, q);
        float sc = quiz.attemp("S1");
        System.out.println(sc);

}}
