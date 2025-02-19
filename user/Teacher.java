package user;
 
// import java.util.HashMap;

public class Teacher extends User {
    final static String EMAIL_FORMAT = "@tch.kdc.edu";
    public String major;
    // login
    public Teacher(String email, String password) {
        super(email, password);
    }

    // register
    public Teacher(String firstName,String lastName, String address, String phoneNumber, String major) {
        super(firstName,lastName, address, phoneNumber,EMAIL_FORMAT);
        this.major = major;
        User.listUser.put(super.getID(), this);
    }

    @Override
    public String toString() {
        return super.toString() + "  major :" + major;
    }

    public static Teacher login(User t) {
        
        for (User teacher : User.listUser.values()) {
            if (t.equals(teacher)) {
                return (Teacher) teacher;
            }
        }
        return null;
    }

    @Override
    public void displayUserInfo(){
        super.displayUserInfo();
        System.out.println("Major        : " + major);
        System.out.println("====================================\n");
    }
}
