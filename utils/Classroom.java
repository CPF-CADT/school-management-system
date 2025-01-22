package utils;
public class Classroom {

    private String idClass;
    private String nameClass;
    private String teacher;
    private int capacity;

    public Classroom(String idClass, String className, String teacher, int capacity){
        this.idClass = className;
        this.nameClass = className;
        this.teacher = teacher;
        this.capacity = capacity;
    }

    public String getClassId(){
        return idClass;
    }
    public String getClassName(){
        return nameClass;
    }
    public String getTeacher(){
        return teacher;
    }
    public int getCapacity(){
        return capacity;
    }

    public void setClassId(String idClass){
        this.idClass = idClass;
    }
    public void setClassName(String nameClass){
        this.nameClass = nameClass;
    }
    public void setTeacher(String teacher){
        this.teacher = teacher;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
}
