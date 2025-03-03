package academic;

import user.Teacher;
import user.User;

public class Grading {
    protected String assesmentType;
    // protected Date date
    protected  int sessionNumber; //will  auto
    protected float score;

    public Grading(){

    }

    public Grading(String assesmentType, int sessionNumber, float score) {
        this.assesmentType = assesmentType;
        this.sessionNumber = sessionNumber;
        this.score = score;
    }
    public void setScore(User user,float score) {
        if(user instanceof Teacher){
            this.score = score;
        }else{
            System.out.println("Access denied : Only Teacher");
        }

    }
    public String getAssesmentType() {
        return assesmentType;
    }
    public int getSessionNumber() {
        return sessionNumber;
    }
    public float getScore() {
        return score;
    }
    
}
