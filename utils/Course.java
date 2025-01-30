package utils;
public class Course {
    private int id;
    private String name;
    private String level;
    private float payment;
    private String description;

    public Course(int id, String name, String level, float payment, String description) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.payment = payment;
        this.description = description;
    }
    public Course(int id,String name,String level,float payment) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.payment = payment;
        this.description = "null";

    }
}
