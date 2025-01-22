import utils.Classroom;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome To School");
        Classroom classroom = new Classroom("MATH123", "KDMV", "Heng", 90);
        System.out.println("Class ID: " + classroom.getClassId());
    }
}
