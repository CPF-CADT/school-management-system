package utils;
public class Assignment {
    private int id;
    private int courseId;
    private String title;
    private String description;
    private float score;

    public Assignment(int id, int courseId, String title, String description, float score) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.score = score;
    }
}
