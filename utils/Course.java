package utils;
public class Course {
    public int id;
    public String name;
    public String level;
    public float fee;
    public String description;

    public Course(int id, String name, String level, float fee, String description) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.fee = fee;
        this.description = description;
    }
    public Course(int id,String name,String level,float fee) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.fee = fee;
        this.description = "null";

    }
}
