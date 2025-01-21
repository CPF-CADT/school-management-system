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

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public float getScore() {
        return score;
    }
    public void setScore(float score) {
        this.score = score;
    }

}
