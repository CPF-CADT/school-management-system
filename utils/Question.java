package utils;

import java.util.ArrayList;
import java.util.HashMap;
public class Question {
    private String question;
    private float marks;
    private HashMap<Integer,String> answer = new HashMap<Integer,String>();
    private int correctAnswer;
    Question(String question,float marks,int correctAnswer){
        this.question = question;
        this.marks = marks;
        this.correctAnswer = correctAnswer;
    }
}
