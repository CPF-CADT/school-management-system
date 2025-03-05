package progress;

import academic.Question;
import academic.Quizz;

public class TestQuiz {
    public static void main(String[] args) {
        Quizz quiz = new Quizz(101, "General Knowledge Quiz", null, 100, "This is a general knowledge quiz");

        // add queion to quiz

        quiz.addTask(new Question("What is 2 + 2?", new String[]{"1", "2", "3", "4"}, 3));
        quiz.addTask(new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2));
        quiz.addTask(new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Venus", "Mars", "Jupiter"}, 2));
        quiz.addTask(new Question("How many legs does a spider have?", new String[]{"6", "8", "10", "12"}, 1));

        // Simulating a student taking the quiz
        quiz.attemp(101);
    }
}

