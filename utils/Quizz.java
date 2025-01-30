package utils;

import java.util.ArrayList;

public class Quizz {
    public int id;
    public int courseId;
    public float score;
    public String title;
    private Question[] task; //consider private
    public Quizz(int id, int courseId, int score, String title) {
        this.id = id;
        this.courseId = courseId;
        this.score = score;
        this.title = title;
    }
}

