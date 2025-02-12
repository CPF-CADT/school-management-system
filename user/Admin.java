package user;

import java.util.HashMap;

public class Admin extends User{
    final static String EMAIL_FORMAT = "@adm.kdc.edu";
    public String role;
    static HashMap<Integer,Admin> listOfAdmins = new HashMap<Integer,Admin>();
    Admin(){
        
    }
    public Admin(String firstName, String lastName, String address , String phoneNumber, String role) {
        super(lastName, firstName, address, phoneNumber,EMAIL_FORMAT);
        this.role = role;
        listOfAdmins.put(id,this);
    }
    public Admin(String email,String password) {
        super(email,password);
    }
    @Override
    public String toString() {
        return super.toString() + "  Role : " + this.role;
    }
    public static Admin login(Admin t){
        for(Admin adm :listOfAdmins.values()){
            if(t.equals(adm)){
                return adm;
            }
        }
        return null;
    }
}
