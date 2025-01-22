package utils;

import java.util.ArrayList;

public class Quizz {
    private int id;
    private int courseId;
    private int score;
    private String title;
    private ArrayList<Question> task;
    public Quizz(int id, int courseId, int score, String title) {
        this.id = id;
        this.courseId = courseId;
        this.score = score;
        this.title = title;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}

