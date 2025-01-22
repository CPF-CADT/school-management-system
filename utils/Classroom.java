package utils;
public class Classroom {

    private String classId;
    private String className;
    private String teacher;
    private int capacity;

    public Classroom(String id, String className, String teacher, int capacity){
        this.classId = className;
        this.className = className;
        this.teacher = teacher;
        this.capacity = capacity;
    }

    public String getClassId(){
        return classId;
    }
    public String getClassName(){
        return className;
    }
    public String getTeacher(){
        return teacher;
    }
    public int getCapacity(){
        return capacity;
    }
    
    public void setClassId(String classId){
        this.classId = classId;
    }
    public void setClassName(String className){
        this.className = className;
    }
    public void setTeacher(String teacher){
        this.teacher = teacher;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
}
