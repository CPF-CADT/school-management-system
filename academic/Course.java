package academic;

public class Course {
    static int totalCourse;
    public int id;
    public String name;
    public String level;
    public float fee;
    public String description;
    public Course(int id, String name, String level, float fee, String description) {
        totalCourse+=1;
        id = totalCourse;
        this.name = name;
        this.level = level;
        this.fee = fee;
        this.description = description;
    }
    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", level=" + level + ", fee=" + fee + ", description="
                + description + "]";
    }
}
