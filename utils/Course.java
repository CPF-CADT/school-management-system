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

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    public float getPayment() {
        return payment;
    }
    public void setPayment(float payment) {
        this.payment = payment;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
